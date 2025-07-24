package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RelGrupoAlumnosTest {

    @Test
    public void testConstructorVacio() {
        RelGrupoAlumnos rel = new RelGrupoAlumnos();
        assertNotNull(rel);
        assertEquals(0, rel.getId());
        assertNull(rel.getId_grupo());
        assertNull(rel.getId_alumno());
    }

    @Test
    public void testGettersYSetters() {
        RelGrupoAlumnos rel = new RelGrupoAlumnos();
        GrupoEscuela grupo = new GrupoEscuela();
        grupo.setId(5);
        grupo.setNombre("Grupo Avanzado");

        Usuario alumno = new Usuario();
        alumno.setId(101);
        alumno.setNombre("Ana");

        rel.setId(1);
        rel.setId_grupo(grupo);
        rel.setId_alumno(alumno);

        assertEquals(1, rel.getId());
        assertEquals(grupo, rel.getId_grupo());
        assertEquals(alumno, rel.getId_alumno());
    }
}