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
import com.example.demo.servicios.ReservaPistaServicio;

@CrossOrigin(origins = "${frontend.url}")
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
	
	@GetMapping("idUsuario/{id_usuario}")
	public List<ReservaPista> getReservaByIdUsuario(@PathVariable int id_usuario){
		return rps.findByIdUsuario(id_usuario);
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
		rp.setId_pista(reserva.getId_pista());
		rp.setFecha(reserva.getFecha());
		rp.setId_horario(reserva.getId_horario());
		rp.setId_usuario(reserva.getId_usuario());
		rps.actualizarReserva(rp);
		return rp;
    }
	
	@DeleteMapping("/{id}")
	public void eliminarReserva(@PathVariable int id) {
		rps.eliminarReserva(id);
    }
	
}
