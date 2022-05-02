package com.example.demo.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.TorneoTenis;
import com.example.demo.servicios.TorneoTenisServicio;


@Controller
public class ControladorTorneo {
	@Autowired
	private TorneoTenisServicio tts;
	
	 @GetMapping({"/nuevo-torneo","/nuevo-torneo.html"})
	 public String listarTorneosTenis(Model modelo) {
		 TorneoTenis torneo = new TorneoTenis();
			modelo.addAttribute("torneo",torneo);
	    return "nuevo-torneo";
	  }
	 
	 @PostMapping ("/save-torneo-tenis")
		public String saveReserva (@Validated TorneoTenis torneo) {
			//modelo.addAttribute("horariosDispo",hs.listarHorariosByPistaAndFecha(reserva.getId_pista(), reserva.getFecha()));
			tts.saveTorneoTenis(torneo);
			return "dashboard-coordinador";
		}
	  
}
