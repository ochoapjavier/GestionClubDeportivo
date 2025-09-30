package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PistaTenis {
	
	@Id
	@Column(name = "id_pista", nullable = false)
	private String id_pista;
	
	private String nombre;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_superficie", referencedColumnName = "id")
	private Superficie id_superficie;
	
	
	public PistaTenis(String nombre, Superficie id_superficie) {
		this.nombre = nombre;
		this.id_superficie = id_superficie;
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

	public Superficie getId_superficie() {
		return id_superficie;
	}

	public void setId_superficie(Superficie superficie) {
		this.id_superficie = superficie;
	}

	@Override
	public String toString() {
		return "PistaTenis [id_pista=" + id_pista + ", nombre=" + nombre + ", superficie=" + id_superficie + "]";
	}
	
}
