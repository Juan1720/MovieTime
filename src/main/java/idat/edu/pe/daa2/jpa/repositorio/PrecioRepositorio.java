package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Precio;

public interface PrecioRepositorio extends CrudRepository<Precio, Integer>{

	@Query(value="SELECT p FROM Precio p WHERE p.precio=?1")
	public List<Precio>buscarPrecioPorDescripPrecio(String DescripPrecio);
	
	@Query(value="SELECT p FROM Precio p WHERE p.precio like CONCAT (?1,'%')")
	public List<Precio>buscarPrecioLikeDescripPrecio(String DescripPrecio);
	
	
}
