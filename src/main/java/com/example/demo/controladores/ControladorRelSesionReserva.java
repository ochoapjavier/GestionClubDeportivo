package com.example.demo.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.RelSesionReserva;
import com.example.demo.servicios.RelSesionReservaServicio;

@CrossOrigin(origins = "${frontend.url}")
@RestController
@RequestMapping({"/rel-sesion-reserva"})
public class ControladorRelSesionReserva {
	
	@Autowired
	private RelSesionReservaServicio rsrs;
	
	@GetMapping()
	List<RelSesionReserva> listarRelSesionReserva() {
		return rsrs.listarRelSesionReserva();
	}
	
	@GetMapping("/{id}")
	public RelSesionReserva getRelGrupoAlumnos(@PathVariable int id){
		RelSesionReserva rga = rsrs.findById(id);
		return rga;
	}
	
	@PostMapping()
	public RelSesionReserva crearRelSesionReserva(@Validated @RequestBody RelSesionReserva rsr) {
		rsrs.saveRelSesionReserva(rsr);
		return rsr;
    }

	@DeleteMapping("{id}")
	public void eliminarRelGrupoAlumno(@PathVariable int id) {
		rsrs.eliminarRelSesionReserva(id);
    }
	 
}
