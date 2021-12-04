package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Cartelera;

public interface CarteleraRepositorio extends CrudRepository<Cartelera,Integer> {

	@Query(value="SELECT c FROM Cartelera c WHERE c.titulo=?1")
	public List<Cartelera>buscarCarteleraPorTitulo(String titulo);
	
	@Query(value="SELECT c FROM Cartelera c WHERE c.titulo like CONCAT(?1,'%')")
	public List<Cartelera>buscarCarteleraLikeTitulo(String titulo);
}
