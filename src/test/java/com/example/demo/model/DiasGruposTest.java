package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiasGruposTest {

    @Test
    public void testConstructorVacio() {
        DiasGrupos diasGrupos = new DiasGrupos();
        assertNotNull(diasGrupos);
        assertEquals(0, diasGrupos.getId());
        assertNull(diasGrupos.getDia());
    }

    @Test
    public void testGettersYSetters() {
        DiasGrupos diasGrupos = new DiasGrupos();
        diasGrupos.setId(1);
        diasGrupos.setDia("Lunes y Miércoles");

        assertEquals(1, diasGrupos.getId());
        assertEquals("Lunes y Miércoles", diasGrupos.getDia());
    }
}