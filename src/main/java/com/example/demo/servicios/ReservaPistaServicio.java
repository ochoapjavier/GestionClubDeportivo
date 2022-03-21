package com.example.demo.servicios;

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
	
	public Boolean saveReserva(ReservaPista rp) {
		if (!rpr.saveAndFlush(rp).equals(null)) {
			return true;
		}
		return false;
	}
	
}
