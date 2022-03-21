package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PistaTenis;

@Repository
public interface PistaTenisRepositorio extends JpaRepository<PistaTenis, String> {
	public PistaTenis findByNombre(String nombre);

}
