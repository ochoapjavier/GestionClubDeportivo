package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.TipoCompeticionRepositorio;
import com.example.demo.model.TipoCompeticion;

@Repository
public class TipoCompeticionServicio {
	
	@Autowired
	TipoCompeticionRepositorio tcr;
	
	public List<TipoCompeticion> listarTipoCompeticiones(){
		return tcr.findAll();
	}
			
}
