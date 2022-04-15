package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TorneoTenis;

@Repository
public interface TorneoTenisRepositorio extends JpaRepository<TorneoTenis, String> {
	//public TorneoTenis findByNombre(String nombre);

}
