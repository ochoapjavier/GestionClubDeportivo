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
import com.example.demo.model.RelCompeticionUsuario;
import com.example.demo.servicios.RelCompeticionUsuarioServicio;

@CrossOrigin(origins = "${frontend.url}")
@RestController
@RequestMapping({"/rel-competicion-usuario"})
public class ControladorRelCompeticionUsuario {
	
	@Autowired
	private RelCompeticionUsuarioServicio rcus;
	
	@GetMapping()
	List<RelCompeticionUsuario> listarRelCompeticionUsuario() {
		return rcus.listarRelCompeticionUsuario();
	}
	
	@GetMapping("/{id}")
	public RelCompeticionUsuario getRelCompeticionUsuario(@PathVariable int id){
		RelCompeticionUsuario rcu = rcus.findById(id);
		return rcu;
	}
	
	@PostMapping()
	public RelCompeticionUsuario crearRelCompeticionUsuario(@Validated @RequestBody RelCompeticionUsuario rcu) {
		rcus.saveRelCompeticionUsuario(rcu);
		return rcu;
    }
	 
}
