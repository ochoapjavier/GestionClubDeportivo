package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuperficieTest {

    @Test
    public void testConstructorVacio() {
        Superficie superficie = new Superficie();
        assertNotNull(superficie);
        assertEquals(0, superficie.getId());
        assertNull(superficie.getNombre());
        assertNull(superficie.getDeporte());
    }

    @Test
    public void testConstructorConNombre() {
        Superficie superficie = new Superficie("Pista Rápida");
        assertEquals("Pista Rápida", superficie.getNombre());
    }

    @Test
    public void testGettersYSetters() {
        Superficie superficie = new Superficie();
        superficie.setId(1);
        superficie.setNombre("Hierba");
        superficie.setDeporte("Tenis");

        assertEquals(1, superficie.getId());
        assertEquals("Hierba", superficie.getNombre());
        assertEquals("Tenis", superficie.getDeporte());
    }
}