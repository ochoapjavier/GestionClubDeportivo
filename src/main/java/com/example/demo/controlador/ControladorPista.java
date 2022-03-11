package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.bbdd.PistaPadelServicio;
import com.example.demo.bbdd.PistaTenisServicio;
import com.example.demo.bbdd.SuperficiesServicio;
import com.example.demo.model.PistaPadel;
import com.example.demo.model.PistaTenis;

@Controller
public class ControladorPista {
	@Autowired
	PistaTenisServicio pts;
	@Autowired
	PistaPadelServicio pps;
	@Autowired
	SuperficiesServicio sr;
	
	@GetMapping({"/nueva-pista-tenis","/nueva-pista-tenis.html"})
	public String getNuevaPistaTenis(Model modelo) {
		PistaTenis p = new PistaTenis();
		modelo.addAttribute("pista",p);
		modelo.addAttribute("tipo","tenis");
		modelo.addAttribute("pistas",sr.listarSuperficies());
		return "nueva-pista";
	}
	
	@GetMapping({"/nueva-pista-padel","/nueva-pista-padel.html"})
	public String getNuevaPistaPadel(Model modelo) {
		PistaPadel p = new PistaPadel();
		modelo.addAttribute("pista",p);
		modelo.addAttribute("tipo","padel");
		modelo.addAttribute("pistas",sr.listarSuperficies());
		return "nueva-pista";
	}
	
	
	@PostMapping ("/save-pista-tenis")
	public String savePistaTenis (@Validated PistaTenis p, Model modelo) {
		pts.savePista(p);
		return "dashboard-coordinador";
	}
	
	@PostMapping ("/save-pista-padel")
	public String savePistaPadel (@Validated PistaPadel p, Model modelo) {
		pps.savePista(p);
		return "dashboard-coordinador";
	}
	
}
