package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public List<GrupoEscuela> listarGruposByMonitorId(int id_monitor){
		return gr.findGruposByMonitorId(id_monitor);
	}
	
	public List<GrupoEscuela> listarGruposByUsuarioId(int id_usuario){
		return gr.findGruposByUsuarioId(id_usuario);
	}
	
	public GrupoEscuela listarGrupoById(int id_usuario){
		return gr.findById(id_usuario);
	}
	
	public Boolean saveGrupo(GrupoEscuela grupo) {
		if (!gr.saveAndFlush(grupo).equals(null)) {
			return true;
		}
		return false;
	}
	
	public GrupoEscuela findById(int id) {
		return gr.findById(id);
	}
	
	public Boolean eliminarGrupo(int id) {		
		try {
			gr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
