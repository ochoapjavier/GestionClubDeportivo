package com.example.demo.bbdd;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Sesion;

@Repository
public interface SesionRepositorio extends JpaRepository<Sesion, Integer> {
	public Sesion findById(int id);
	
	@Query(value="SELECT S.* FROM `sesion` AS S INNER JOIN rel_grupo_alumnos AS RGA ON S.ID_GRUPO = RGA.ID_GRUPO WHERE ID_ALUMNO = :id_usuario",nativeQuery = true)
	public List<Sesion> listarSesionesByUserID(@Param("id_usuario") int id_usuario);
	
	@Query(value="SELECT S.* FROM `sesion` AS S INNER JOIN rel_grupo_alumnos AS RGA ON S.ID_GRUPO = RGA.ID_GRUPO WHERE ID_ALUMNO = :id_usuario AND FECHA >= CURDATE()",nativeQuery = true)
	public List<Sesion> listarSesionesFuturasByUserID(@Param("id_usuario") int id_usuario);

	@Query(value="SELECT S.* FROM SESION AS S INNER JOIN grupo_escuela AS GE ON S.id_grupo = GE.id WHERE GE.id_monitor = :id_monitor",nativeQuery = true)
	public List<Sesion> listarSesionesByMonitorID(@Param("id_monitor") int id_monitor);
	
	@Query(value="SELECT S.* FROM SESION AS S INNER JOIN grupo_escuela AS GE ON S.id_grupo = GE.id WHERE GE.id_monitor = :id_monitor AND FECHA >= CURDATE()",nativeQuery = true)
	public List<Sesion> listarSesionesFuturasByMonitorID(@Param("id_monitor") int id_monitor);
	
	@Query(value="SELECT S.* FROM SESION AS S INNER JOIN grupo_escuela AS GE ON S.id_grupo = GE.id WHERE GE.id_monitor = :id_monitor AND S.id_grupo = :id_grupo AND S.fecha = :fecha",nativeQuery = true)
	public Sesion getSesionByGrupoYFecha(@Param("id_monitor") int id_monitor, @Param("id_grupo") int id_grupo, @Param("fecha") LocalDate date);
}


