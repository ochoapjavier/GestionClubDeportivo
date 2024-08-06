package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.PistaPadelRepositorio;
import com.example.demo.model.PistaPadel;

@Repository
public class PistaPadelServicio {
	
	@Autowired
	PistaPadelRepositorio pr;
	
	public PistaPadel getPista(String nombre) {
		PistaPadel u = pr.findByNombre(nombre);
		return u;	
	}
	
	public Optional<PistaPadel> findById(String id) {
		return pr.findById(id);
	}
	
	public List<PistaPadel> listarPistas(){
		return pr.findAll();
	}
	
	public Boolean savePista(PistaPadel p) {
		if (!pr.saveAndFlush(p).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean actualizarPistaPadel(PistaPadel p) {
		
		if (!pr.save(p).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean eliminarPistaPadel(String id) {		
		try {
			pr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
