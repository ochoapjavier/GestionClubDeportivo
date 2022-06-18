package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.TorneoTenisRepositorio;
import com.example.demo.model.PistaTenis;
import com.example.demo.model.TorneoTenis;

@Repository
public class TorneoTenisServicio {
	@Autowired
	TorneoTenisRepositorio ttr;
	
	public List<TorneoTenis> listarTorneosTenis(){
		return ttr.findAll();
	}
	
	public TorneoTenis findById(int id) {
		return ttr.findById(id);
	}
	
	public Boolean saveTorneoTenis(TorneoTenis t) {
		if (!ttr.saveAndFlush(t).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean actualizarTorneoTenis(TorneoTenis t) {
		
		if (!ttr.save(t).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean eliminarTorneoTenis(int id) {		
		try {
			ttr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
