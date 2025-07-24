package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PistaPadelTest {

    private PistaPadel pistaPadel;
    private Superficie superficie;

    @BeforeEach
    public void setUp() {
        pistaPadel = new PistaPadel();
        superficie = new Superficie("Césped Artificial");
        superficie.setId(1);
    }

    @Test
    public void testConstructorVacio() {
        assertNotNull(pistaPadel);
        assertNull(pistaPadel.getId_pista());
        assertNull(pistaPadel.getNombre());
    }

    @Test
    public void testConstructorConParametros() {
        PistaPadel pistaConParams = new PistaPadel("Pista Central", superficie, "Cristal", "Cubierta");
        assertEquals("Pista Central", pistaConParams.getNombre());
        assertEquals(superficie, pistaConParams.getId_superficie());
        assertEquals("Cristal", pistaConParams.getTipoPared());
        assertEquals("Cubierta", pistaConParams.getCobertura());
    }

    @Test
    public void testGettersYSetters() {
        pistaPadel.setId_pista("PADEL_01");
        pistaPadel.setNombre("Pista 1");
        pistaPadel.setId_superficie(superficie);
        pistaPadel.setTipoPared("Muro");
        pistaPadel.setCobertura("Descubierta");

        assertEquals("PADEL_01", pistaPadel.getId_pista());
        assertEquals("Pista 1", pistaPadel.getNombre());
        assertEquals(superficie, pistaPadel.getId_superficie());
        assertEquals("Muro", pistaPadel.getTipoPared());
        assertEquals("Descubierta", pistaPadel.getCobertura());
    }

    @Test
    public void testToString() {
        pistaPadel.setId_pista("PADEL_02");
        pistaPadel.setNombre("Pista 2");
        pistaPadel.setId_superficie(superficie);
        pistaPadel.setTipoPared("Cristal");
        pistaPadel.setCobertura("Semi-cubierta");
        String expected = "PistaPadel [id_pista=PADEL_02, nombre=Pista 2, superficie=" + superficie + ", tipoPared=Cristal, cobertura=Semi-cubierta]";
        assertEquals(expected, pistaPadel.toString());
    }
}