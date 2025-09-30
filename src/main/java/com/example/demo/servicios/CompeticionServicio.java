package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.CompeticionRepositorio;
import com.example.demo.model.Competicion;
import com.example.demo.model.RelCompeticionUsuario;

@Repository
public class CompeticionServicio {
	
	@Autowired
	CompeticionRepositorio cr;
	
	public List<Competicion> listarCompeticiones(){
		return cr.findAll();
	}
	
	public List<Competicion> findRankingByUsuarioId(int id) {
		return cr.listaRankingByUsuarioID(id);
	}
	
	public List<Competicion> findTorneoByUsuarioId(int id) {
		return cr.listaTorneoByUsuarioID(id);
	}
	
	public List<Competicion> listarTorneos(){
		return cr.findByTipoCompeticion(1);
	}
	
	public List<Competicion> listarRankings(){
		return cr.findByTipoCompeticion(2);
	}
	
	public List<Competicion> listarCompeticionesTenis(){
		return cr.findByDeporte(1);
	}
	
	public List<Competicion> listarCompeticionesPadel(){
		return cr.findByDeporte(2);
	}
	
	public List<Competicion> listarCompeticionesInscripcion(int usuario_id){
		return cr.findByEstado(1, usuario_id);
	}
	
	public Competicion findById(int id) {
		return cr.findById(id);
	}
	
	public Boolean saveCompeticion(Competicion c) {
		if (!cr.saveAndFlush(c).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean actualizarCompeticion(Competicion c) {
		
		if (!cr.save(c).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean eliminarCompeticion(int id) {		
		try {
			cr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
