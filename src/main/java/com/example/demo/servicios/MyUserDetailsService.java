package com.example.demo.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.bbdd.UsuarioRepositorio;
import com.example.demo.model.Usuario;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepositorio ur;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = ur.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
    
    public int getUserIdByEmail(String email) {
        Usuario usuario = ur.findByEmail(email);
        if (usuario != null) {
            return usuario.getId(); //
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + email);
        }
    }
}
