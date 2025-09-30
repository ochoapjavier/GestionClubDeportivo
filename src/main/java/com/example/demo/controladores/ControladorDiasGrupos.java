package com.example.demo.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.DiasGrupos;
import com.example.demo.servicios.DiasGruposServicio;

@RestController
@RequestMapping({"/dias-grupos"})
public class ControladorDiasGrupos {
	
	@Autowired
	private DiasGruposServicio dgs;
		
	@GetMapping()
	 ResponseEntity<List<DiasGrupos>> listarDiasGrupos() {
	    return ResponseEntity.ok(dgs.listarDiasGrupos());
	  }
	 
}
