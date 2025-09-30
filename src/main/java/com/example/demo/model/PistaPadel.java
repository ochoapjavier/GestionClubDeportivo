package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class PistaPadel {
	
	@Id 
	@Column(name = "id_pista", nullable = false)
	private String id_pista;
	
	private String nombre;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_superficie", referencedColumnName = "id")
	private Superficie id_superficie;
	
	private String tipoPared;
	
	private String cobertura;
		
	public PistaPadel(String nombre, Superficie id_superficie, String tipoPared, String cobertura) {
		this.nombre = nombre;
		this.id_superficie = id_superficie;
		this.tipoPared = tipoPared;
		this.cobertura = cobertura;	
	}
	
	public PistaPadel() {	
		
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

	@Override
	public String toString() {
		return "PistaPadel [id_pista=" + id_pista + ", nombre=" + nombre + ", superficie=" + id_superficie + ", tipoPared="
				+ tipoPared + ", cobertura=" + cobertura + "]";
	}
	
}
