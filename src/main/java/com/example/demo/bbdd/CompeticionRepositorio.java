package com.example.demo.bbdd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Competicion;

@Repository
public interface CompeticionRepositorio extends JpaRepository<Competicion, Integer> {
	public Competicion findById(int id);
	
	@Query(value="SELECT * FROM competicion WHERE TIPO_COMPETICION_ID = :tipo_competicion_id",nativeQuery = true)
	public List<Competicion> findByTipoCompeticion(@Param("tipo_competicion_id") int tipo_competicion_id);
	
	@Query(value="SELECT * FROM competicion WHERE DEPORTE_ID = :deporte_id",nativeQuery = true)
	public List<Competicion> findByDeporte(@Param("deporte_id") int deporte_id);
	
	@Query(value="SELECT * \r\n"
			+ "FROM COMPETICION \r\n"
			+ "WHERE ID NOT IN (\r\n"
			+ "	SELECT ID_COMPETICION \r\n"
			+ "  	FROM rel_competicion_usuario\r\n"
			+ "  	WHERE ID_USUARIO = :id_usuario\r\n"
			+ ") AND estado_id = :estado_id",nativeQuery = true)
	public List<Competicion> findByEstado(@Param("estado_id") int estado_id, @Param("id_usuario") int id_usuario);

	@Query(value="SELECT C.* FROM \r\n"
			+ "rel_competicion_usuario AS RLC\r\n"
			+ "INNER JOIN competicion AS C\r\n"
			+ "ON RLC.id_competicion = c.id\r\n"
			+ "WHERE C.tipo_competicion_id = 1\r\n"
			+ "AND RLC.id_usuario = :id_usuario",nativeQuery = true)
	public List<Competicion> listaTorneoByUsuarioID(@Param("id_usuario") int id_usuario);
	
	@Query(value="SELECT C.* FROM \r\n"
			+ "rel_competicion_usuario AS RLC\r\n"
			+ "INNER JOIN competicion AS C\r\n"
			+ "ON RLC.id_competicion = c.id\r\n"
			+ "WHERE C.tipo_competicion_id = 2\r\n"
			+ "AND RLC.id_usuario = :id_usuario",nativeQuery = true)
	public List<Competicion> listaRankingByUsuarioID(@Param("id_usuario") int id_usuario);

}
