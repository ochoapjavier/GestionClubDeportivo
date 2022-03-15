package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.HorarioRepositorio;
import com.example.demo.model.Horario;

@Repository
public class HorarioServicio {
	@Autowired
	HorarioRepositorio hr;
	
	public List<Horario> listarHorarios(){
		return hr.findAll();
	}
		
}
