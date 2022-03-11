package com.example.demo.bbdd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Superficie;

@Repository
public interface SuperficiesRepositorio extends JpaRepository<Superficie, Integer> {
	public List<Superficie> findByDeporte(String deporte);
}

