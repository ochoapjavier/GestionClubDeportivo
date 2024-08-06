package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.DeporteRepositorio;
import com.example.demo.bbdd.DiasGruposRepositorio;
import com.example.demo.model.Deporte;
import com.example.demo.model.DiasGrupos;

@Repository
public class DiasGruposServicio {
	
	@Autowired
	DiasGruposRepositorio dgr;
	
	public List<DiasGrupos> listarDiasGrupos(){
		return dgr.findAll();
	}
			
}
