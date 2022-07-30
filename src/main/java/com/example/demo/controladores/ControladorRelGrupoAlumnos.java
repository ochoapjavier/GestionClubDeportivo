package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Deporte;
import com.example.demo.model.RelCompeticionUsuario;
import com.example.demo.model.RelGrupoAlumnos;
import com.example.demo.model.ReservaPista;
import com.example.demo.model.Usuario;
import com.example.demo.servicios.DeporteServicio;
import com.example.demo.servicios.RelCompeticionUsuarioServicio;
import com.example.demo.servicios.RelGrupoAlumnosServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/rel-grupo-alumnos"})
public class ControladorRelGrupoAlumnos {
	@Autowired
	private RelGrupoAlumnosServicio rgas;
	
	
	@GetMapping()
	List<RelGrupoAlumnos> listarRelGrupoAlumnos() {
		return rgas.listarRelGrupoAlumnos();
	}
	
	@GetMapping("/{id}")
	public RelGrupoAlumnos getRelGrupoAlumnos(@PathVariable int id){
		RelGrupoAlumnos rga = rgas.findById(id);
		return rga;
	}
	
	@GetMapping("id-grupo/{id}")
	List<RelGrupoAlumnos> getRelGrupoAlumnosByIdGrupo(@PathVariable int id){
		return rgas.listarRelGrupoAlumnosByIdGrupo(id);
	}
	
	@PostMapping()
	public RelGrupoAlumnos crearRelGrupoAlumnos(@Validated @RequestBody RelGrupoAlumnos rga) {
		rgas.saveInscripcionGrupo(rga);
		return rga;
    }

	

	 
}
