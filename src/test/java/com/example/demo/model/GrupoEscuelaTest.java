package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

public class GrupoEscuelaTest {

    private GrupoEscuela grupoEscuela;

    @BeforeEach
    public void setUp() {
        grupoEscuela = new GrupoEscuela();
    }

    @Test
    public void testConstructorVacio() {
        assertNotNull(grupoEscuela);
        assertEquals(0, grupoEscuela.getId());
        assertNull(grupoEscuela.getNombre());
    }

    @Test
    public void testGettersYSetters() {
        Usuario monitor = new Usuario();
        monitor.setId(1);
        monitor.setNombre("Carlos");

        Deporte deporte = new Deporte("Pádel");
        deporte.setId(1);

        DiasGrupos dias = new DiasGrupos();
        dias.setId(1);
        dias.setDia("Martes y Jueves");

        Horario horario = new Horario(Time.valueOf("10:00:00"), Time.valueOf("11:00:00"));
        horario.setId(1);

        grupoEscuela.setId(10);
        grupoEscuela.setNombre("Iniciación Pádel");
        grupoEscuela.setId_monitor(monitor);
        grupoEscuela.setId_deporte(deporte);
        grupoEscuela.setCapacidad(8);
        grupoEscuela.setId_dias_grupo(dias);
        grupoEscuela.setId_horario(horario);

        assertEquals(10, grupoEscuela.getId());
        assertEquals("Iniciación Pádel", grupoEscuela.getNombre());
        assertEquals(monitor, grupoEscuela.getId_monitor());
        assertEquals(deporte, grupoEscuela.getId_deporte());
        assertEquals(8, grupoEscuela.getCapacidad());
        assertEquals(dias, grupoEscuela.getId_dias_grupo());
        assertEquals(horario, grupoEscuela.getId_horario());
    }
}