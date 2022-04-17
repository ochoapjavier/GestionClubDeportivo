package com.example.demo.controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bbdd.HorarioRepositorio;
import com.example.demo.model.Horario;

@RestController
public class ControladorHorario {
	@Autowired
	private HorarioRepositorio hr;
	
	 @GetMapping("/getHorariosDisp/{fecha}/{nombrePista}")
	 List<Horario> listaHorario(@PathVariable String fecha, @PathVariable String nombrePista) {
		 LocalDate conver = LocalDate.parse(fecha);
	    return hr.listaHorariosDisp(nombrePista, conver);
	  }
	 
}
