package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.EstadoRepositorio;
import com.example.demo.model.EstadoCompeticiones;

@Repository
public class EstadoServicio {
	
	@Autowired
	EstadoRepositorio er;
	
	public List<EstadoCompeticiones> listarEstados(){
		return er.findAll();
	}
			
}
