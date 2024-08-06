package com.example.demo.bbdd;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	public Usuario findByEmailAndPassword(String email, String password);
	public Usuario findByEmail(String email);
	public Usuario findById(int id);
	public Usuario saveAndFlush(Usuario u);
	public List<Usuario> findByRol(String rol);
	
	@Query(value="SELECT * FROM \r\n"
			+ "usuario WHERE id not in \r\n"
			+ "(SELECT id_alumno FROM grupo_escuela GE INNER JOIN rel_grupo_alumnos RGA ON GE.id = RGA.id_grupo WHERE GE.ID = :id_grupo ) and ROL = 'Usuario'",nativeQuery = true)
	public List<Usuario> findAlumnosParaInscribir(@Param("id_grupo") int id_grupo);
}

