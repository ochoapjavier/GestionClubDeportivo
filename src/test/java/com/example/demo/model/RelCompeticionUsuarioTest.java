package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RelCompeticionUsuarioTest {

    @Test
    public void testConstructorVacio() {
        RelCompeticionUsuario rel = new RelCompeticionUsuario();
        assertNotNull(rel);
        assertEquals(0, rel.getId());
        assertNull(rel.getId_competicion());
        assertNull(rel.getId_usuario());
    }

    @Test
    public void testGettersYSetters() {
        RelCompeticionUsuario rel = new RelCompeticionUsuario();
        Competicion competicion = new Competicion("Torneo de Primavera");
        competicion.setId(1);
        Usuario usuario = new Usuario();
        usuario.setId(100);

        rel.setId(1);
        rel.setId_competicion(competicion);
        rel.setId_usuario(usuario);

        assertEquals(1, rel.getId());
        assertEquals(competicion, rel.getId_competicion());
        assertEquals(usuario, rel.getId_usuario());
    }
}