package com.example.demo.servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	
	public List<Horario> listarHorariosDisp(String idPista, LocalDate fecha){
		return hr.listaHorariosDisp(idPista, fecha);
	}
			
}
