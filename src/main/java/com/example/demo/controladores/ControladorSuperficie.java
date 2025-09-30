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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Superficie;
import com.example.demo.servicios.SuperficiesServicio;

@RestController
@RequestMapping({"/superficies"})
public class ControladorSuperficie {
	
	@Autowired
	private SuperficiesServicio ss;
	
	//Método para listar todos los torneos
	@GetMapping("/tenis")
	public ResponseEntity<List<Superficie>> listaSuperficiesTenis(){
		List <Superficie> superficies = ss.listarSuperficiesDeporte("tenis");
		return ResponseEntity.ok(superficies);
	}
	
	@GetMapping("/padel")
	public ResponseEntity<List<Superficie>> listaSuperficiesPadel(){
		List <Superficie> superficies = ss.listarSuperficiesDeporte("padel");
		return ResponseEntity.ok(superficies);
	}
	
	 //Método para añadir un torneo
	@PostMapping()
	public ResponseEntity<Superficie> crearSuperficie(@Validated @RequestBody Superficie superficie) {
		ss.saveSuperficie(superficie);
		return new ResponseEntity<>(superficie, HttpStatus.CREATED);
    }
	
	//Método para actualizar un torneo 
	@PutMapping()
	public ResponseEntity<Superficie> actualizarSuperficie(@Validated @RequestBody Superficie superficie) {
		boolean actualizada = ss.actualizarSuperficie(superficie);
		return actualizada ? ResponseEntity.ok(superficie) : ResponseEntity.notFound().build();
    }
	
	//Método para borrar un torneo a partir de su id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarSuperficie(@PathVariable int id) {
		ss.eliminarSuperficie(id);
		return ResponseEntity.noContent().build();
    }

}
