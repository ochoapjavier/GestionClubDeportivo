package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoCompeticionesTest {

    @Test
    public void testConstructorVacio() {
        EstadoCompeticiones estado = new EstadoCompeticiones();
        assertNotNull(estado);
        assertEquals(0, estado.getId());
        assertNull(estado.getEstado());
    }

    @Test
    public void testConstructorConNombre() {
        EstadoCompeticiones estado = new EstadoCompeticiones("En curso");
        assertEquals("En curso", estado.getEstado());
    }

    @Test
    public void testGettersYSetters() {
        EstadoCompeticiones estado = new EstadoCompeticiones();
        estado.setId(1);
        estado.setEstado("Finalizada");

        assertEquals(1, estado.getId());
        assertEquals("Finalizada", estado.getEstado());
    }
}