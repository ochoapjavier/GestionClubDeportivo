/*package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class RelSesionReserva {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_sesion", referencedColumnName = "id")
	private Sesion id_sesion;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_reserva", referencedColumnName = "id")
	private ReservaPista id_reserva;
	
	public RelSesionReserva() {	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sesion getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(Sesion id_sesion) {
		this.id_sesion = id_sesion;
	}

	public ReservaPista getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(ReservaPista id_reserva) {
		this.id_reserva = id_reserva;
	}

}
*/