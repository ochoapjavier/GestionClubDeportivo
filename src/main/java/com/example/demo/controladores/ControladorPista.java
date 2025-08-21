package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.PistaPadel;
import com.example.demo.model.PistaTenis;
import com.example.demo.servicios.PistaPadelServicio;
import com.example.demo.servicios.PistaTenisServicio;

@RestController
@RequestMapping({"/pistas"})
public class ControladorPista {
	
	@Autowired
	PistaTenisServicio pts;
	
	@Autowired
	PistaPadelServicio pps;
	
	@GetMapping("/tenis")
	public ResponseEntity<List<PistaTenis>> listarPistasTenis(){
		List <PistaTenis> pistas = pts.listarPistas();
		return ResponseEntity.ok(pistas);
	}
	 
	@GetMapping("/tenis/{id}")
	public ResponseEntity<PistaTenis> getPistaTenis(@PathVariable String id){
		 return pts.findById(id)
				 .map(ResponseEntity::ok)
				 .orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/padel")
	public ResponseEntity<List<PistaPadel>> listarPistasPadel(){
		List <PistaPadel> pistas = pps.listarPistas();
		return ResponseEntity.ok(pistas);
	}
	
	@GetMapping("/padel/{id}")
	public ResponseEntity<PistaPadel> getPistaPadel(@PathVariable String id){
		return pps.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/tenis")
	public ResponseEntity<PistaTenis> crearPistaTenis(@Validated @RequestBody PistaTenis pista) {
		pts.savePista(pista);
		return new ResponseEntity<>(pista, HttpStatus.CREATED);
   }
	
	@PostMapping("/padel")
	public ResponseEntity<PistaPadel> crearPistaPadel(@Validated @RequestBody PistaPadel pista) {
		pps.savePista(pista);
		return new ResponseEntity<>(pista, HttpStatus.CREATED);
   }
	
	@PutMapping("/tenis")
	public ResponseEntity<PistaTenis> actualizarPistaTenis(@Validated @RequestBody PistaTenis pista) {
		boolean actualizada = pts.actualizarPistaTenis(pista);
		return actualizada ? ResponseEntity.ok(pista) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/padel")
	public ResponseEntity<PistaPadel> actualizarPistaPadel(@Validated @RequestBody PistaPadel pista) {
		boolean actualizada = pps.actualizarPistaPadel(pista);
		return actualizada ? ResponseEntity.ok(pista) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/tenis/{id}")
	public ResponseEntity<Void> eliminarPistaTenis(@PathVariable String id) {
		if (!pts.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pts.eliminarPistaTenis(id);
		return ResponseEntity.noContent().build();
    }
	
	@DeleteMapping("/padel/{id}")
	public ResponseEntity<Void> eliminarPistaPadel(@PathVariable String id) {
		if (!pps.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pps.eliminarPistaPadel(id);
		return ResponseEntity.noContent().build();
    }
	
}
