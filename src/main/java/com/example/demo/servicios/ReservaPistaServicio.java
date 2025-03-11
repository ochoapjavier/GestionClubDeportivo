package com.example.demo.servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.ReservaPistaRepositorio;
import com.example.demo.model.ReservaPista;

@Repository
public class ReservaPistaServicio {
	
	@Autowired
	ReservaPistaRepositorio rpr;
	
	public List<ReservaPista> listarReservas(){
		return rpr.findAll();
	}
	
	public List<ReservaPista> findByFecha(LocalDate fecha){
		return rpr.findByFecha(fecha);
	}
	
	public ReservaPista findById(int id) {
		return rpr.findById(id);
	}
	
	public List<ReservaPista> findByIdUsuario(int id_usuario) {
		return rpr.findByIdUsuario(id_usuario);
	}
	
	public Boolean saveReserva(ReservaPista rp) {
		if (!rpr.saveAndFlush(rp).equals(null)) {
			return true;
		}
		return false;
	}
	
	public ReservaPista actualizarReserva(ReservaPista rp) {
        if (rpr.existsById(rp.getId())) {
            return rpr.saveAndFlush(rp);
        } else {
            throw new RuntimeException("No se puede actualizar, el registro no existe.");
        }
    }
	
	public Boolean eliminarReserva(int id) {		
		try {
			rpr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<ReservaPista> listarReservaIdFecha(String id, LocalDate fecha){
		return rpr.listaPistasByIdFecha(id, fecha);
	}
	
}
