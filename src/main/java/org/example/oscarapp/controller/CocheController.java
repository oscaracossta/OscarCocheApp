package org.example.oscarapp.controller;

import jakarta.validation.Valid;
import org.example.oscarapp.model.Coche;
import org.example.oscarapp.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    @Autowired
    private CocheService service;

    // CREATE - POST /api/coches
    @PostMapping
    public Coche crear(@Valid @RequestBody Coche coche) {
        return service.guardarCoche(coche);
    }

    // READ - GET /api/coches
    @GetMapping
    public List<Coche> listarTodos() {
        return service.obtenerTodos();
    }

    // READ - GET /api/coches/{id}
    @GetMapping("/{id}")
    public Coche obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // UPDATE - PUT /api/coches/{id}
    @PutMapping("/{id}")
    public Coche actualizar(@PathVariable Long id, @Valid @RequestBody Coche coche) {
        return service.actualizarCoche(id, coche);
    }

    // DELETE - DELETE /api/coches/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarCoche(id);
        return ResponseEntity.noContent().build();
    }
}