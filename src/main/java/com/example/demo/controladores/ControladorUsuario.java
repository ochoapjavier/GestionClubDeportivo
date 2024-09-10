package com.example.demo.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

@CrossOrigin(origins = "${frontend.url}")
@RestController
@RequestMapping({"/usuarios"})
public class ControladorUsuario {
	
	@Autowired
	UsuarioServicio us;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
	
	@GetMapping("/inscribir/{id_grupo}")
	public List <Usuario> getAlumnosParaInscribir(@PathVariable int id_grupo){
		List <Usuario> usuarios = us.listarAlumnosParaInscribir(id_grupo);
		return usuarios;
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
	public ResponseEntity<Usuario> crearUsuario(@Validated @RequestBody Usuario usuario) {
	    if (us.saveUsuario(usuario)) {
	        // Asegúrate de devolver un objeto usuario con el id incluido
	        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
	    }
	}
	@PutMapping()
	public Usuario actualizarUsuario(@Validated @RequestBody Usuario usuario) {

	    us.actualizarUsuario(usuario); // Llama al servicio para guardar
	    return usuario; // Devuelve el usuario actualizado
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
