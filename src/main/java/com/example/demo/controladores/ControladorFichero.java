package com.example.demo.controladores;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.demo.bbdd.FicheroRepositorio;
import com.example.demo.model.Fichero;
import com.example.demo.model.UploadFileResponse;
import com.example.demo.servicios.FicheroServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/fichero"})
public class ControladorFichero {
	
	@Autowired
	FicheroServicio uploadServiceBBDD;
	
	@Autowired
	FicheroRepositorio ficheroRepositorio;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UploadFileResponse uploadFile(@RequestParam MultipartFile file) throws IOException {
		Fichero fichero = uploadServiceBBDD.storeFile(file);
		
		String fileNameLocal = fichero.getFilename();

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/file/")
                .path(fileNameLocal)
                .toUriString();               
        
        return new UploadFileResponse(fileNameLocal, fileDownloadUri,
                file.getContentType(), file.getSize(), fichero.getId());

	}
	
	@GetMapping("/{id_fichero}")
	@CrossOrigin()
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Fichero> getFile( @PathVariable long id_fichero, HttpServletRequest req) {
		
		Optional<Fichero> fichero = ficheroRepositorio.findById(id_fichero);
		
		return fichero;
	}
 
}
