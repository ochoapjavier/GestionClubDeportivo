package com.example.demo.bbdd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	public Usuario findByEmailAndPassword(String email, String password);
	public Usuario findByEmail(String email);
	public Usuario saveAndFlush(Usuario u);
	public List<Usuario> findByRol(String rol);
}

