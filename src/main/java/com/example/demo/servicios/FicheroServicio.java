package com.example.demo.servicios;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bbdd.FicheroRepositorio;
import com.example.demo.model.Fichero;

@Service
public class FicheroServicio {
		
	@Autowired
	FicheroRepositorio ficheroRepositorio;

	public Fichero storeFile(MultipartFile file) throws IOException {
		Fichero fichero = new Fichero();
		
		fichero.setFilename(file.getOriginalFilename());
		fichero.setType(file.getContentType());
		try {
			fichero.setData(file.getBytes());
		} catch (IOException e) {
			throw new IOException("Error al intentar leer el fichero subido");
		}
		
		ficheroRepositorio.save(fichero);
			
		return fichero;
	}

}
