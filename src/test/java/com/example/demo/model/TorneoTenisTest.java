package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TorneoTenisTest {

    private TorneoTenis torneoTenis;

    @BeforeEach
    public void setUp() {
        torneoTenis = new TorneoTenis();
    }

    @Test
    public void testConstructorVacio() {
        assertNotNull(torneoTenis);
        assertEquals(0, torneoTenis.getId());
        assertNull(torneoTenis.getNombre_torneo());
        assertNull(torneoTenis.getCategoria());
        assertEquals(0, torneoTenis.getMax_jugadores());
    }

    @Test
    public void testGettersYSetters() {
        torneoTenis.setId(1);
        torneoTenis.setNombre_torneo("Open de la Ciudad");
        torneoTenis.setCategoria("Absoluta Masculina");
        torneoTenis.setMax_jugadores(64);

        assertEquals(1, torneoTenis.getId());
        assertEquals("Open de la Ciudad", torneoTenis.getNombre_torneo());
        assertEquals("Absoluta Masculina", torneoTenis.getCategoria());
        assertEquals(64, torneoTenis.getMax_jugadores());
    }

    @Test
    public void testToString() {
        torneoTenis.setId(2);
        torneoTenis.setNombre_torneo("Torneo Femenino");
        torneoTenis.setCategoria("Femenina");
        torneoTenis.setMax_jugadores(16);
        String expected = "TorneoTenis [id=2, nombre_torneo=Torneo Femenino, categoria=Femenina, max_jugadores=16]";
        assertEquals(expected, torneoTenis.toString());
    }
}