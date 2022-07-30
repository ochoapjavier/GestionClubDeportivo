package com.example.demo.bbdd;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Deporte;
import com.example.demo.model.TipoCompeticion;

@Repository
public interface TipoCompeticionRepositorio extends JpaRepository<TipoCompeticion, Integer> {

}

