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
	
	public Sesion actualizarSesion(Sesion sesion) {
        // Verifica si el ID es válido
        if (sesion.getId() != 0 && ss.existsById(sesion.getId())) {
            // Guarda el objeto, si el ID existe en la base de datos se actualizará, si no se creará un nuevo registro
            return ss.save(sesion);
        } else {
            throw new RuntimeException("No se puede actualizar, el registro no existe.");
        }
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
