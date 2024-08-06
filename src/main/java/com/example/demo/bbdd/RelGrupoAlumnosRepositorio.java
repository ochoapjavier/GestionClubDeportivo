package com.example.demo.bbdd;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.RelGrupoAlumnos;

@Repository
public interface RelGrupoAlumnosRepositorio extends JpaRepository<RelGrupoAlumnos, Integer> {
	public RelGrupoAlumnos findById(int id);
	
	@Query(value="SELECT * FROM rel_grupo_alumnos WHERE id_grupo = :id_grupo",nativeQuery = true)
	public List<RelGrupoAlumnos> findRelGrupoAlumnosByIdGrupo(@Param("id_grupo") int id_grupo);
}
