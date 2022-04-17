package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RelGrupoAlumnos;


@Repository
public interface RelGrupoAlumnosRepositorio extends JpaRepository<RelGrupoAlumnos, Integer> {

}
