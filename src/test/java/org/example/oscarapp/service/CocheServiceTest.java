package org.example.oscarapp.service;

import org.example.oscarapp.model.Coche;
import org.example.oscarapp.repository.CocheRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CocheServiceTest {

    @Mock
    private CocheRepository repository;

    @InjectMocks
    private CocheService service;

    private Coche coche;

    @BeforeEach
    void setUp() {
        coche = new Coche();
        coche.setId(1L);
        coche.setMarca("Toyota");
        coche.setModelo("Corolla");
        coche.setAnio(2022);
        coche.setMatricula("1234ABC");
    }

    @Test
    void testGuardarCoche() {
        when(repository.save(any(Coche.class))).thenReturn(coche);

        Coche guardado = service.guardarCoche(new Coche());

        assertNotNull(guardado);
        assertEquals("Toyota", guardado.getMarca());
        verify(repository, times(1)).save(any(Coche.class));
    }

    @Test
    void testObtenerTodos() {
        when(repository.findAll()).thenReturn(List.of(coche));

        List<Coche> lista = service.obtenerTodos();

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        verify(repository, times(1)).findAll();
    }
}