package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrupoEscuela {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String id_pista;
	private int id_monitor;
	private String deporte;
	private int capacidad;	
	private int id_dias_grupo;
	private int id_horario;

	public GrupoEscuela() {

	}
	
	public GrupoEscuela(String deporte, int id_monitor, String id_pista) {
		this.deporte = deporte;
		this.id_monitor = id_monitor;
		this.id_pista = id_pista;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeporte() {
		return deporte;
	}
	
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public int getId_monitor() {
		return id_monitor;
	}
	public void setId_monitor(int id_monitor) {
		this.id_monitor = id_monitor;
	}

	public String getId_pista() {
		return id_pista;
	}

	public void setId_pista(String id_pista) {
		this.id_pista = id_pista;
	}

	public int getId_dias_grupo() {
		return id_dias_grupo;
	}

	public void setId_dias_grupo(int id_dias_grupo) {
		this.id_dias_grupo = id_dias_grupo;
	}

	public int getId_horario() {
		return id_horario;
	}

	public void setId_horario(int id_horario) {
		this.id_horario = id_horario;
	}

	@Override
	public String toString() {
		return "GrupoEscuela [id=" + id + ", id_pista=" + id_pista + ", id_monitor=" + id_monitor + ", deporte="
				+ deporte + ", capacidad=" + capacidad + ", id_dias_grupo=" + id_dias_grupo + ", id_horario="
				+ id_horario + "]";
	}
}
