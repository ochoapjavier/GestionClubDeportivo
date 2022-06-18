package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class ReservaPista {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String id_pista;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fecha;
	
	 @OneToOne
	 @NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_horario", referencedColumnName = "id")
	private Horario id_horario;

	public ReservaPista() {

	}
	


	public int getId() {
		return id;
	}

	public void setId(int id_grupo) {
		this.id = id_grupo;
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

	public Horario getHorario() {
		return this.id_horario;
	}

	public void setHorario(Horario horarios) {
		this.id_horario = horarios;
	}

	
}
