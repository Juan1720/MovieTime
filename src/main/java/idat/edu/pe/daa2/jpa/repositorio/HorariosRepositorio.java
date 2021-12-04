package idat.edu.pe.daa2.jpa.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Horarios;

public interface HorariosRepositorio extends CrudRepository<Horarios,Integer> {

	@Query(value="SELECT h FROM Horarios h WHERE h.dia=?1")
	public List<Horarios>buscarHorariosPorDia(Date dia);
	
	@Query(value="SELECT h FROM Horarios h WHERE h.dia like CONCAT(?1,'%')")
	public List<Horarios>buscarHorariosLikeDia(Date dia);
}
