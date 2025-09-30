package com.example.demo.controladores;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Sesion;
import com.example.demo.servicios.SesionServicio;

@RestController
@RequestMapping({"/sesion"})
public class ControladorSesion {
	
	@Autowired
	SesionServicio ss;
	
	@GetMapping()
	public ResponseEntity<List<Sesion>> listaSesiones(){
		List <Sesion> s = ss.listarSesiones();
		return ResponseEntity.ok(s);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sesion> getSesionById(@PathVariable int id){
		Sesion sesion = ss.findById(id);
		return sesion != null ? ResponseEntity.ok(sesion) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Sesion>> getSesionByUserId(@PathVariable int id){
		return ResponseEntity.ok(ss.listarSesionesByUserID(id));
	}
	
	@GetMapping("/user/futuras/{id}")
	public ResponseEntity<List<Sesion>> getSesionesFuturasByUserId(@PathVariable int id){
		return ResponseEntity.ok(ss.listarSesionesFuturasByUserID(id));
	}
	
	@GetMapping("/monitor/{id}")
	public ResponseEntity<List<Sesion>> getSesionByMonitorId(@PathVariable int id){
		return ResponseEntity.ok(ss.listarSesionesByMonitorID(id));
	}
	
	@GetMapping("/monitor/futuras/{id}")
	public ResponseEntity<List<Sesion>> getSesionesFuturasByMonitorId(@PathVariable int id){
		return ResponseEntity.ok(ss.listarSesionesFuturasByMonitorID(id));
	}
	
	@PostMapping()
	public ResponseEntity<?> crearSesion(@Validated @RequestBody Sesion sesion) {
		if (ss.findByFechaYGrupo(sesion.getId_grupo().getId_monitor().getId(), sesion.getId_grupo().getId(), sesion.getFecha()) != null) {
			Map<String, String> errorResponse = Collections.singletonMap("message", "Ya existe una sesión para este grupo en la fecha seleccionada.");
			return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		} else {
			ss.saveSesion(sesion);
			return new ResponseEntity<>(sesion, HttpStatus.CREATED);
		}
    }
	
	@PutMapping()
	public ResponseEntity<Sesion> actualizarSesion(@Validated @RequestBody Sesion sesion) {
		try {
			Sesion sesionActualizada = ss.actualizarSesion(sesion);
			return ResponseEntity.ok(sesionActualizada);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarSesion(@PathVariable int id) {
		if (ss.findById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		ss.eliminarSesion(id);
		return ResponseEntity.noContent().build();
    }
		
}
