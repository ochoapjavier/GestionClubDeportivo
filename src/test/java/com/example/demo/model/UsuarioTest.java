package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    
    private Usuario usuario;
    
    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
    }
    
    @Test
    public void testConstructorConParametros() {
        Usuario usuarioConParametros = new Usuario(
            "usuario@test.com",
            "password123",
            "Juan",
            "Pérez",
            "García",
            "Coordinador",
            1,
            1,
            1
        );
        
        assertEquals("usuario@test.com", usuarioConParametros.getEmail());
        assertEquals("password123", usuarioConParametros.getPassword());
        assertEquals("Juan", usuarioConParametros.getNombre());
        assertEquals("Pérez", usuarioConParametros.getApellido1());
        assertEquals("García", usuarioConParametros.getApellido2());
        assertEquals("Coordinador", usuarioConParametros.getRol());
        assertEquals(1, usuarioConParametros.getTerminos());
        assertEquals(1, usuarioConParametros.getPrivacidad());
        assertEquals(1, usuarioConParametros.getComercial());
    }
    
    @Test
    public void testConstructorVacio() {
        assertNotNull(usuario);
        assertNull(usuario.getEmail());
        assertNull(usuario.getNombre());
        assertNull(usuario.getApellido1());
        assertNull(usuario.getApellido2());
        assertNull(usuario.getPassword());
        assertNull(usuario.getRol());
        assertEquals(0, usuario.getTerminos());
        assertEquals(0, usuario.getPrivacidad());
        assertEquals(0, usuario.getComercial());
    }
    
    @Test
    public void testGettersYSetters() {
        usuario.setEmail("usuario@test.com");
        usuario.setNombre("Juan");
        usuario.setApellido1("Pérez");
        usuario.setApellido2("García");
        usuario.setPassword("password123");
        usuario.setRol("Monitor");
        usuario.setTerminos(1);
        usuario.setPrivacidad(1);
        usuario.setComercial(1);
        usuario.setId_fichero(5L);
        
        assertEquals("usuario@test.com", usuario.getEmail());
        assertEquals("Juan", usuario.getNombre());
        assertEquals("Pérez", usuario.getApellido1());
        assertEquals("García", usuario.getApellido2());
        assertEquals("password123", usuario.getPassword());
        assertEquals("Monitor", usuario.getRol());
        assertEquals(1, usuario.getTerminos());
        assertEquals(1, usuario.getPrivacidad());
        assertEquals(1, usuario.getComercial());
        assertEquals(5L, usuario.getId_fichero());
    }
    
    @Test
    public void testIdInicial() {
        assertEquals(0, usuario.getId());
    }
}
