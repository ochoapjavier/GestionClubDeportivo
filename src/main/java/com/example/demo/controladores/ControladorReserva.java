package com.example.demo.controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.ReservaPista;
import com.example.demo.servicios.GrupoServicio;
import com.example.demo.servicios.HorarioServicio;
import com.example.demo.servicios.PistaPadelServicio;
import com.example.demo.servicios.PistaTenisServicio;
import com.example.demo.servicios.ReservaPistaServicio;
import com.example.demo.servicios.UsuarioServicio;

@Controller
public class ControladorReserva {
	@Autowired
	GrupoServicio gs;
	@Autowired
	UsuarioServicio us;
	@Autowired
	PistaTenisServicio pts;
	@Autowired
	PistaPadelServicio pps;
	@Autowired
	HorarioServicio hs;
	@Autowired
	ReservaPistaServicio rps;
	
	@GetMapping({"/nueva-reserva-tenis","/nueva-reserva-tenis.html"})
	public String getNuevaReservaTenis(Model modelo) {
		ReservaPista reserva = new ReservaPista();
		modelo.addAttribute("reserva",reserva);
		modelo.addAttribute("tipo","tenis");
		modelo.addAttribute("pistas",pts.listarPistas());
		/*SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse("2022/03/15");
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
		modelo.addAttribute("horarios",hs.listarHorariosByPistaAndFecha("TEN1", fechaDate));
		//modelo.addAttribute("horarios",hs.listarHorarios());*/
		return "nueva-reserva";
	}
	
	@GetMapping({"/nueva-reserva-padel","/nueva-reserva-padel.html"})
	public String getNuevaReservaPadel(Model modelo) {
		ReservaPista reserva = new ReservaPista();
		modelo.addAttribute("reserva",reserva);
		modelo.addAttribute("tipo","padel");
		modelo.addAttribute("pistas",pps.listarPistas());
		modelo.addAttribute("horarios",hs.listarHorarios());
		return "nueva-reserva";
	}
	
	@PostMapping ("/save-reserva")
	public String saveReserva (@Validated ReservaPista reserva, Model modelo) {
		modelo.addAttribute("horariosDispo",hs.listarHorariosByPistaAndFecha(reserva.getId_pista(), reserva.getFecha()));
		rps.saveReserva(reserva);
		return "dashboard-coordinador";
	}
	
}
