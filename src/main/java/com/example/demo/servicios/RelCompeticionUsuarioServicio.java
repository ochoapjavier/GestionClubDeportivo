package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.RelCompeticionUsuarioRepositorio;
import com.example.demo.model.RelCompeticionUsuario;

@Repository
public class RelCompeticionUsuarioServicio {
	
	@Autowired
	RelCompeticionUsuarioRepositorio rcur;
	
	public List<RelCompeticionUsuario> listarRelCompeticionUsuario(){
		return rcur.findAll();
	}
	
	public RelCompeticionUsuario findById(int id) {
		return rcur.findById(id);
	}
	
	public Boolean saveRelCompeticionUsuario(RelCompeticionUsuario rcu) {
		if (!rcur.saveAndFlush(rcu).equals(null)) {
			return true;
		}
		return false;
	}
		
}
