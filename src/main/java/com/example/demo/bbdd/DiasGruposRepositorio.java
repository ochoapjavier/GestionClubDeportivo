package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DiasGrupos;

@Repository
public interface DiasGruposRepositorio extends JpaRepository<DiasGrupos, Integer> {

}

