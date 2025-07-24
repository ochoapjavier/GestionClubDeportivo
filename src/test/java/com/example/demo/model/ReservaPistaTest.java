package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Time;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class ReservaPistaTest {

    private ReservaPista reservaPista;

    @BeforeEach
    public void setUp() {
        reservaPista = new ReservaPista();
    }

    @Test
    public void testConstructorVacio() {
        assertNotNull(reservaPista);
        assertEquals(0, reservaPista.getId());
        assertNull(reservaPista.getId_pista());
        assertNull(reservaPista.getFecha());
        assertNull(reservaPista.getId_horario());
        assertNull(reservaPista.getId_usuario());
    }

    @Test
    public void testGettersYSetters() {
        Date fecha = new Date();
        Horario horario = new Horario(Time.valueOf("19:00:00"), Time.valueOf("20:00:00"));
        horario.setId(3);
        Usuario usuario = new Usuario();
        usuario.setId(200);

        reservaPista.setId(1);
        reservaPista.setId_pista("PADEL_03");
        reservaPista.setFecha(fecha);
        reservaPista.setId_horario(horario);
        reservaPista.setId_usuario(usuario);

        assertEquals(1, reservaPista.getId());
        assertEquals("PADEL_03", reservaPista.getId_pista());
        assertEquals(fecha, reservaPista.getFecha());
        assertEquals(horario, reservaPista.getId_horario());
        assertEquals(usuario, reservaPista.getId_usuario());
    }
}