package com.java.entelgy.controller;

import java.util.HashMap;
import java.util.Map;

import com.java.entelgy.entity.RequestUsuarioApi;
import com.java.entelgy.entity.ResponseUsuarioApi;
import com.java.entelgy.services.IUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class UsuarioControllers {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    private IUsuario usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getUsuarios(@RequestBody RequestUsuarioApi request) {
        logger.info("getUsuarios");
        ResponseUsuarioApi usuario = null;
        Map<String, Object> response = new HashMap<>();
        try {
            usuario = usuarioService.getUsuarios(request.getPage(), request.getPerPage());
        } catch (Exception e) {
            logger.error("USUARIO CONTROLLER " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.info(response.toString());
        }
        if (usuario == null) {
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ResponseUsuarioApi>(usuario, HttpStatus.OK);
    }
}