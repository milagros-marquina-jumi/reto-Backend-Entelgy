package com.java.entelgy.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.java.entelgy.controller.UsuarioControllersTest;
import com.java.entelgy.entity.ResponseUsuarioApi;
import com.java.entelgy.entity.Usuario;
import com.java.entelgy.services.UsuarioImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UsuarioImplTest {

    @Mock
    UsuarioImpl usuarioService;
    @Mock
    UsuarioControllersTest usuarioControllers;
    ResponseUsuarioApi response;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setEmail("george.bluth@reqres.in");
        usuario.setLastName("Bluth");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setEmail("janet.weaver@reqres.in");
        usuario2.setLastName("Weaver");

        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        usuario3.setEmail("emma.wong@reqres.in");
        usuario3.setLastName("Wong");

        Usuario usuario4 = new Usuario();
        usuario4.setId(4);
        usuario4.setEmail("eve.holt@reqres.in");
        usuario4.setLastName("Holt");

        Usuario usuario5 = new Usuario();
        usuario5.setId(5);
        usuario5.setEmail("charles.morris@reqres.in");
        usuario5.setLastName("Morris");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        usuarios.add(usuario5);

        response = new ResponseUsuarioApi();
        response.setData(usuarios);
    }

    @Test
    void testGetUsuarios() {
        when(usuarioService.getUsuarios(1, 5)).thenReturn(response);
        ResponseUsuarioApi resp = usuarioService.getUsuarios(1, 5);
        assertEquals(5, resp.getData().size());
    }

}