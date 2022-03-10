package com.example.demo.bbdd;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Pista;
import com.example.demo.model.Usuario;

public class PistaServicio {
	@Autowired
	PistaRepositorio pr;
	
	public Pista getPista(String nombre) {
		Pista u = pr.findByNombre(nombre);
		return u;	
	}
	
	public Boolean savePista(Pista p) {
		if (!pr.saveAndFlush(p).equals(null)) {
			return true;
		}
		return false;
	}
	
}
