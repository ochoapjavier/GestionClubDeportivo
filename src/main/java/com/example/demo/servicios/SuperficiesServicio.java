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
	
}
