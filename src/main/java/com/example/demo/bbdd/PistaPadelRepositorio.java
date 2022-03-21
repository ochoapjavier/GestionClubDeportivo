package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PistaPadel;

@Repository
public interface PistaPadelRepositorio extends JpaRepository<PistaPadel, String> {
	public PistaPadel findByNombre(String nombre);

}
