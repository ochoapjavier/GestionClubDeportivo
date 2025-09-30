package com.example.demo.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.dao.DataIntegrityViolationException;
import java.util.Map;
import java.util.Collections;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping({"/usuarios"})
public class ControladorUsuario {
	
	@Autowired
	UsuarioServicio us;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> listaUsuarios(){
		List <Usuario> usuarios = us.listarUsuarios();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable int id){
		Usuario u = us.findById(id);
		if (u == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/inscribir/{id_grupo}")
	public ResponseEntity<List<Usuario>> getAlumnosParaInscribir(@PathVariable int id_grupo){
		List <Usuario> usuarios = us.listarAlumnosParaInscribir(id_grupo);
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/rol/{rol}")
	public ResponseEntity<List<Usuario>> getUsuario(@PathVariable String rol){
		List <Usuario> usuarios = us.listarByRol(rol);
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping()
    public ResponseEntity<?> crearUsuario(@Validated @RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = us.saveUsuario(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            Map<String, String> errorResponse = Collections.singletonMap("message", "El email ya está en uso.");
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = Collections.singletonMap("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST); // O 400 Bad Request
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@PutMapping()
	public ResponseEntity<Usuario> actualizarUsuario(@Validated @RequestBody Usuario usuario) {
	    us.actualizarUsuario(usuario);
	    return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
		us.eliminarUsuario(id);
		return ResponseEntity.noContent().build();
    }
	
	@PostMapping("/login")
	public ResponseEntity<?> postLogin(@Validated @RequestBody Usuario usuario) {
		boolean loginExitoso = us.tryLogin(usuario.getEmail(), usuario.getPassword());

		if (loginExitoso) {
			Usuario usuarioLogueado = us.getUsuario(usuario.getEmail());
			return ResponseEntity.ok(usuarioLogueado);
		} else {
			Map<String, String> errorResponse = Collections.singletonMap("message", "Credenciales incorrectas. Por favor, inténtelo de nuevo.");
			return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
		}
	}
}
