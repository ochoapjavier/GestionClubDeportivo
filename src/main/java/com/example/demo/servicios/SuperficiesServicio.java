package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.SuperficiesRepositorio;
import com.example.demo.model.Superficie;

@Repository
public class SuperficiesServicio {
	
	@Autowired
	SuperficiesRepositorio sr;
	
	public List<Superficie> listarSuperficies(){
		return sr.findAll();
	}
	
	public List<Superficie> listarSuperficiesDeporte(String deporte){
		return sr.findByDeporte(deporte);
	}
	
	public Boolean saveSuperficie(Superficie s) {
		if (!sr.saveAndFlush(s).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean actualizarSuperficie(Superficie s) {
		
		if (!sr.save(s).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean eliminarSuperficie(int id) {		
		try {
			sr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
