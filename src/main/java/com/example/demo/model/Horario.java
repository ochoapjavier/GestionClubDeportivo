package com.example.demo.model;


import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Time hora_inicio;
	
	private Time hora_fin;
	
	public Horario(Time hora_inicio, Time hora_fin) {
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}
	
	public Horario() {	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Time getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Time hora_fin) {
		this.hora_fin = hora_fin;
	}

}
