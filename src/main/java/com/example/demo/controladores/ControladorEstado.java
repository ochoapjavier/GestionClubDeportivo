package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EstadoCompeticiones;
import com.example.demo.servicios.EstadoServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/estados"})
public class ControladorEstado {
	@Autowired
	private EstadoServicio es;
	
	
	@GetMapping()
	 List<EstadoCompeticiones> listarEstados() {
	    return es.listarEstados();
	  }
	

	 
}
