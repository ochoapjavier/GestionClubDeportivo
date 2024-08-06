package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Fichero;

@Repository
public interface FicheroRepositorio extends JpaRepository<Fichero, Long> {
	Fichero findByFilename(String filename);
	Fichero findByid(long id);
}
