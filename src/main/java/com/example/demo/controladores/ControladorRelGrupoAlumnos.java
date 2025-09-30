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
import com.example.demo.model.RelGrupoAlumnos;
import com.example.demo.servicios.RelGrupoAlumnosServicio;

@RestController
@RequestMapping({"/rel-grupo-alumnos"})
public class ControladorRelGrupoAlumnos {
	
	@Autowired
	private RelGrupoAlumnosServicio rgas;
	
	@GetMapping()
	ResponseEntity<List<RelGrupoAlumnos>> listarRelGrupoAlumnos() {
		return ResponseEntity.ok(rgas.listarRelGrupoAlumnos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RelGrupoAlumnos> getRelGrupoAlumnos(@PathVariable int id){
		RelGrupoAlumnos rga = rgas.findById(id);
		return rga != null ? ResponseEntity.ok(rga) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("id-grupo/{id}")
	ResponseEntity<List<RelGrupoAlumnos>> getRelGrupoAlumnosByIdGrupo(@PathVariable int id){
		return ResponseEntity.ok(rgas.listarRelGrupoAlumnosByIdGrupo(id));
	}
	
	@PostMapping()
	public ResponseEntity<RelGrupoAlumnos> crearRelGrupoAlumnos(@Validated @RequestBody RelGrupoAlumnos rga) {
		rgas.saveInscripcionGrupo(rga);
		return new ResponseEntity<>(rga, HttpStatus.CREATED);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarRelGrupoAlumno(@PathVariable int id) {
		if (rgas.findById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		rgas.eliminarRelGrupoAlumnos(id);
		return ResponseEntity.noContent().build();
    }
	 
}
