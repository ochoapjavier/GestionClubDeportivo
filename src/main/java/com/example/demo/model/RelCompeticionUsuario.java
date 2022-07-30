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
public class RelCompeticionUsuario {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_competicion", referencedColumnName = "id")
	private Competicion id_competicion;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario id_usuario;
	
	public RelCompeticionUsuario() {	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Competicion getId_competicion() {
		return id_competicion;
	}

	public void setId_competicion(Competicion id_competicion) {
		this.id_competicion = id_competicion;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}


}
