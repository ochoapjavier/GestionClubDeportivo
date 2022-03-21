package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.GrupoEscuela;

@Repository
public interface GrupoRepositorio extends JpaRepository<GrupoEscuela, Integer> {
	
}
