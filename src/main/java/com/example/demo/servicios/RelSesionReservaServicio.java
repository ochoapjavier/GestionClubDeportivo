/*package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.RelSesionReservaRepositorio;
import com.example.demo.model.RelSesionReserva;

@Repository
public class RelSesionReservaServicio {
	
	@Autowired
	RelSesionReservaRepositorio rsrr;
	
	public List<RelSesionReserva> listarRelSesionReserva(){
		return rsrr.findAll();
	}
	
	public Boolean saveRelSesionReserva(RelSesionReserva rga) {
		if (!rsrr.saveAndFlush(rga).equals(null)) {
			return true;
		}
		return false;
	}
	
	public RelSesionReserva findById(int id) {
		return rsrr.findById(id);
	}
	
	public Boolean eliminarRelSesionReserva(int id) {		
		try {
			rsrr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}*/
