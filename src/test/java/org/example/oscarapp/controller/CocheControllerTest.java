package org.example.oscarapp.controller;

import org.example.oscarapp.model.Coche;
import org.example.oscarapp.service.CocheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CocheController.class)
public class CocheControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CocheService service;

    @Test
    void testListarTodosEndpoint() throws Exception {
        Coche coche = new Coche();
        coche.setMarca("Toyota");

        when(service.obtenerTodos()).thenReturn(List.of(coche));

        mockMvc.perform(get("/api/coches"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].marca").value("Toyota"));
    }
}