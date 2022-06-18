package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GrupoEscuela;
import com.example.demo.model.PistaTenis;
import com.example.demo.model.RelGrupoAlumnos;
import com.example.demo.model.TorneoTenis;
import com.example.demo.servicios.GrupoServicio;
import com.example.demo.servicios.HorarioServicio;
import com.example.demo.servicios.PistaPadelServicio;
import com.example.demo.servicios.PistaTenisServicio;
import com.example.demo.servicios.RelGrupoAlumnosServicio;
import com.example.demo.servicios.UsuarioServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/grupos"})
public class ControladorGrupo {
	@Autowired
	GrupoServicio gs;
	@Autowired
	UsuarioServicio us;
	@Autowired
	PistaTenisServicio pts;
	@Autowired
	PistaPadelServicio pps;
	@Autowired
	RelGrupoAlumnosServicio rgas;
	@Autowired
	HorarioServicio hs;
	
	
	@GetMapping("/tenis")
	public List <GrupoEscuela> listarGruposTenis(){
		List <GrupoEscuela> grupos = gs.listarGruposTenis();
		return grupos;
	}
	
	@GetMapping("/padel")
	public List <GrupoEscuela> listarGruposPadel(){
		List <GrupoEscuela> grupos = gs.listarGruposPadel();
		return grupos;
	}
	
	/*
	@RequestMapping(value = "/getGruposEscuela", method = RequestMethod.GET)
	public ResponseEntity<GrupoEscuela> listaTorneos(){
		List <GrupoEscuela> grupos = gs.listarGrupos();
		return new ResponseEntity(grupos, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/crearGrupo", method = RequestMethod.POST)
	public ResponseEntity<GrupoEscuela> create(@Validated @RequestBody GrupoEscuela grupo) {
		gs.saveGrupo(grupo);
		return new ResponseEntity(grupo.toString(), HttpStatus.CREATED);
    }
	
	
	@GetMapping({"/nuevo-grupo-tenis","/nuevo-grupo-tenis.html"})
	public String getNuevoGrupoTenis(Model modelo) {
		GrupoEscuela grupo = new GrupoEscuela();
		modelo.addAttribute("grupo",grupo);
		modelo.addAttribute("tipo","tenis");
		modelo.addAttribute("monitores",us.listarByRol("Monitor"));
		modelo.addAttribute("pistas",pts.listarPistas());
		modelo.addAttribute("horarios",hs.listarHorarios());
		return "nuevo-grupo";
	}
	
	@GetMapping({"/nuevo-grupo-padel","/nuevo-grupo-padel.html"})
	public String getNuevoGrupoPadel(Model modelo) {
		GrupoEscuela grupo = new GrupoEscuela();
		modelo.addAttribute("grupo",grupo);
		modelo.addAttribute("tipo","padel");
		modelo.addAttribute("monitores",us.listarByRol("Monitor"));
		modelo.addAttribute("pistas",pps.listarPistas());
		modelo.addAttribute("horarios",hs.listarHorarios());
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
	
	@GetMapping ("/add-alumno-grupo")
	public String addAlumnoGrupo () {
		if (gs.getInscritosGrupo(3) < gs.getCapacidadGrupo(3)) {
			RelGrupoAlumnos rga = new RelGrupoAlumnos();
			rga.setId_alumno(5);
			rga.setId_grupo(3);
			rgas.saveInscripcionGrupo(rga);
			
			//si hay menos inscritos que capacidad del grupo
			//guardar el alumno de ese id en la bbdd
		}
		System.out.println("NO Se puede inscribir");
		//si no devolver error al modelo

		return "dashboard-coordinador";
	}
}
