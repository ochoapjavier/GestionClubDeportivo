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
import com.example.demo.model.Superficie;
import com.example.demo.servicios.SuperficiesServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/superficies"})
public class ControladorSuperficie {
	
	@Autowired
	private SuperficiesServicio ss;
	
	//Método para listar todos los torneos
	@GetMapping("/tenis")
	public List <Superficie> listaSuperficiesTenis(){
		List <Superficie> superficies = ss.listarSuperficiesDeporte("tenis");
		return superficies;
	}
	
	@GetMapping("/padel")
	public List <Superficie> listaSuperficiesPadel(){
		List <Superficie> superficies = ss.listarSuperficiesDeporte("padel");
		return superficies;
	}
	
	 //Método para añadir un torneo
	@PostMapping()
	public Superficie crearSuperficie(@Validated @RequestBody Superficie superficie) {
		ss.saveSuperficie(superficie);
		return superficie;
    }
	
	//Método para actualizar un torneo 
	@PutMapping()
	public Superficie actualizarSuperficie(@Validated @RequestBody Superficie superficie) {
		Superficie s = new Superficie();
		s.setNombre(superficie.getNombre());
		s.setDeporte(superficie.getDeporte());
		ss.actualizarSuperficie(s);
		return s;
    }
	
	//Método para borrar un torneo a partir de su id
	@DeleteMapping("/{id}")
	public void eliminarSuperficie(@PathVariable int id) {
		ss.eliminarSuperficie(id);
    }

}
