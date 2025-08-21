package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping({"/grupos"})
public class ControladorGrupo {
	
	@Autowired
	GrupoServicio gs;
	
	@GetMapping()
	public ResponseEntity<List<GrupoEscuela>> listarGrupos(){
		List <GrupoEscuela> grupos = gs.listarGrupos();
		return ResponseEntity.ok(grupos);
	}
	
	@GetMapping("/monitor/{id}")
	public ResponseEntity<List<GrupoEscuela>> listarGruposByMonitorId(@PathVariable int id){
		List <GrupoEscuela> grupos = gs.listarGruposByMonitorId(id);
		return ResponseEntity.ok(grupos);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<List<GrupoEscuela>> listarGruposByUsuarioId(@PathVariable int id){
		List <GrupoEscuela> grupos = gs.listarGruposByUsuarioId(id);
		return ResponseEntity.ok(grupos);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<GrupoEscuela> listarGrupoById(@PathVariable int id){
		GrupoEscuela grupo = gs.listarGrupoById(id);
		return grupo != null ? ResponseEntity.ok(grupo) : ResponseEntity.notFound().build();
	}
	
	@PostMapping()
	public ResponseEntity<GrupoEscuela> crearGrupo(@Validated @RequestBody GrupoEscuela grupo) {
		gs.saveGrupo(grupo);
		return new ResponseEntity<>(grupo, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarGrupo(@PathVariable int id) {
		GrupoEscuela g = gs.findById(id);
		if (g == null) {
			return ResponseEntity.notFound().build();
		}
		gs.eliminarGrupo(id);
		return ResponseEntity.noContent().build();
    }
	
}
