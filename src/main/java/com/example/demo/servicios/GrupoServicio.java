package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.GrupoRepositorio;
import com.example.demo.model.GrupoEscuela;

@Repository
public class GrupoServicio {
	@Autowired
	GrupoRepositorio gr;
	
	public List<GrupoEscuela> listarGrupos(){
		return gr.findAll();
	}
	
	public Boolean saveGrupo(GrupoEscuela p) {
		if (!gr.saveAndFlush(p).equals(null)) {
			return true;
		}
		return false;
	}
	
	public int getInscritosGrupo(int idGrupo) {
		return gr.getInscritosGrupo(idGrupo);
	}
	
	public int getCapacidadGrupo(int idGrupo) {
		return gr.getCapacidadGrupoById(idGrupo);
	}
	
}
