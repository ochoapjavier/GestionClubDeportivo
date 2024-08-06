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
import com.example.demo.model.Sesion;
import com.example.demo.servicios.SesionServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/sesion"})
public class ControladorSesion {
	
	@Autowired
	SesionServicio ss;
	
	@GetMapping()
	public List <Sesion> listaSesiones(){
		List <Sesion> s = ss.listarSesiones();
		return s;
	}
	
	@GetMapping("/{id}")
	public Sesion getSesionById(@PathVariable int id){
		return ss.findById(id);
	}
	
	@GetMapping("/user/{id}")
	public List <Sesion> getSesionByUserId(@PathVariable int id){
		return ss.listarSesionesByUserID(id);
	}
	
	@GetMapping("/user/futuras/{id}")
	public List <Sesion> getSesionesFuturasByUserId(@PathVariable int id){
		return ss.listarSesionesFuturasByUserID(id);
	}
	
	@GetMapping("/monitor/{id}")
	public List <Sesion> getSesionByMonitorId(@PathVariable int id){
		return ss.listarSesionesByMonitorID(id);
	}
	
	@GetMapping("/monitor/futuras/{id}")
	public List <Sesion> getSesionesFuturasByMonitorId(@PathVariable int id){
		return ss.listarSesionesFuturasByMonitorID(id);
	}
	
	@PostMapping()
	public Sesion crearSesion(@Validated @RequestBody Sesion sesion) {
		if (ss.findByFechaYGrupo(sesion.getId_grupo().getId_monitor().getId(), sesion.getId_grupo().getId(), sesion.getFecha()) != null) {
			sesion.setId(-1);
			return sesion;
		} else {
			ss.saveSesion(sesion);
		}		
		return sesion;
    }
	
	@PutMapping()
	public Sesion actualizarSesion(@Validated @RequestBody Sesion sesion) {
		Sesion s = new Sesion();
		s.setId(sesion.getId());
		s.setId_grupo(sesion.getId_grupo());
		s.setFecha(sesion.getFecha());
		s.setTitulo(sesion.getTitulo());
		s.setDescripcion(sesion.getDescripcion());	
		ss.actualizarSesion(s);
		return s;
    }
	
	@DeleteMapping("/{id}")
	public void eliminarSesion(@PathVariable int id) {
		ss.eliminarSesion(id);
    }
		
}
