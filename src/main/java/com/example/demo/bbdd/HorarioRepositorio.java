package com.example.demo.bbdd;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Horario;

@Repository
public interface HorarioRepositorio extends JpaRepository<Horario, Integer> {
	@Query(value = "SELECT id, hora_inicio, hora_fin FROM Horario h \r\n"
			+ "WHERE ID NOT IN (\r\n"
			+ "  SELECT id_horario FROM Reserva_Pista rp \r\n"
			+ "  WHERE id_pista = ?1 AND FECHA = ?2\r\n"
			+ "  )", nativeQuery = true)
	List<Horario> findByIdPistaAndFecha(String id_pista, Date fecha);
	
}

