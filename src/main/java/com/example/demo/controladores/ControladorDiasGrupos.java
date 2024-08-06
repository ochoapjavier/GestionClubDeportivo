package com.example.demo.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.DiasGrupos;
import com.example.demo.servicios.DiasGruposServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/dias-grupos"})
public class ControladorDiasGrupos {
	
	@Autowired
	private DiasGruposServicio dgs;
		
	@GetMapping()
	 List<DiasGrupos> listarDiasGrupos() {
	    return dgs.listarDiasGrupos();
	  }
	 
}
