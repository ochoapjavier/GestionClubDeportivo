package com.example.demo.controladores;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioServicio;

@Controller
public class ControladorUsuario {
	@Autowired
	UsuarioServicio usuarioRepositorio;
	
	@GetMapping({"/index","index.html"})
	public String getIndex() {
		return "index";
	}
	
	@GetMapping({"/about","/about.html"})
	public String getAbout() {
		return "about";
	}
	
	@GetMapping({"/login","/login.html"})
	public String getLogin() {
		return "login";
	}
	
	@GetMapping({"/registro","/registro.html"})
	public String getRegistro() {
		return "registro";
	}
	
	@GetMapping({"/eventos","/eventos.html"})
	public String getEventos() {
		return "eventos";
	}
	
	@GetMapping({"/clases-particulares","/clases-particulares.html"})
	public String getClasesParticulares() {
		return "clases-particulares";
	}
	
	@GetMapping({"/area-personal-alumno","/area-personal-alumno.html"})
	public String getAreaPersonalAlumno() {
		return "area-personal-alumno";
	}
	
	@GetMapping({"/area-personal-monitor","/area-personal-monitor.html"})
	public String getAreaPersonalMonitor() {
		return "area-personal-monitor";
	}
	
	@GetMapping({"/area-personal-coordinador","/area-personal-coordinador.html"})
	public String getAreaPersonalCoordinador() {
		return "area-personal-coordinador";
	}
	@GetMapping({"/dashboard-administrador","/dashboard-administrador.html"})
	public String getAreaDashboardAdministrador() {
		return "dashboard-administrador";
	}
	
	@GetMapping({"/dashboard-coordinador","/dashboard-coordinador.html"})
	public String getAreaDashboardCoordinador() {
		return "dashboard-coordinador";
	}
	
	@GetMapping({"/dashboard-monitor","/dashboard-monitor.html"})
	public String getAreaDashboardMonitor() {
		return "dashboard-monitor";
	}
	
	@GetMapping({"/dashboard-usuario","/dashboard-usuario.html"})
	public String getAreaDashboardUsuario() {
		return "dashboard-usuario";
	}
	
	@GetMapping({"/nuevo-usuario","/nuevo-usuario.html"})
	public String getNuevoUsuario(Model modelo) {
		Usuario u = new Usuario();
		u.setRol("Usuario");
		modelo.addAttribute("usuario",u);
		return "nuevo-usuario";
	}
	
	@GetMapping({"/nuevo-monitor","/nuevo-monitor.html"})
	public String getNuevoMonitor(Model modelo) {
		Usuario u = new Usuario();
		u.setRol("Monitor");
		modelo.addAttribute("usuario",u);
		return "nuevo-usuario";
	}
	
	@GetMapping({"/nuevo-coordinador","/nuevo-coordinador.html"})
	public String getNuevoCoordinadoro(Model modelo) {
		Usuario u = new Usuario();
		u.setRol("Coordinador");
		modelo.addAttribute("usuario",u);
		return "nuevo-usuario";
	}
	
	@PostMapping ("/save")
	public String save (@Validated Usuario u, Model modelo) {
		usuarioRepositorio.saveUsuario(u);
		return "area-personal-coordinador";
	}

	@PostMapping({"/busqueda-usuarios","/busqueda-usuarios.html"})
	public String listar(Model modelo, @RequestParam String rol) {	
		//modelo.addAttribute("usuarios",usuarioRepositorio.listarUsuarios());
		modelo.addAttribute("usuarios",usuarioRepositorio.listarByRol(rol));
		return "busqueda-usuarios";
	}
	
	@PostMapping({"/login", "/login.html"})
	public String postLogin(@RequestParam String email, @RequestParam String password, Model modelo) {
		if (usuarioRepositorio.tryLogin(email, password)) {
			modelo.addAttribute("bienvenido", "Bienvenido " + usuarioRepositorio.getUsuario(email).getNombre());
			modelo.addAttribute("nombre", usuarioRepositorio.getUsuario(email).getNombre() + " " + usuarioRepositorio.getUsuario(email).getApellido1());
			switch (usuarioRepositorio.getUsuario(email).getRol()) {
			case "Usuario":
				modelo.addAttribute("success", "Login exitoso (alumno) de " + usuarioRepositorio.getUsuario(email).getNombre());
				return "dashboard-alumno";
			case "Monitor":
				modelo.addAttribute("success", "Login exitoso (monitor) de " + usuarioRepositorio.getUsuario(email).getNombre());
				return "dashboard-monitor";		
			case "Coordinador":
				modelo.addAttribute("success", "Login exitoso (coordinador) de " + usuarioRepositorio.getUsuario(email).getNombre());
				return "dashboard-coordinador";
			case "Administrador":
				modelo.addAttribute("success", "Login exitoso (administrador) de " + usuarioRepositorio.getUsuario(email).getNombre());
				return "dashboard-administrador";
			default:
				break;
			}
		} 
		modelo.addAttribute("error", "Credenciales incorrectas");
		return "login";
	}
	
	@PostMapping({"/registro", "/registro.html"})
	public String postRegistro(@RequestParam String nombre, @RequestParam String apellido1, @RequestParam String apellido2 ,@RequestParam String email, @RequestParam() String password, @RequestParam(required = true) Integer terminos, @RequestParam(required = false) Integer privacidad, @RequestParam(required = false) Integer comercial, Model modelo) {
		//Si no hay ningún usuario asociado a ese email puede crearse
		if(!usuarioRepositorio.userExists(email)) {
			if (terminos==null) {
				terminos = 0;
			}
			if (privacidad==null) {
				privacidad = 0;
			}
			if (comercial==null) {
				comercial = 0;
			}
			Usuario u = new Usuario(email, password, nombre, apellido1, apellido2, "Usuario", terminos, privacidad, comercial);
			usuarioRepositorio.saveUsuario(u);
			modelo.addAttribute("success", "Registro exitoso de " + email);
			return "login";			
		} 
		modelo.addAttribute("error", "El email " + email + "  ya está registrado");
		return "registro";
	}
}
