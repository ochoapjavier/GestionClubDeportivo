package com.example.demo.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.EstadoCompeticiones;
import com.example.demo.servicios.EstadoServicio;

@RestController
@RequestMapping({"/estados"})
public class ControladorEstado {
	
	@Autowired
	private EstadoServicio es;
	
	@GetMapping()
	 ResponseEntity<List<EstadoCompeticiones>> listarEstados() {
	    return ResponseEntity.ok(es.listarEstados());
	  }
	
}
