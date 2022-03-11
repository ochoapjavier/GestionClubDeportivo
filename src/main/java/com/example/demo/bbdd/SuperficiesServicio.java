package com.example.demo.bbdd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Superficie;

@Repository
public class SuperficiesServicio {
	@Autowired
	SuperficiesRepositorio sr;
	
	public List<Superficie> listarSuperficies(){
		return sr.findAll();
	}
}
