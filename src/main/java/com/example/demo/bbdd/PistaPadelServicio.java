package com.example.demo.bbdd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PistaPadel;

@Repository
public class PistaPadelServicio {
	@Autowired
	PistaPadelRepositorio pr;
	
	public PistaPadel getPista(String nombre) {
		PistaPadel u = pr.findByNombre(nombre);
		return u;	
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
	
}
