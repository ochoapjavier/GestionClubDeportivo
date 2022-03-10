package com.example.demo.bbdd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pista;

@Repository
public interface PistaRepositorio extends JpaRepository<Pista, Integer> {
	public Pista findByNombre(String nombre);

}
