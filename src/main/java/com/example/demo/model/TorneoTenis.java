package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TorneoTenis {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre_torneo;
	private int id_jugador;
	private String categoria;
	private int max_jugadores;
		
	public TorneoTenis() {	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_torneo() {
		return nombre_torneo;
	}

	public void setNombre_torneo(String nombre_torneo) {
		this.nombre_torneo = nombre_torneo;
	}

	public int getId_jugador() {
		return id_jugador;
	}

	public void setId_jugador(int id_jugador) {
		this.id_jugador = id_jugador;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getMax_jugadores() {
		return max_jugadores;
	}

	public void setMax_jugadores(int max_jugadores) {
		this.max_jugadores = max_jugadores;
	}

}
