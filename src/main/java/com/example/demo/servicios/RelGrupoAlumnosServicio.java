package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.RelGrupoAlumnosRepositorio;
import com.example.demo.model.RelCompeticionUsuario;
import com.example.demo.model.RelGrupoAlumnos;

@Repository
public class RelGrupoAlumnosServicio {
	@Autowired
	RelGrupoAlumnosRepositorio rgar;
	
	public List<RelGrupoAlumnos> listarRelGrupoAlumnos(){
		return rgar.findAll();
	}
	
	public List<RelGrupoAlumnos> listarRelGrupoAlumnosByIdGrupo(int id_grupo){
		return rgar.findRelGrupoAlumnosByIdGrupo(id_grupo);
	}
	
	public Boolean saveInscripcionGrupo(RelGrupoAlumnos rga) {
		if (!rgar.saveAndFlush(rga).equals(null)) {
			return true;
		}
		return false;
	}
	
	public RelGrupoAlumnos findById(int id) {
		return rgar.findById(id);
	}
}
