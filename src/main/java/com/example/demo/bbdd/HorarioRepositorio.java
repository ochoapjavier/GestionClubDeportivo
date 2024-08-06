package com.example.demo.bbdd;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Horario;

@Repository
public interface HorarioRepositorio extends JpaRepository<Horario, Integer> {
	
	public Horario findById(int id);
	
	@Query(value="SELECT * FROM horario WHERE ID NOT IN (SELECT ID_HORARIO FROM reserva_pista WHERE ID_PISTA = :idPista AND FECHA = :fecha)",nativeQuery = true)
	public List<Horario> listaHorariosDisp(@Param("idPista") String idPista, @Param("fecha") LocalDate fecha);
}

