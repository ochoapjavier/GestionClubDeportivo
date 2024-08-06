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
import com.example.demo.model.Competicion;
import com.example.demo.servicios.CompeticionServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/competiciones"})
public class ControladorCompeticion {
	
	@Autowired
	private CompeticionServicio cs;
	
	//Método para listar todas las competiciones
	@GetMapping()
	public List <Competicion> listaCompeticiones(){
		List <Competicion> competiciones = cs.listarCompeticiones();
		return competiciones;
	}
	
	//Método para listar todos los torneos
	@GetMapping("/torneos")
	public List <Competicion> listaTorneos(){
		List <Competicion> competiciones = cs.listarTorneos();
		return competiciones;
	}
	
	//Método para listar todos los torneos por usuario
	@GetMapping("torneos-usuario/{id}")
	public List<Competicion> getTorneosByUsuarioId(@PathVariable int id){
		List<Competicion> rcu = cs.findTorneoByUsuarioId(id);
		return rcu;
	}
	
	//Método para listar todos los rankings
	@GetMapping("/rankings")
	public List <Competicion> listaRankings(){
		List <Competicion> competiciones = cs.listarRankings();
		return competiciones;
	}

	//Método para listar todos los rankings por usuario
	@GetMapping("rankings-usuario/{id}")
	public List<Competicion> getRankingsByUsuarioId(@PathVariable int id){
		List<Competicion> rcu = cs.findRankingByUsuarioId(id);
		return rcu;
	}
	
	//Método para listar todos las competiciones de tenis
	@GetMapping("/tenis")
	public List <Competicion> listaCompeticionesTenis(){
		List <Competicion> competiciones = cs.listarCompeticionesTenis();
		return competiciones;
	}
	
	//Método para listar todos las competiciones de padel
	@GetMapping("/padel")
	public List <Competicion> listaCompeticionesPadel(){
		List <Competicion> competiciones = cs.listarCompeticionesPadel();
		return competiciones;
	}
	
	//Método para listar todos las competiciones en inscripción para un id de usuario
	@GetMapping("inscripcion/{id}")
	public List <Competicion> listaCompeticionesInscripcion(@PathVariable int id){
		List <Competicion> competiciones = cs.listarCompeticionesInscripcion(id);
		return competiciones;
	}
	
	//Método para listar un torneo a partir de su id
	@GetMapping("/{id}")
	public Competicion getCompeticion(@PathVariable int id){
		return cs.findById(id);
	}
	
	 //Método para añadir un torneo
	@PostMapping()
	public Competicion crearCompeticion(@Validated @RequestBody Competicion competicion) {
		cs.saveCompeticion(competicion);
		return competicion;
    }
	
	//Método para actualizar un torneo 
	@PutMapping()
	public Competicion actualizarCompeticion(@Validated @RequestBody Competicion competicion) {
		System.out.println(competicion.getId_fichero());
		Competicion c = new Competicion();
		c.setId(competicion.getId());
		c.setCategoria(competicion.getCategoria());
		c.setMax_jugadores(competicion.getMax_jugadores());
		c.setNombre_torneo(competicion.getNombre_torneo());
		c.setDeporte_id(competicion.getDeporte_id());
		c.setEstado_id(competicion.getEstado_id());
		c.setTipo_competicion_id(competicion.getTipo_competicion_id());
		c.setId_fichero(competicion.getId_fichero());
		cs.actualizarCompeticion(c);
		return c;
    }
	
	//Método para borrar un torneo a partir de su id
	@DeleteMapping("/{id}")
	public Competicion eliminarCompeticion(@PathVariable int id) {
		Competicion c = cs.findById(id);
		cs.eliminarCompeticion(id);
		return c;
    }

}
