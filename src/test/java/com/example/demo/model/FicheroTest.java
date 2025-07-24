package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FicheroTest {

    @Test
    public void testConstructorVacio() {
        Fichero fichero = new Fichero();
        assertNotNull(fichero);
        assertEquals(0L, fichero.getId());
        assertNull(fichero.getFilename());
        assertNull(fichero.getType());
        assertNull(fichero.getData());
    }

    @Test
    public void testGettersYSetters() {
        Fichero fichero = new Fichero();
        byte[] data = "test data".getBytes();

        fichero.setId(1L);
        fichero.setFilename("documento.pdf");
        fichero.setType("application/pdf");
        fichero.setData(data);

        assertEquals(1L, fichero.getId());
        assertEquals("documento.pdf", fichero.getFilename());
        assertEquals("application/pdf", fichero.getType());
        assertArrayEquals(data, fichero.getData());
    }
}