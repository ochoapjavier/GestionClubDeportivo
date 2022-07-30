package com.example.demo.bbdd;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.example.demo.model.RelCompeticionUsuario;


@Repository
public interface RelGruposAlumnosRepositorio extends JpaRepository<RelCompeticionUsuario, Integer> {
	public RelCompeticionUsuario findById(int id);
	
	
}

