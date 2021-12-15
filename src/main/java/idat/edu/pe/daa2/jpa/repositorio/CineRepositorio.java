package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Cine;

public interface CineRepositorio extends CrudRepository<Cine,Integer> {
	
	@Query(value="SELECT c FROM Cine c WHERE c.cine=?1")
	public List<Cine>buscarCinePorCine(String cine);
	
	@Query(value="SELECT c FROM Cine c WHERE c.cine like CONCAT(?1,'%')")
	public List<Cine>buscarCineLikeCine(String cine);

}
