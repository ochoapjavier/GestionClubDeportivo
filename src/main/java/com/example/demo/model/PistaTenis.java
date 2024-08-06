package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PistaTenis {
	
	@Id
	@Column(name = "id_pista", nullable = false)
	private String id_pista;
	
	private String nombre;
	
	private String superficie;
	
	public PistaTenis(String nombre, String superficie) {
		this.nombre = nombre;
		this.superficie = superficie;
	}
	
	public PistaTenis() {	
		
	}

	public String getId_pista() {
		return id_pista;
	}

	public void setId_pista(String id_pista) {
		this.id_pista = id_pista;
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

	@Override
	public String toString() {
		return "PistaTenis [id_pista=" + id_pista + ", nombre=" + nombre + ", superficie=" + superficie + "]";
	}
	
}
