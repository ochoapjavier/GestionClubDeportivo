package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.PistaPadel;
import com.example.demo.model.PistaTenis;
import com.example.demo.servicios.PistaPadelServicio;
import com.example.demo.servicios.PistaTenisServicio;
import com.example.demo.servicios.SuperficiesServicio;

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
		modelo.addAttribute("pistas",sr.listarSuperficiesDeporte("tenis"));
		return "nueva-pista";
	}
	
	@GetMapping({"/nueva-pista-padel","/nueva-pista-padel.html"})
	public String getNuevaPistaPadel(Model modelo) {
		PistaPadel p = new PistaPadel();
		modelo.addAttribute("pista",p);
		modelo.addAttribute("tipo","padel");
		modelo.addAttribute("pistas",sr.listarSuperficiesDeporte("padel"));
		return "nueva-pista";
	}
	
	
	@PostMapping ("/save-pista-tenis")
	public String savePistaTenis (@Validated PistaTenis p, Model modelo) {
		p.setId_pista("");
		pts.savePista(p);
		return "dashboard-coordinador";
	}
	
	@PostMapping ("/save-pista-padel")
	public String savePistaPadel (@Validated PistaPadel p, Model modelo) {
		p.setId_pista("");
		pps.savePista(p);
		return "dashboard-coordinador";
	}
	
}
