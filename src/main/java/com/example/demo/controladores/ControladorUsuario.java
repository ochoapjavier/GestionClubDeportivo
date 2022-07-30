package com.example.demo.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/usuarios"})
public class ControladorUsuario {
	
	@Autowired
	UsuarioServicio us;
	
	@GetMapping()
	public List <Usuario> listaUsuarios(){
		List <Usuario> usuarios = us.listarUsuarios();
		for (Usuario usuario : usuarios) {
			usuario.setPassword("");
		}
		return usuarios;
	}

	@GetMapping("/{id}")
	public Usuario getUsuario(@PathVariable int id){
		Usuario u = us.findById(id);
		u.setPassword("");
		return u;
	}
	
	@GetMapping("/rol/{rol}")
	public List <Usuario> getUsuario(@PathVariable String rol){
		List <Usuario> usuarios = us.listarByRol(rol);
		for (Usuario usuario : usuarios) {
			usuario.setPassword("");
		}
		return usuarios;
	}
	
	@PostMapping()
	public Usuario crearUsuario(@Validated @RequestBody Usuario usuario) {
		us.saveUsuario(usuario);
		return usuario;
    }
	
	@PutMapping()
	public Usuario actualizarUsuario(@Validated @RequestBody Usuario usuario) {
		Usuario u = new Usuario();
		u.setId(usuario.getId());
		u.setEmail(usuario.getEmail());
		u.setNombre(usuario.getNombre());
		u.setApellido1(usuario.getApellido1());
		u.setApellido2(usuario.getApellido2());
		u.setRol(usuario.getRol());
		u.setPrivacidad(usuario.getPrivacidad());
		u.setTerminos(usuario.getTerminos());
		u.setComercial(usuario.getComercial());
		u.setPassword(usuario.getPassword());
		us.actualizarUsuario(u);
		return u;
    }
	
	@DeleteMapping("/{id}")
	public void eliminarUsuario(@PathVariable int id) {
		us.eliminarUsuario(id);
    }
	
	@PostMapping("/login")
	public Usuario postLogin(@Validated @RequestBody Usuario usuario) {
		if (us.tryLogin(usuario.getEmail(), usuario.getPassword())) {
			return us.getUsuario(usuario.getEmail());
		}
		return usuario;
	}
}
