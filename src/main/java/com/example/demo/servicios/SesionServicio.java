package com.example.demo.servicios;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bbdd.SesionRepositorio;
import com.example.demo.model.Sesion;

@Repository
public class SesionServicio {
	
	@Autowired
	SesionRepositorio ss;
	
	public List<Sesion> listarSesiones(){
		return ss.findAll();
	}
	
	public List<Sesion> listarSesionesByUserID(int id_usuario){
		return ss.listarSesionesByUserID(id_usuario);
	}
	
	public List<Sesion> listarSesionesFuturasByUserID(int id_usuario){
		return ss.listarSesionesFuturasByUserID(id_usuario);
	}
	
	public List<Sesion> listarSesionesByMonitorID(int id_monitor){
		return ss.listarSesionesByMonitorID(id_monitor);
	}
	
	public List<Sesion> listarSesionesFuturasByMonitorID(int id_monitor){
		return ss.listarSesionesFuturasByMonitorID(id_monitor);
	}
	
	public Sesion findById(int id) {
		return ss.findById(id);
	}
	
	public Sesion findByFechaYGrupo(int id_monitor, int id_grupo, Date date) {
		LocalDate converDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ss.getSesionByGrupoYFecha(id_monitor, id_grupo, converDate);
	}
	
	public Boolean saveSesion(Sesion sesion) {
		if (!ss.saveAndFlush(sesion).equals(null)) {
			return true;
		}
		return false;
	}
	
	public Boolean actualizarSesion(Sesion sesion) {
		
		if (!ss.save(sesion).equals(null)) {
			return true;
		}
		return false;
	}

	public Boolean eliminarSesion(int id) {		
		try {
			ss.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
