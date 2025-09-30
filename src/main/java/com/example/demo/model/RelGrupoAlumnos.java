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
public class RelGrupoAlumnos {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_grupo", referencedColumnName = "id")
	private GrupoEscuela id_grupo;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_alumno", referencedColumnName = "id")
	private Usuario id_alumno;
	
	public RelGrupoAlumnos() {	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GrupoEscuela getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(GrupoEscuela id_grupo) {
		this.id_grupo = id_grupo;
	}

	public Usuario getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(Usuario id_alumno) {
		this.id_alumno = id_alumno;
	}

}
