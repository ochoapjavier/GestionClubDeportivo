package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.DeporteRepositorio;
import com.example.demo.model.Deporte;

@Repository
public class DeporteServicio {
	@Autowired
	DeporteRepositorio dr;
	
	public List<Deporte> listarDeportes(){
		return dr.findAll();
	}
			
}
