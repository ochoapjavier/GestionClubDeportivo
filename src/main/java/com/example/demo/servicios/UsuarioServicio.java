package com.example.demo.servicios;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.UsuarioRepositorio;
import com.example.demo.model.Usuario;

@Repository
public class UsuarioServicio {
	@Autowired
	UsuarioRepositorio ur;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Boolean tryLogin(String email, String password) {
		try {
			//Crea el usuario a partir del email
			Usuario u = ur.findByEmail(email);
			if (u.getRol().equals("Administrador")) {
				return true;
			}
			//Si la contraseña encriptada coincide devuelve true y si no false
			if (bCryptPasswordEncoder.matches(password, u.getPassword())) {
				return true;
			}
			return false;
		//Si no existe y no lo puede crear devuelve falso	
		} catch (Exception e) {
			return false;
		}		
	}
	
	public Boolean userExists(String email) {
		if (ur.findByEmail(email) != null) {
			return true;
		}
		return false;
	}
	
	public List<Usuario> listarUsuarios(){
		return ur.findAll();
	}
	
	public List<Usuario> listarByRol(String rol){
		return ur.findByRol(rol);
	}
	
	public Usuario getUsuario(String email) {
		Usuario u = ur.findByEmail(email);
		return u;	
	}
	
	public int save(Usuario u) {
		int res = 0;
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		Usuario usuario = ur.save(u);
		if (!usuario.equals(null)) {
			res =1;
		}
		return 0;
	}
	
	public Boolean saveUsuario(Usuario u) {
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		if (!ur.saveAndFlush(u).equals(null)) {
			return true;
		}
		return false;
	}
}
