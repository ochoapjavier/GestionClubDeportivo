package com.example.demo.controladores;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping({"/reservas"})
public class ControladorReserva {
	
	@Autowired
	ReservaPistaServicio rps;
	
	@GetMapping()
	public ResponseEntity<List<ReservaPista>> listaReservas(){
		List <ReservaPista> rp = rps.listarReservas();
		return ResponseEntity.ok(rp);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<ReservaPista> getReservaById(@PathVariable int id){
		ReservaPista reserva = rps.findById(id);
		return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("fecha/{fecha}")
	public ResponseEntity<List<ReservaPista>> getReservasByFecha(@PathVariable String fecha){
		LocalDate conver = LocalDate.parse(fecha);
		return ResponseEntity.ok(rps.findByFecha(conver));
	}
	 
	@GetMapping("/{id}/{fecha}")
	public ResponseEntity<List<ReservaPista>> getReservaByIdFecha(@PathVariable String id, @PathVariable String fecha){
		 LocalDate conver = LocalDate.parse(fecha);
		 return ResponseEntity.ok(rps.listarReservaIdFecha(id, conver));
	}
	
	@GetMapping("idUsuario/{id_usuario}")
	public ResponseEntity<List<ReservaPista>> getReservaByIdUsuario(@PathVariable int id_usuario){
		return ResponseEntity.ok(rps.findByIdUsuario(id_usuario));
	}
	 
	@PostMapping()
	public ResponseEntity<ReservaPista> crearReserva(@Validated @RequestBody ReservaPista rp) {
		rps.saveReserva(rp);
		return new ResponseEntity<>(rp, HttpStatus.CREATED);
    }
	
	@PutMapping()
	public ResponseEntity<ReservaPista> actualizarReserva(@Validated @RequestBody ReservaPista reserva) {
		try {
			ReservaPista reservaActualizada = rps.actualizarReserva(reserva);
			return ResponseEntity.ok(reservaActualizada);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarReserva(@PathVariable int id) {
		if (rps.findById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		rps.eliminarReserva(id);
		return ResponseEntity.noContent().build();
    }
	
}
