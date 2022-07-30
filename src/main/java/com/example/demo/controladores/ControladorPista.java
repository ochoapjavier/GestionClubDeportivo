package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PistaPadel;
import com.example.demo.model.PistaTenis;
import com.example.demo.model.TorneoTenis;
import com.example.demo.servicios.PistaPadelServicio;
import com.example.demo.servicios.PistaTenisServicio;
import com.example.demo.servicios.SuperficiesServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/pistas"})
public class ControladorPista {
	@Autowired
	PistaTenisServicio pts;
	@Autowired
	PistaPadelServicio pps;
	
	@GetMapping("/tenis")
	public List <PistaTenis> listarPistasTenis(){
		List <PistaTenis> pistas = pts.listarPistas();
		return pistas;
	}
	 
	@GetMapping("/tenis/{id}")
	public Optional<PistaTenis> getPistaTenis(@PathVariable String id){
		 return pts.findById(id);

	}

	@GetMapping("/padel")
	public List <PistaPadel> listarPistasPadel(){
		List <PistaPadel> pistas = pps.listarPistas();
		return pistas;
	}
	
	@GetMapping("/padel/{id}")
	public Optional<PistaPadel> getPistaPadel(@PathVariable String id){
		 return pps.findById(id);

	}
	
	@PostMapping("/tenis")
	public PistaTenis crearPistaTenis(@Validated @RequestBody PistaTenis pista) {
		pts.savePista(pista);
		return pista;
   }
	
	@PostMapping("/padel")
	public PistaPadel crearPistaPadel(@Validated @RequestBody PistaPadel pista) {
		pps.savePista(pista);
		return pista;
   }
	
	@PutMapping("/tenis")
	public PistaTenis actualizarPistaTenis(@Validated @RequestBody PistaTenis pista) {
		PistaTenis p = new PistaTenis();
		p.setId_pista(pista.getId_pista());
		p.setNombre(pista.getNombre());
		p.setSuperficie(pista.getSuperficie());
		pts.actualizarPistaTenis(p);
		return p;
	}
	
	@PutMapping("/padel")
	public PistaPadel actualizarPistaTenis(@Validated @RequestBody PistaPadel pista) {
		PistaPadel p = new PistaPadel();
		p.setId_pista(pista.getId_pista());
		p.setNombre(pista.getNombre());
		p.setSuperficie(pista.getSuperficie());
		p.setCobertura(pista.getCobertura());
		p.setTipoPared(pista.getTipoPared());
		pps.actualizarPistaPadel(p);
		return p;
	}
	
	@DeleteMapping("tenis/{id}")
	public void eliminarPistaTenis(@PathVariable String id) {
		pts.eliminarPistaTenis(id);
    }
	
	@DeleteMapping("padel/{id}")
	public void eliminarPistaPadel(@PathVariable String id) {
		pps.eliminarPistaPadel(id);
    }
}
