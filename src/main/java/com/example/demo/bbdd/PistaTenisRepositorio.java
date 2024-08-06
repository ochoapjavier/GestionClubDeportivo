package com.example.demo.bbdd;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.PistaTenis;

@Repository
public interface PistaTenisRepositorio extends JpaRepository<PistaTenis, String> {
	public PistaTenis findByNombre(String nombre);
	public Optional<PistaTenis> findById(String id);

}
