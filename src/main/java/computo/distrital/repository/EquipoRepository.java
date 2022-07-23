package computo.distrital.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import computo.distrital.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long>  {
	@Modifying
	@Query(value = "UPDATE equipo SET goles = ?+goles, puntos =?+puntos WHERE id_equipo = ?;", nativeQuery = true)
	@Transactional
	public void editarEquipo(int goles, int puntos, Long idEquipo);
	
	 
	@Modifying
		@Query(value = " SELECT * FROM equipo ORDER BY puntos desc, goles desc;", nativeQuery = true)
		@Transactional
		public List<Equipo> findAll();
}
