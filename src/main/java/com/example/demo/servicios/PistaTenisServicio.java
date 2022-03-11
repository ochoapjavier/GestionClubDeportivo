package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.PistaTenisRepositorio;
import com.example.demo.model.PistaTenis;
import com.example.demo.model.Usuario;

@Repository
public class PistaTenisServicio {
	@Autowired
	PistaTenisRepositorio pr;
	
	public PistaTenis getPista(String nombre) {
		PistaTenis u = pr.findByNombre(nombre);
		return u;	
	}
	
	public List<PistaTenis> listarPistas(){
		return pr.findAll();
	}
	
	public Boolean savePista(PistaTenis p) {
		if (!pr.saveAndFlush(p).equals(null)) {
			return true;
		}
		return false;
	}
	
}
