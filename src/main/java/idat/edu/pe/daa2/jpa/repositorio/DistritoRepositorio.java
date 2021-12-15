package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Distrito;

public interface  DistritoRepositorio extends CrudRepository<Distrito,Integer> {
	
	@Query(value="SELECT d FROM Distrito d WHERE d.distrito=?1")
	public List<Distrito>buscarDistritoPorDistrito(String distrito);
	
	@Query(value="SELECT d FROM Distrito d WHERE d.distrito like CONCAT (?1,'%')")
	public List<Distrito>buscarDistritoLikeDistrito(String distrito);
	

}
