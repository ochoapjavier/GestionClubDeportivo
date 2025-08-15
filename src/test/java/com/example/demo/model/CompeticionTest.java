package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompeticionTest {

    private Competicion competicion;
    private Deporte deporte;
    private EstadoCompeticiones estado;
    private TipoCompeticion tipo;

    @BeforeEach
    public void setUp() {
        competicion = new Competicion();
        deporte = new Deporte("Tenis");
        estado = new EstadoCompeticiones("Abierta");
        tipo = new TipoCompeticion("Liga");
    }

    @Test
    public void testConstructorVacio() {
        assertNotNull(competicion);
        assertEquals(0, competicion.getId());
        assertNull(competicion.getNombre_torneo());
    }

    @Test
    public void testConstructorConNombre() {
        Competicion competicionConNombre = new Competicion("Torneo de Verano");
        assertEquals("Torneo de Verano", competicionConNombre.getNombre_torneo());
    }

    @Test
    public void testGettersYSetters() {
        competicion.setId(1);
        competicion.setNombre_torneo("Torneo Anual");
        competicion.setCategoria("Senior");
        competicion.setDeporte_id(deporte);
        competicion.setEstado_id(estado);
        competicion.setTipo_competicion_id(tipo);
        competicion.setMax_jugadores(32);
        competicion.setId_fichero(10L);

        assertEquals(1, competicion.getId());
        assertEquals("Torneo Anual", competicion.getNombre_torneo());
        assertEquals("Senior", competicion.getCategoria());
        assertEquals(deporte, competicion.getDeporte_id());
        assertEquals(estado, competicion.getEstado_id());
        assertEquals(tipo, competicion.getTipo_competicion_id());
        assertEquals(32, competicion.getMax_jugadores());
        assertEquals(10L, competicion.getId_fichero());
    }
}