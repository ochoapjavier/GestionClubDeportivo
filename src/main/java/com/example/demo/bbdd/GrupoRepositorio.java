package com.example.demo.bbdd;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GrupoEscuela;


@Repository
public interface GrupoRepositorio extends JpaRepository<GrupoEscuela, Integer> {
	
	@Query(value="SELECT * FROM grupo_escuela WHERE id_monitor = :id_monitor",nativeQuery = true)
	public List<GrupoEscuela> findGruposByMonitorId(@Param("id_monitor") int id_monitor);
	
	@Query(value="SELECT GE.* \r\n"
			+ "	FROM grupo_escuela GE\r\n"
			+ "	INNER JOIN rel_grupo_alumnos RGA\r\n"
			+ "	ON GE.ID = RGA.id_grupo\r\n"
			+ "	WHERE RGA.id_alumno = :id_usuario",nativeQuery = true)
	public List<GrupoEscuela> findGruposByUsuarioId(@Param("id_usuario") int id_usuario);
	
	public GrupoEscuela findById(int id);
	
	
}
