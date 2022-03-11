package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PistaPadel {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pista;
	private String nombre;
	private String superficie;
	private String tipoPared;
	private String cobertura;
		
	public PistaPadel(String nombre, String superficie, String tipoPared, String cobertura) {
		this.nombre = nombre;
		this.superficie = superficie;
		this.tipoPared = tipoPared;
		this.cobertura = cobertura;	
	}
	
	public PistaPadel() {	
		
	}

	public int getId_pista() {
		return id_pista;
	}

	public void setId_pista(int id_pista) {
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

	public String getTipoPared() {
		return tipoPared;
	}

	public void setTipoPared(String tipoPared) {
		this.tipoPared = tipoPared;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}	
}
