package com.example.demo.bbdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ReservaPista;

@Repository
public interface ReservaPistaRepositorio extends JpaRepository<ReservaPista, Integer> {
	
}
