package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	private String password;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String rol;
	private int terminos;
	private int privacidad;
	private int comercial;
	private long id_fichero;
	
	public Usuario(String email, String password, String nombre, String apellido1, String apellido2, String rol, int terminos, int privacidad, int comercial) {
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.rol = rol;
		this.terminos = terminos;
		this.privacidad = privacidad;
		this.comercial = comercial;
		
	}

	public Usuario() {

	}
	
	public int getTerminos() {
		return terminos;
	}

	public void setTerminos(int terminos) {
		this.terminos = terminos;
	}

	public int getPrivacidad() {
		return privacidad;
	}

	public void setPrivacidad(int privacidad) {
		this.privacidad = privacidad;
	}

	public int getComercial() {
		return comercial;
	}

	public void setComercial(int comercial) {
		this.comercial = comercial;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getId_fichero() {
		return id_fichero;
	}

	public void setId_fichero(long id_fichero) {
		this.id_fichero = id_fichero;
	}
	
}
