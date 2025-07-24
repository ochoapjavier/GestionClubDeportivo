package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.GrupoEscuela;
import com.example.demo.servicios.GrupoServicio;

@CrossOrigin(origins = "${frontend.url}")
@RestController
@RequestMapping({"/grupos"})
public class ControladorGrupo {
	
	@Autowired
	GrupoServicio gs;
	
	@GetMapping()
	public List <GrupoEscuela> listarGrupos(){
		List <GrupoEscuela> grupos = gs.listarGrupos();
		return grupos;
	}
	
	@GetMapping("/monitor/{id}")
	public List <GrupoEscuela> listarGruposByMonitorId(@PathVariable int id){
		List <GrupoEscuela> grupos = gs.listarGruposByMonitorId(id);
		return grupos;
	}
	
	@GetMapping("/usuario/{id}")
	public List <GrupoEscuela> listarGruposByUsuarioId(@PathVariable int id){
		List <GrupoEscuela> grupos = gs.listarGruposByUsuarioId(id);
		return grupos;
	}
	
	@GetMapping("/id/{id}")
	public GrupoEscuela listarGrupoById(@PathVariable int id){
		GrupoEscuela grupos = gs.listarGrupoById(id);
		return grupos;
	}
	
	@PostMapping()
	public GrupoEscuela crearGrupo(@Validated @RequestBody GrupoEscuela grupo) {
		gs.saveGrupo(grupo);
		return grupo;
    }
	
	@DeleteMapping("/{id}")
	public GrupoEscuela eliminarCompeticion(@PathVariable int id) {
		GrupoEscuela g = gs.findById(id);
		gs.eliminarGrupo(id);
		return g;
    }
	
}
