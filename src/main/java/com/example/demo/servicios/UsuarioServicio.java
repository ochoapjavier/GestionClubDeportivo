package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataIntegrityViolationException;
import com.example.demo.bbdd.UsuarioRepositorio;
import com.example.demo.model.Usuario;

@Repository
public class UsuarioServicio {
	
	@Autowired
	UsuarioRepositorio ur;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Usuario findById(int id) {
		return ur.findById(id);
	}
	
	public Boolean tryLogin(String email, String password) {
		try {
			//Crea el usuario a partir del email
			Usuario u = ur.findByEmail(email);
			if (u.getRol().equals("Administrador")) {
				return true;
			}
			//Si la contrase�a encriptada coincide devuelve true y si no false
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
	
	public List<Usuario> listarAlumnosParaInscribir(int id_grupo){
		return ur.findAlumnosParaInscribir(id_grupo);
	}
	
	public List<Usuario> listarByRol(String rol){
		return ur.findByRol(rol);
	}
	
	public Usuario getUsuario(String email) {
		Usuario u = ur.findByEmail(email);
		return u;	
	}
	
	public Usuario saveUsuario(Usuario u) {
        try {
            System.out.println("UsuarioServicio.saveUsuario - Input password: " + u.getPassword());
            
            if (u.getPassword() == null || u.getPassword().trim().isEmpty()) {
                throw new IllegalArgumentException("La contraseña no puede ser nula o vacía.");
            }

            String encodedPassword = bCryptPasswordEncoder.encode(u.getPassword().trim());
            System.out.println("UsuarioServicio.saveUsuario - Encoded password: " + encodedPassword);
            u.setPassword(encodedPassword);

            Usuario savedUser = ur.saveAndFlush(u);
            System.out.println("UsuarioServicio.saveUsuario - Saved user ID: " + (savedUser != null ? savedUser.getId() : "null"));

            if (savedUser == null) {
                 throw new IllegalStateException("Fallo al guardar el usuario en la base de datos.");
            }
            return savedUser;
        } catch (Exception e) {
            System.err.println("UsuarioServicio.saveUsuario - Error: " + e.getMessage());
            throw e;
        }
    }
	
	public Boolean actualizarUsuario(Usuario u) {
	    // Busca el usuario existente por ID
	    Usuario usuarioExistente = ur.findById(u.getId());

	    if (usuarioExistente == null) {
	        return false; // Usuario no encontrado
	    }

	    // Solo encripta la contraseña si se proporciona una nueva
	    if (u.getPassword() != null && !u.getPassword().isEmpty()) {
	        usuarioExistente.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
	    } else {
	        // Mantiene la contraseña actual si no se proporciona una nueva
	        usuarioExistente.setPassword(usuarioExistente.getPassword());
	    }

	    // Actualiza otros campos
	    usuarioExistente.setEmail(u.getEmail());
	    usuarioExistente.setNombre(u.getNombre());
	    usuarioExistente.setApellido1(u.getApellido1());
	    usuarioExistente.setApellido2(u.getApellido2());
	    usuarioExistente.setRol(u.getRol());
	    usuarioExistente.setPrivacidad(u.getPrivacidad());
	    usuarioExistente.setTerminos(u.getTerminos());
	    usuarioExistente.setComercial(u.getComercial());
	    usuarioExistente.setId_fichero(u.getId_fichero());

	    // Guarda el usuario actualizado
	    ur.save(usuarioExistente);

	    return true; // Retorna true si la actualización fue exitosa
	}

	
	public Boolean eliminarUsuario(int id) {		
		try {
			ur.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
