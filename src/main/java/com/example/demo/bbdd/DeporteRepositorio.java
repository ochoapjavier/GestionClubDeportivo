package com.example.demo.bbdd;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Deporte;

@Repository
public interface DeporteRepositorio extends JpaRepository<Deporte, Integer> {

}

