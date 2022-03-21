package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrupoEscuela {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_grupo;
	private String deporte;
	private int id_monitor;
	private String id_pista;
	//private List<Usuario> listaAlumnos;
	
	public GrupoEscuela() {

	}
	
	public GrupoEscuela(String deporte, int id_monitor, String id_pista) {
		this.deporte = deporte;
		this.id_monitor = id_monitor;
		this.id_pista = id_pista;
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
}
