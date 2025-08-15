package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeporteTest {

    @Test
    public void testConstructorVacio() {
        Deporte deporte = new Deporte();
        assertNotNull(deporte);
        assertEquals(0, deporte.getId());
        assertNull(deporte.getNombre());
    }

    @Test
    public void testConstructorConNombre() {
        Deporte deporte = new Deporte("Fútbol");
        assertEquals("Fútbol", deporte.getNombre());
    }

    @Test
    public void testGettersYSetters() {
        Deporte deporte = new Deporte();
        deporte.setId(1);
        deporte.setNombre("Baloncesto");

        assertEquals(1, deporte.getId());
        assertEquals("Baloncesto", deporte.getNombre());
    }
}