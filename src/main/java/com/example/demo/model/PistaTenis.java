package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PistaTenis {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pista;
	private String nombre;
	private String superficie;
	
	
	public PistaTenis(String nombre, String superficie) {
		this.nombre = nombre;
		this.superficie = superficie;
	}
	
	public PistaTenis() {	
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	
}
