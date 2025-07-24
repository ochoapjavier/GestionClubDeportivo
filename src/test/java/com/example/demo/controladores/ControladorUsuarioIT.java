package com.example.demo.controladores;

import com.example.demo.bbdd.UsuarioRepositorio;
import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; 
import org.springframework.dao.DataIntegrityViolationException; 
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional // Cada test se ejecuta en su propia transacción, con rollback al final
@DisplayName("Pruebas de Integración para ControladorUsuario")
public class ControladorUsuarioIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario usuarioPrueba;

    @BeforeEach
    void setUp() {
        usuarioRepositorio.deleteAllInBatch();
        usuarioPrueba = new Usuario();
        usuarioPrueba.setEmail("integration@test.com");
        usuarioPrueba.setPassword("password123");
        usuarioPrueba.setNombre("Integration");
        usuarioPrueba.setApellido1("Test");
        usuarioPrueba.setRol("Usuario");
        usuarioPrueba.setTerminos(1);
        usuarioPrueba.setPrivacidad(1);
        usuarioPrueba.setComercial(0);

        // Guardamos el usuario en la base de datos para la transacción actual
        try {
            usuarioServicio.saveUsuario(usuarioPrueba);
        } catch (DataIntegrityViolationException e) {
            System.err.println("Usuario de prueba ya existe, saltando inserción en setUp: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("GET /usuarios - Debería devolver una lista de usuarios desde la BBDD")
    void testListarUsuarios_Integracion() throws Exception {
        mockMvc.perform(get("/usuarios").with(user("testuser").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email", is("integration@test.com")))
                .andExpect(jsonPath("$[0].nombre", is("Integration")))
                .andExpect(jsonPath("$[0].apellido1", is("Test")))
                .andExpect(jsonPath("$[0].rol", is("Usuario")))
                .andExpect(jsonPath("$[0].password").doesNotExist())
                .andExpect(jsonPath("$[0].terminos", is(1)))
                .andExpect(jsonPath("$[0].privacidad", is(1)))
                .andExpect(jsonPath("$[0].comercial", is(0)));
    }

    @Test
    @DisplayName("GET /usuarios/{id} - Debería devolver un usuario si existe")
    void testGetUsuarioById_Exito() throws Exception {
        // Aseguramos que el usuario de prueba esté en la base de datos para este test específico
        // Dado que @Transactional hace rollback, obtenemos el ID del usuario insertado en el setUp
        Usuario usuarioExistente = usuarioRepositorio.findByEmail("integration@test.com");
        assertNotNull(usuarioExistente, "El usuario de prueba debería existir para este test.");

        mockMvc.perform(get("/usuarios/{id}", usuarioExistente.getId()).with(user("testuser")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(usuarioExistente.getId())))
                .andExpect(jsonPath("$.email", is("integration@test.com")))
                .andExpect(jsonPath("$.password").doesNotExist());
    }

    @Test
    @DisplayName("GET /usuarios/{id} - Debería devolver 404 si el usuario no existe")
    void testGetUsuarioById_NoEncontrado() throws Exception {
        mockMvc.perform(get("/usuarios/{id}", 9999).with(user("testuser")))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /usuarios - Debería crear un nuevo usuario y devolver 201 Created")
    void testCrearUsuario_Exito() throws Exception {
        // Creamos un Map para simular el JSON que enviaría el cliente
        Map<String, Object> nuevoUsuarioMap = new HashMap<>();
        nuevoUsuarioMap.put("email", "nuevo@test.com");
        nuevoUsuarioMap.put("password", "passwordSegura");
        nuevoUsuarioMap.put("nombre", "Nuevo");
        nuevoUsuarioMap.put("apellido1", "Apellido1");
        nuevoUsuarioMap.put("apellido2", "Apellido2");
        nuevoUsuarioMap.put("rol", "Usuario");
        nuevoUsuarioMap.put("terminos", 1);
        nuevoUsuarioMap.put("privacidad", 1);
        nuevoUsuarioMap.put("comercial", 0);
        nuevoUsuarioMap.put("id_fichero", 0);

        // Verify initial state - no user with this email should exist
        Usuario existingUser = usuarioRepositorio.findByEmail("nuevo@test.com");
        assertNull(existingUser, "No user with this email should exist before creation");

        // Perform the POST request
        mockMvc.perform(post("/usuarios")
                        .with(user("testuser").roles("ADMIN")).with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nuevoUsuarioMap)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email", is("nuevo@test.com")))
                .andExpect(jsonPath("$.nombre", is("Nuevo")))
                .andExpect(jsonPath("$.apellido1", is("Apellido1")))
                .andExpect(jsonPath("$.rol", is("Usuario")))
                .andExpect(jsonPath("$.terminos", is(1)))
                .andExpect(jsonPath("$.privacidad", is(1)))
                .andExpect(jsonPath("$.comercial", is(0)))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").isNumber());

        // Verify the user was created in the database
        Usuario usuarioCreado = usuarioRepositorio.findByEmail("nuevo@test.com");
        assertNotNull(usuarioCreado, "User should be created in database");
        assertEquals("Nuevo", usuarioCreado.getNombre());
        assertEquals("Apellido1", usuarioCreado.getApellido1());
        assertEquals("Usuario", usuarioCreado.getRol());
        assertEquals(1, usuarioCreado.getTerminos());
        assertEquals(1, usuarioCreado.getPrivacidad());
        assertEquals(0, usuarioCreado.getComercial());
        
        // Verify password is encrypted
        assertTrue(usuarioCreado.getPassword().length() > 0, "Password should not be empty");
        assertFalse(usuarioCreado.getPassword().equals("passwordSegura"), "Password should be encrypted");
    }
    
    @Test
    @DisplayName("POST /usuarios - Debería devolver 409 Conflict si el email ya existe")
    void testCrearUsuario_Conflicto() throws Exception {
        // Verificar que el usuario de prueba existe en la base de datos
        Usuario usuarioExistente = usuarioRepositorio.findByEmail("integration@test.com");
        assertNotNull(usuarioExistente, "El usuario de prueba debería existir para este test.");
        assertEquals("Integration", usuarioExistente.getNombre(), "Nombre original del setUp");
        assertEquals("Usuario", usuarioExistente.getRol());

        // Creamos un Map para simular el JSON que enviaría el cliente
        Map<String, Object> usuarioDuplicadoMap = new HashMap<>();
        usuarioDuplicadoMap.put("email", "integration@test.com"); // Email que ya existe
        usuarioDuplicadoMap.put("password", "otraPassword");
        usuarioDuplicadoMap.put("nombre", "Duplicado");
        usuarioDuplicadoMap.put("apellido1", "Apellido1");
        usuarioDuplicadoMap.put("apellido2", "Apellido2");
        usuarioDuplicadoMap.put("rol", "Usuario");
        usuarioDuplicadoMap.put("terminos", 1);
        usuarioDuplicadoMap.put("privacidad", 1);
        usuarioDuplicadoMap.put("comercial", 0);
        usuarioDuplicadoMap.put("id_fichero", 0);

        // Intentar crear el usuario duplicado
        mockMvc.perform(post("/usuarios")
                        .with(user("testuser").roles("ADMIN")).with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuarioDuplicadoMap)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message", is("El email ya está en uso.")));
    }

    @Test
    @DisplayName("DELETE /usuarios/{id} - Debería eliminar un usuario")
    void testEliminarUsuario_Exito() throws Exception {
        Usuario usuarioExistente = usuarioRepositorio.findByEmail("integration@test.com");
        assertNotNull(usuarioExistente);

        mockMvc.perform(delete("/usuarios/{id}", usuarioExistente.getId())
                        .with(user("testuser").roles("ADMIN")).with(csrf()))
                .andExpect(status().isOk());

        // Verificamos que el usuario ha sido eliminado de la BBDD
        Usuario usuarioEliminado = usuarioRepositorio.findByEmail("integration@test.com");
        assertNull(usuarioEliminado);
    }
}