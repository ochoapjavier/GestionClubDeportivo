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
	
	public Boolean saveTorneoTenis(TorneoTenis t) {
		if (!ttr.saveAndFlush(t).equals(null)) {
			return true;
		}
		return false;
	}		
}
