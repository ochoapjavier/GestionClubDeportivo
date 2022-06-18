package com.example.demo.bbdd;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PistaPadel;
import com.example.demo.model.PistaTenis;

@Repository
public interface PistaPadelRepositorio extends JpaRepository<PistaPadel, String> {
	public PistaPadel findByNombre(String nombre);
	public Optional<PistaPadel> findById(String id);

}
