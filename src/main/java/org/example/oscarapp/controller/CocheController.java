package org.example.oscarapp.controller;

import org.example.oscarapp.model.Coche;
import org.example.oscarapp.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    @Autowired
    private CocheService service;

    // Endpoint para guardar (POST: http://localhost:8080/api/coches)
    @PostMapping
    public Coche crear(@RequestBody Coche coche) {
        return service.guardarCoche(coche);
    }

    // Endpoint para listar (GET: http://localhost:8080/api/coches)
    @GetMapping
    public List<Coche> listarTodos() {
        return service.obtenerTodos();
    }
}