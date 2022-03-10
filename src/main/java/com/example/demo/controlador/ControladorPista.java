package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.bbdd.PistaServicio;
import com.example.demo.model.Pista;

public class ControladorPista {
	@Autowired
	PistaServicio ps;
	
	@PostMapping ("/save-pista")
	public String savePista (@Validated Pista p, Model modelo) {
		ps.savePista(p);
		return "area-personal-coordinador";
	}
}
