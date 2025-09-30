package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.RelCompeticionUsuario;
import com.example.demo.servicios.RelCompeticionUsuarioServicio;

@RestController
@RequestMapping({"/rel-competicion-usuario"})
public class ControladorRelCompeticionUsuario {
	
	@Autowired
	private RelCompeticionUsuarioServicio rcus;
	
	@GetMapping()
	ResponseEntity<List<RelCompeticionUsuario>> listarRelCompeticionUsuario() {
		return ResponseEntity.ok(rcus.listarRelCompeticionUsuario());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RelCompeticionUsuario> getRelCompeticionUsuario(@PathVariable int id){
		RelCompeticionUsuario rcu = rcus.findById(id);
		return rcu != null ? ResponseEntity.ok(rcu) : ResponseEntity.notFound().build();
	}
	
	@PostMapping()
	public ResponseEntity<RelCompeticionUsuario> crearRelCompeticionUsuario(@Validated @RequestBody RelCompeticionUsuario rcu) {
		rcus.saveRelCompeticionUsuario(rcu);
		return new ResponseEntity<>(rcu, HttpStatus.CREATED);
    }
	 
}
