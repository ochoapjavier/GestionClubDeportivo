package com.example.demo.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.model.TorneoTenis;
import com.example.demo.servicios.TorneoTenisServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/torneos"})
public class ControladorTorneo {
	@Autowired
	private TorneoTenisServicio tts;
	
	//Método para listar todos los torneos
	@GetMapping()
	public List <TorneoTenis> listaTorneos(){
		List <TorneoTenis> torneos = tts.listarTorneosTenis();
		return torneos;
	}
	 
	 //Método para listar un torneo a partir de su id
	@GetMapping("/{id}")
	public TorneoTenis getTorneo(@PathVariable int id){
		return tts.findById(id);
	}
	
	 //Método para añadir un torneo
	@PostMapping()
	public TorneoTenis crearTorneo(@Validated @RequestBody TorneoTenis torneo) {
		tts.saveTorneoTenis(torneo);
		return torneo;
    }
	
	//Método para actualizar un torneo 
	@PutMapping()
	public TorneoTenis actualizarTorneo(@Validated @RequestBody TorneoTenis torneo) {
		TorneoTenis t = new TorneoTenis();
		t.setId(torneo.getId());
		t.setCategoria(torneo.getCategoria());
		t.setMax_jugadores(torneo.getMax_jugadores());
		t.setNombre_torneo(torneo.getNombre_torneo());
		tts.actualizarTorneoTenis(t);
		return t;
    }
	
	//Método para borrar un torneo a partir de su id
	@DeleteMapping("/{id}")
	public void eliminarTorneo(@PathVariable int id) {
		tts.eliminarTorneoTenis(id);
    }

}
