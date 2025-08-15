package com.example.demo.model;

import org.junit.jupiter.api.Test;
import java.sql.Time;
import static org.junit.jupiter.api.Assertions.*;

public class HorarioTest {

    @Test
    public void testConstructorVacio() {
        Horario horario = new Horario();
        assertNotNull(horario);
        assertEquals(0, horario.getId());
        assertNull(horario.getHora_inicio());
        assertNull(horario.getHora_fin());
    }

    @Test
    public void testConstructorConParametros() {
        Time inicio = Time.valueOf("09:00:00");
        Time fin = Time.valueOf("10:30:00");
        Horario horario = new Horario(inicio, fin);

        assertEquals(inicio, horario.getHora_inicio());
        assertEquals(fin, horario.getHora_fin());
    }

    @Test
    public void testGettersYSetters() {
        Horario horario = new Horario();
        Time inicio = Time.valueOf("17:00:00");
        Time fin = Time.valueOf("18:00:00");

        horario.setId(1);
        horario.setHora_inicio(inicio);
        horario.setHora_fin(fin);

        assertEquals(1, horario.getId());
        assertEquals(inicio, horario.getHora_inicio());
        assertEquals(fin, horario.getHora_fin());
    }
}