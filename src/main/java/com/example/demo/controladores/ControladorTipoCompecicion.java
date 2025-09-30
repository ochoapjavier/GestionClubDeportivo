package com.example.demo.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.TipoCompeticion;
import com.example.demo.servicios.TipoCompeticionServicio;

@RestController
@RequestMapping({"/tipo-competicion"})
public class ControladorTipoCompecicion {
	
	@Autowired
	private TipoCompeticionServicio tcs;
	
	@GetMapping()
	 ResponseEntity<List<TipoCompeticion>> listarTipoCompeticiones() {
	    return ResponseEntity.ok(tcs.listarTipoCompeticiones());
	  }
	 
}
