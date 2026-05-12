package org.example.oscarapp.service;

import org.example.oscarapp.exception.CocheNotFoundException;
import org.example.oscarapp.model.Coche;
import org.example.oscarapp.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {

    @Autowired
    private CocheRepository repository;

    // CREATE
    public Coche guardarCoche(Coche coche) {
        return repository.save(coche);
    }

    // READ - todos
    public List<Coche> obtenerTodos() {
        return repository.findAll();
    }

    // READ - por id
    public Coche obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CocheNotFoundException(id));
    }

    // UPDATE
    public Coche actualizarCoche(Long id, Coche datosNuevos) {
        Coche existente = repository.findById(id)
                .orElseThrow(() -> new CocheNotFoundException(id));

        existente.setMarca(datosNuevos.getMarca());
        existente.setModelo(datosNuevos.getModelo());
        existente.setAnio(datosNuevos.getAnio());
        existente.setMatricula(datosNuevos.getMatricula());

        return repository.save(existente);
    }

    // DELETE
    public void eliminarCoche(Long id) {
        if (!repository.existsById(id)) {
            throw new CocheNotFoundException(id);
        }
        repository.deleteById(id);
    }
}