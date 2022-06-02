package com.java.entelgy.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.entelgy.entity.RequestUsuarioApi;
import com.java.entelgy.entity.ResponseUsuarioApi;
import com.java.entelgy.services.IUsuario;

@WebMvcTest(UsuarioControllers.class)
public class UsuarioControllersTest {

    @InjectMocks
    UsuarioControllers usuarioControllers;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUsuario usuarioService;

    ResponseUsuarioApi response;
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        objectMapper = new ObjectMapper();
      
    }

    @Test
    void testController() throws Exception {

        RequestUsuarioApi request = new RequestUsuarioApi();
        request.setPage(1);
        request.setPerPage(2);
        System.err.println(objectMapper.writeValueAsString(request));
        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").value(1))
                .andExpect(jsonPath("$.data[0].email").value("george.bluth@reqres.in"))
                .andExpect(jsonPath("$.data[0].lastName").value("Bluth"))
                .andExpect(jsonPath("$.data[1].id").value(2))
                .andExpect(jsonPath("$.data[1].email").value("janet.weaver@reqres.in"))
                .andExpect(jsonPath("$.data[1].lastName").value("Weaver"))
                .andExpect(jsonPath("$.data[2].id").value(3))
                .andExpect(jsonPath("$.data[2].email").value("emma.wong@reqres.in"))
                .andExpect(jsonPath("$.data[2].lastName").value("Wong"))
                .andExpect(jsonPath("$.data[3].id").value(4))
                .andExpect(jsonPath("$.data[3].email").value("eve.holt@reqres.in"))
                .andExpect(jsonPath("$.data[3].lastName").value("Holt"))
                .andExpect(jsonPath("$.data[4].id").value(5))
                .andExpect(jsonPath("$.data[4].email").value("charles.morris@reqres.in"))
                .andExpect(jsonPath("$.data[4].lastName").value("Morris"));
    }
}