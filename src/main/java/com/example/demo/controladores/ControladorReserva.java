package com.example.demo.controladores;


import java.time.LocalDate;
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

import com.example.demo.model.ReservaPista;
import com.example.demo.servicios.GrupoServicio;
import com.example.demo.servicios.HorarioServicio;
import com.example.demo.servicios.PistaPadelServicio;
import com.example.demo.servicios.PistaTenisServicio;
import com.example.demo.servicios.ReservaPistaServicio;
import com.example.demo.servicios.UsuarioServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/reservas"})
public class ControladorReserva {
	@Autowired
	ReservaPistaServicio rps;
	
	
	@GetMapping()
	public List <ReservaPista> listaReservas(){
		List <ReservaPista> rp = rps.listarReservas();
		return rp;
	}
	
	@GetMapping("id/{id}")
	public ReservaPista getReservaById(@PathVariable int id){
		return rps.findById(id);
	}
	
	@GetMapping("fecha/{fecha}")
	public List <ReservaPista> getReservasByFecha(@PathVariable String fecha){
		LocalDate conver = LocalDate.parse(fecha);
		return rps.findByFecha(conver);
	}
	 
	@GetMapping("/{id}/{fecha}")
	public List<ReservaPista> getReservaByIdFecha(@PathVariable String id, @PathVariable String fecha){
		 LocalDate conver = LocalDate.parse(fecha);
		 return rps.listarReservaIdFecha(id, conver);
	}
	 
	@PostMapping()
	public ReservaPista crearReserva(@Validated @RequestBody ReservaPista rp) {
		rps.saveReserva(rp);
		return rp;
    }
	
	@PutMapping()
	public ReservaPista actualizarReserva(@Validated @RequestBody ReservaPista reserva) {
		ReservaPista rp = new ReservaPista();
		rp.setId(reserva.getId());
		rp.setFecha(reserva.getFecha());
		rp.setHorario(reserva.getHorario());
		rp.setId_pista(reserva.getId_pista());
		rps.actualizarReserva(rp);
		return rp;
    }
	
	@DeleteMapping("/{id}")
	public void eliminarReserva(@PathVariable int id) {
		rps.eliminarReserva(id);
    }
	
	
	/*
	@GetMapping({"/nueva-reserva-tenis","/nueva-reserva-tenis.html"})
	public String getNuevaReservaTenis(Model modelo) {
		ReservaPista reserva = new ReservaPista();
		modelo.addAttribute("reserva",reserva);
		modelo.addAttribute("tipo","tenis");
		modelo.addAttribute("pistas",pts.listarPistas());
		return "nueva-reserva";
	}
	
	@GetMapping({"/nueva-reserva-padel","/nueva-reserva-padel.html"})
	public String getNuevaReservaPadel(Model modelo) {
		ReservaPista reserva = new ReservaPista();
		modelo.addAttribute("reserva",reserva);
		modelo.addAttribute("tipo","padel");
		modelo.addAttribute("pistas",pps.listarPistas());
		return "nueva-reserva";
	}
	
	@PostMapping ("/save-reserva")
	public String saveReserva (@Validated ReservaPista reserva, Model modelo) {
		rps.saveReserva(reserva);
		return "dashboard-coordinador";
	}
	 */
}
