package org.example.oscarapp.exception;

public class CocheNotFoundException extends RuntimeException {

    public CocheNotFoundException(Long id) {
        super("No se encontró ningún coche con el id: " + id);
    }
}