package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pista {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pista;
	private String nombre;
	private int id_deporte;
	private int id_superficie;
	private int id_cerramientos;
	private int id_paredes;
	
	
	public Pista(String nombre, int id_deporte, int id_superficie, int id_cerramientos, int id_paredes) {

		this.nombre = nombre;
		this.id_deporte = id_deporte;
		this.id_superficie = id_superficie;
		this.id_cerramientos = id_cerramientos;
		this.id_paredes = id_paredes;		
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

	public int getId_deporte() {
		return id_deporte;
	}

	public void setId_deporte(int id_deporte) {
		this.id_deporte = id_deporte;
	}

	public int getId_superficie() {
		return id_superficie;
	}

	public void setId_superficie(int id_superficie) {
		this.id_superficie = id_superficie;
	}

	public int getId_cerramientos() {
		return id_cerramientos;
	}

	public void setId_cerramientos(int id_cerramientos) {
		this.id_cerramientos = id_cerramientos;
	}

	public int getId_paredes() {
		return id_paredes;
	}

	public void setId_paredes(int id_paredes) {
		this.id_paredes = id_paredes;
	}
}
