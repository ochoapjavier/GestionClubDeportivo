package com.example.demo.bbdd;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.EstadoCompeticiones;

@Repository
public interface EstadoRepositorio extends JpaRepository<EstadoCompeticiones, Integer> {

}

