package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class SesionTest {

    private Sesion sesion;

    @BeforeEach
    public void setUp() {
        sesion = new Sesion();
    }

    @Test
    public void testConstructorVacio() {
        assertNotNull(sesion);
        assertEquals(0, sesion.getId());
        assertNull(sesion.getId_grupo());
        assertNull(sesion.getFecha());
        assertNull(sesion.getTitulo());
        assertNull(sesion.getDescripcion());
    }

    @Test
    public void testGettersYSetters() {
        GrupoEscuela grupo = new GrupoEscuela();
        grupo.setId(8);
        Date fecha = new Date();

        sesion.setId(1);
        sesion.setId_grupo(grupo);
        sesion.setFecha(fecha);
        sesion.setTitulo("Técnica de Volea");
        sesion.setDescripcion("Ejercicios para mejorar la volea de derecha y revés.");

        assertEquals(1, sesion.getId());
        assertEquals(grupo, sesion.getId_grupo());
        assertEquals(fecha, sesion.getFecha());
        assertEquals("Técnica de Volea", sesion.getTitulo());
        assertEquals("Ejercicios para mejorar la volea de derecha y revés.", sesion.getDescripcion());
    }
}