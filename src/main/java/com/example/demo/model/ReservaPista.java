package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class ReservaPista {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_grupo;
	private String id_pista;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fecha;
	private int id_horario;

	public ReservaPista() {

	}
	
	public ReservaPista(String id_pista, int id_monitor, Date fecha) {
		this.id_pista = id_pista;
		this.id_horario = id_monitor;
		this.fecha = fecha;
	}

	public int getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getId_pista() {
		return id_pista;
	}

	public void setId_pista(String id_pista) {
		this.id_pista = id_pista;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId_horario() {
		return id_horario;
	}

	public void setId_horario(int id_horario) {
		this.id_horario = id_horario;
	}
	
}
