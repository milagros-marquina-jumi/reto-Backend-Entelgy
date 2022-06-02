package com.java.entelgy.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.entelgy.entity.ResponseUsuarioApi;
import com.java.entelgy.entity.Usuario;
import com.java.entelgy.util.PropertiesExternos;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImpl implements IUsuario {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private PropertiesExternos propExt;

    String jsonPayload;

    @Override
    public ResponseUsuarioApi getUsuarios(Integer page, Integer perPage) {

        ResponseUsuarioApi response = new ResponseUsuarioApi();
        Usuario usuario = new Usuario();
        try {
            Gson gson = new Gson();
            Client client = Client.create();
            WebResource webResource = client
                    .resource(propExt.api1 + page + propExt.api2 + perPage);
            ClientResponse clientResponse = webResource.accept(propExt.json).get(ClientResponse.class);
            jsonPayload = clientResponse.getEntity(String.class);
            if (clientResponse.getStatus() == 200) {
                JsonObject json = gson.fromJson(jsonPayload, JsonObject.class);
                List<Usuario> usuarios = new ArrayList<Usuario>();
                for (int i = 0; i < json.get("data").getAsJsonArray().size(); i++) {
                    usuario = gson.fromJson(json.get("data").getAsJsonArray().get(i), Usuario.class);
                    usuario.setLastName(
                            json.get("data").getAsJsonArray().get(i).getAsJsonObject().get("last_name").getAsString());
                    usuarios.add(usuario);
                }
                response.setData(usuarios);
                logger.info(propExt.logStatus + clientResponse.getStatus());
                logger.info(propExt.logHeaders + clientResponse.getHeaders());
                logger.info(propExt.logBody + jsonPayload);
            } else {
                // notificar un response con el error

                logger.info(propExt.logStatus + clientResponse.getStatus());
                logger.info(propExt.logHeaders + clientResponse.getHeaders());
                logger.info(propExt.logBody + jsonPayload);
                System.err.println(jsonPayload);
                throw new Exception(propExt.error);
            }
        } catch (Exception e) {
            // TODO: handle exception
            String mensajeError = e.getMessage();
            logger.error(mensajeError);
        } finally {
            // propExt.finalizar
            logger.info(propExt.finalizar);
        }
        return response;
    }

}
