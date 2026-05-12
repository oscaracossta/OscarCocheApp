package org.example.oscarapp.service;

import org.example.oscarapp.model.Coche;
import org.example.oscarapp.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {

    @Autowired
    private CocheRepository repository;

    // Crear un coche en base de datos
    public Coche guardarCoche(Coche coche) {
        return repository.save(coche);
    }

    // Obtener todos los coches de la base de datos
    public List<Coche> obtenerTodos() {
        return repository.findAll();
    }
}