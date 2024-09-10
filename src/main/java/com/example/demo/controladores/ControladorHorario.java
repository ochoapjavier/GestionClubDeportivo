package com.example.demo.controladores;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Horario;
import com.example.demo.servicios.HorarioServicio;

@CrossOrigin(origins = "${frontend.url}")
@RestController
@RequestMapping({"/horarios"})
public class ControladorHorario {
	
	@Autowired
	private HorarioServicio hs;
	
	@GetMapping()
	 List<Horario> listarHorarios() {
	    return hs.listarHorarios();
	  }
	
	@GetMapping("/{id}")
	 Horario getHorarioById(@PathVariable int id) {
	    return hs.findById(id);
	  }
	
	 @GetMapping("/{fecha}/{nombrePista}")
	 List<Horario> listarHorariosByFechaPista(@PathVariable String fecha, @PathVariable String nombrePista) {
		 LocalDate conver = LocalDate.parse(fecha);
	    return hs.listarHorariosDisp(nombrePista, conver);
	  }
	 
}
