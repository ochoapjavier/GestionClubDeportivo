package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Deporte;
import com.example.demo.servicios.DeporteServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/deportes"})
public class ControladorDeporte {
	@Autowired
	private DeporteServicio ds;
	
	
	@GetMapping()
	 List<Deporte> listarHorarios() {
	    return ds.listarDeportes();
	  }
	

	 
}
