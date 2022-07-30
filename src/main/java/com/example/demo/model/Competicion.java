package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Competicion {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre_torneo;
	private String categoria;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "deporte_id", referencedColumnName = "id")
	private Deporte deporte_id;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "estado_id", referencedColumnName = "id")
	private EstadoCompeticiones estado_id;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "tipo_competicion_id", referencedColumnName = "id")
	private TipoCompeticion tipo_competicion_id;
	
	private int max_jugadores;
	
	public Competicion(String nombre) {
		this.nombre_torneo = nombre;
	}
	
	public Competicion() {	
		
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Deporte getDeporte_id() {
		return deporte_id;
	}

	public void setDeporte_id(Deporte deporte_id) {
		this.deporte_id = deporte_id;
	}

	public EstadoCompeticiones getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(EstadoCompeticiones estado_id) {
		this.estado_id = estado_id;
	}

	public TipoCompeticion getTipo_competicion_id() {
		return tipo_competicion_id;
	}

	public void setTipo_competicion_id(TipoCompeticion tipo_competicion_id) {
		this.tipo_competicion_id = tipo_competicion_id;
	}

	public int getMax_jugadores() {
		return max_jugadores;
	}

	public void setMax_jugadores(int max_jugadores) {
		this.max_jugadores = max_jugadores;
	}

}
