package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PistaTenisTest {

    private PistaTenis pistaTenis;
    private Superficie superficie;

    @BeforeEach
    public void setUp() {
        pistaTenis = new PistaTenis();
        superficie = new Superficie("Tierra Batida");
        superficie.setId(2);
    }

    @Test
    public void testConstructorVacio() {
        assertNotNull(pistaTenis);
        assertNull(pistaTenis.getId_pista());
        assertNull(pistaTenis.getNombre());
    }

    @Test
    public void testConstructorConParametros() {
        PistaTenis pistaConParams = new PistaTenis("Pista Principal", superficie);
        assertEquals("Pista Principal", pistaConParams.getNombre());
        assertEquals(superficie, pistaConParams.getId_superficie());
    }

    @Test
    public void testGettersYSetters() {
        pistaTenis.setId_pista("TENIS_01");
        pistaTenis.setNombre("Pista de Entrenamiento");
        pistaTenis.setId_superficie(superficie);

        assertEquals("TENIS_01", pistaTenis.getId_pista());
        assertEquals("Pista de Entrenamiento", pistaTenis.getNombre());
        assertEquals(superficie, pistaTenis.getId_superficie());
    }

    @Test
    public void testToString() {
        pistaTenis.setId_pista("TENIS_02");
        pistaTenis.setNombre("Pista 2");
        pistaTenis.setId_superficie(superficie);
        String expected = "PistaTenis [id_pista=TENIS_02, nombre=Pista 2, superficie=" + superficie + "]";
        assertEquals(expected, pistaTenis.toString());
    }
}