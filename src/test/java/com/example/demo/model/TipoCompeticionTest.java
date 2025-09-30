package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TipoCompeticionTest {

    @Test
    public void testConstructorVacio() {
        TipoCompeticion tipo = new TipoCompeticion();
        assertNotNull(tipo);
        assertEquals(0, tipo.getId());
        assertNull(tipo.getTipo());
    }

    @Test
    public void testConstructorConTipo() {
        TipoCompeticion tipo = new TipoCompeticion("Eliminatoria");
        assertEquals("Eliminatoria", tipo.getTipo());
    }

    @Test
    public void testGettersYSetters() {
        TipoCompeticion tipo = new TipoCompeticion();
        tipo.setId(1);
        tipo.setTipo("Round Robin");

        assertEquals(1, tipo.getId());
        assertEquals("Round Robin", tipo.getTipo());
    }
}