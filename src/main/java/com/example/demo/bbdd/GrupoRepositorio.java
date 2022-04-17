package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GrupoEscuela;


@Repository
public interface GrupoRepositorio extends JpaRepository<GrupoEscuela, Integer> {
	@Query(value="SELECT capacidad FROM grupo_escuela WHERE id = :idGrupo",nativeQuery = true)
	public int getCapacidadGrupoById(@Param("idGrupo") int idGrupo);
	
	@Query(value="SELECT inscritos FROM(SELECT ge.id, count(id_alumno) as inscritos FROM grupo_escuela ge INNER JOIN rel_grupo_alumnos rga ON ge.id = rga.id_grupo AND ge.id = :idGrupo GROUP BY 1) as t",nativeQuery = true)
	public int getInscritosGrupo(@Param("idGrupo") int idGrupo);
}
