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
public class GrupoEscuela {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	private String nombre;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_monitor", referencedColumnName = "id_usuario")
	private Usuario id_monitor;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_deporte", referencedColumnName = "id")
	private Deporte id_deporte;
	
	private int capacidad;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_dias_grupo", referencedColumnName = "id")
	private DiasGrupos id_dias_grupo;
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "id_horario", referencedColumnName = "id")
	private Horario id_horario;

	public GrupoEscuela() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getId_monitor() {
		return id_monitor;
	}

	public void setId_monitor(Usuario id_monitor) {
		this.id_monitor = id_monitor;
	}

	public Deporte getId_deporte() {
		return id_deporte;
	}

	public void setId_deporte(Deporte id_deporte) {
		this.id_deporte = id_deporte;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public DiasGrupos getId_dias_grupo() {
		return id_dias_grupo;
	}

	public void setId_dias_grupo(DiasGrupos id_dias_grupo) {
		this.id_dias_grupo = id_dias_grupo;
	}

	public Horario getId_horario() {
		return id_horario;
	}

	public void setId_horario(Horario id_horario) {
		this.id_horario = id_horario;
	}

	
}
