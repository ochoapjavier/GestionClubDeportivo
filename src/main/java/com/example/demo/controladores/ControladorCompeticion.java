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
import com.example.demo.model.Competicion;
import com.example.demo.servicios.CompeticionServicio;

@RestController
@RequestMapping({"/competiciones"})
public class ControladorCompeticion {
	
	@Autowired
	private CompeticionServicio cs;
	
	//Método para listar todas las competiciones
	@GetMapping()
	public ResponseEntity<List<Competicion>> listaCompeticiones(){
		List <Competicion> competiciones = cs.listarCompeticiones();
		return ResponseEntity.ok(competiciones);
	}
	
	//Método para listar todos los torneos
	@GetMapping("/torneos")
	public ResponseEntity<List<Competicion>> listaTorneos(){
		List <Competicion> competiciones = cs.listarTorneos();
		return ResponseEntity.ok(competiciones);
	}
	
	//Método para listar todos los torneos por usuario
	@GetMapping("torneos-usuario/{id}")
	public ResponseEntity<List<Competicion>> getTorneosByUsuarioId(@PathVariable int id){
		List<Competicion> rcu = cs.findTorneoByUsuarioId(id);
		return ResponseEntity.ok(rcu);
	}
	
	//Método para listar todos los rankings
	@GetMapping("/rankings")
	public ResponseEntity<List<Competicion>> listaRankings(){
		List <Competicion> competiciones = cs.listarRankings();
		return ResponseEntity.ok(competiciones);
	}

	//Método para listar todos los rankings por usuario
	@GetMapping("rankings-usuario/{id}")
	public ResponseEntity<List<Competicion>> getRankingsByUsuarioId(@PathVariable int id){
		List<Competicion> rcu = cs.findRankingByUsuarioId(id);
		return ResponseEntity.ok(rcu);
	}
	
	//Método para listar todos las competiciones de tenis
	@GetMapping("/tenis")
	public ResponseEntity<List<Competicion>> listaCompeticionesTenis(){
		List <Competicion> competiciones = cs.listarCompeticionesTenis();
		return ResponseEntity.ok(competiciones);
	}
	
	//Método para listar todos las competiciones de padel
	@GetMapping("/padel")
	public ResponseEntity<List<Competicion>> listaCompeticionesPadel(){
		List <Competicion> competiciones = cs.listarCompeticionesPadel();
		return ResponseEntity.ok(competiciones);
	}
	
	//Método para listar todos las competiciones en inscripción para un id de usuario
	@GetMapping("inscripcion/{id}")
	public ResponseEntity<List<Competicion>> listaCompeticionesInscripcion(@PathVariable int id){
		List <Competicion> competiciones = cs.listarCompeticionesInscripcion(id);
		return ResponseEntity.ok(competiciones);
	}
	
	//Método para listar un torneo a partir de su id
	@GetMapping("/{id}")
	public ResponseEntity<Competicion> getCompeticion(@PathVariable int id){
		Competicion competicion = cs.findById(id);
		return competicion != null ? ResponseEntity.ok(competicion) : ResponseEntity.notFound().build();
	}
	
	 //Método para añadir un torneo
	@PostMapping()
	public ResponseEntity<Competicion> crearCompeticion(@Validated @RequestBody Competicion competicion) {
		cs.saveCompeticion(competicion);
		return new ResponseEntity<>(competicion, HttpStatus.CREATED);
    }
	
	//Método para actualizar un torneo 
	@PutMapping()
	public ResponseEntity<Competicion> actualizarCompeticion(@Validated @RequestBody Competicion competicion) {
		// Se asume que el servicio de actualización devuelve la entidad actualizada o null si no la encuentra.
		// Corregido: el servicio devuelve boolean, que usamos para determinar si la actualización fue exitosa.
		boolean actualizada = cs.actualizarCompeticion(competicion);
		return actualizada ? ResponseEntity.ok(competicion) : ResponseEntity.notFound().build();
    }
	
	//Método para borrar un torneo a partir de su id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCompeticion(@PathVariable int id) {
		Competicion c = cs.findById(id);
		if (c == null) {
			return ResponseEntity.notFound().build();
		}
		cs.eliminarCompeticion(id);
		return ResponseEntity.noContent().build();
    }

}
