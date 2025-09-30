package com.example.demo.bbdd;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ReservaPista;

@Repository
public interface ReservaPistaRepositorio extends JpaRepository<ReservaPista, Integer> {

	public ReservaPista findById(int id);
	
	@Query(value="SELECT * FROM reserva_pista WHERE FECHA = :fecha",nativeQuery = true)
	public List<ReservaPista> findByFecha(@Param("fecha") LocalDate fecha);
	
	@Query(value="SELECT * FROM ( SELECT RP.* FROM reserva_pista RP INNER JOIN horario H ON RP.id_horario = H.id ) AS T WHERE ID_PISTA = :idPista AND FECHA = :fecha",nativeQuery = true)
	public List<ReservaPista> listaPistasByIdFecha(@Param("idPista") String idPista, @Param("fecha") LocalDate fecha);
	
	@Query(value="SELECT * FROM reserva_pista WHERE ID_USUARIO = :id_usuario",nativeQuery = true)
	public List<ReservaPista> findByIdUsuario(@Param("id_usuario") int id_usuario);
}


