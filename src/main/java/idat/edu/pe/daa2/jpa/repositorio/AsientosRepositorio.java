package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Asientos;

public interface AsientosRepositorio extends CrudRepository<Asientos, Integer> {
	
	@Query(value="SELECT a FROM Asientos a WHERE a.asiento=?1")
	public List<Asientos>buscarAsientoPorAsiento(String asiento);
	
	@Query(value="SELECT a FROM Asientos a WHERE a.asiento like CONCAT(?1,'%')")
	public List<Asientos>buscarAsientoLikeAsientos(String asiento);

}
