package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bbdd.TorneoTenisRepositorio;
import com.example.demo.model.TorneoTenis;


@RestController
public class ControladorTorneo {
	@Autowired
	private TorneoTenisRepositorio ttr;
	
	 @GetMapping("/getTorneosTenis")
	 List<TorneoTenis> listarTorneosTenis() {
		 System.out.println("Esto es una prueba");
	    return ttr.findAll();
	  }
}
