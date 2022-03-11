package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.GrupoEscuela;
import com.example.demo.servicios.GrupoServicio;
import com.example.demo.servicios.PistaPadelServicio;
import com.example.demo.servicios.PistaTenisServicio;
import com.example.demo.servicios.UsuarioServicio;

@Controller
public class ControladorGrupo {
	@Autowired
	GrupoServicio gs;
	@Autowired
	UsuarioServicio us;
	@Autowired
	PistaTenisServicio pts;
	@Autowired
	PistaPadelServicio pps;

	@GetMapping({"/nuevo-grupo-tenis","/nuevo-grupo-tenis.html"})
	public String getNuevoGrupoTenis(Model modelo) {
		GrupoEscuela grupo = new GrupoEscuela();
		modelo.addAttribute("grupo",grupo);
		modelo.addAttribute("tipo","tenis");
		modelo.addAttribute("monitores",us.listarByRol("Monitor"));
		modelo.addAttribute("pistas",pts.listarPistas());
		return "nuevo-grupo";
	}
	
	@GetMapping({"/nuevo-grupo-padel","/nuevo-grupo-padel.html"})
	public String getNuevoGrupoPadel(Model modelo) {
		GrupoEscuela grupo = new GrupoEscuela();
		modelo.addAttribute("grupo",grupo);
		modelo.addAttribute("tipo","padel");
		modelo.addAttribute("monitores",us.listarByRol("Monitor"));
		modelo.addAttribute("pistas",pps.listarPistas());
		return "nuevo-grupo";
	}
	
	@PostMapping ("/save-grupo-tenis")
	public String saveGrupoTenis (@Validated GrupoEscuela grupo, Model modelo) {
		grupo.setDeporte("Tenis");
		gs.saveGrupo(grupo);
		return "dashboard-coordinador";
	}
	
	@PostMapping ("/save-grupo-padel")
	public String saveGrupoPadel (@Validated GrupoEscuela grupo, Model modelo) {
		grupo.setDeporte("Padel");
		gs.saveGrupo(grupo);
		return "dashboard-coordinador";
	}
	
}
