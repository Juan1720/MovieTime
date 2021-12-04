package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Sala;

public interface SalaRepositorio extends CrudRepository<Sala,Integer>{
	
	@Query(value="SELECT s FROM Sala s WHERE s.sala=?1")
	public List<Sala>buscarSalaPorSala(String sala);
	
	@Query(value="SELECT s FROM Sala s WHERE s.sala like CONCAT(?1,'%')")
	public List<Sala>buscarSalaLikeSala(String sala);


}
