package com.example.demo.controladores;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Horario;
import com.example.demo.servicios.HorarioServicio;

@RestController
@RequestMapping({"/horarios"})
public class ControladorHorario {
	
	@Autowired
	private HorarioServicio hs;
	
	@GetMapping()
	 ResponseEntity<List<Horario>> listarHorarios() {
	    return ResponseEntity.ok(hs.listarHorarios());
	  }
	
	@GetMapping("/{id}")
	 ResponseEntity<Horario> getHorarioById(@PathVariable int id) {
		Horario horario = hs.findById(id);
	    return horario != null ? ResponseEntity.ok(horario) : ResponseEntity.notFound().build();
	  }
	
	 @GetMapping("/{fecha}/{nombrePista}")
	 ResponseEntity<List<Horario>> listarHorariosByFechaPista(@PathVariable String fecha, @PathVariable String nombrePista) {
		 LocalDate conver = LocalDate.parse(fecha);
	    return ResponseEntity.ok(hs.listarHorariosDisp(nombrePista, conver));
	  }
	 
}
