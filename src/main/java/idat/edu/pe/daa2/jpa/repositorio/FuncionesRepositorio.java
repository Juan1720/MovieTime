package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Funciones;

public interface FuncionesRepositorio extends CrudRepository<Funciones,Integer> {
	
	@Query(value="SELECT f FROM Funciones f WHERE f.tipFuncion=?1")
	public List<Funciones>buscarFuncionesPorTipo_Funcion(String tipFuncion);
	
	@Query(value="SELECT f FROM Funciones f WHERE f.tipFuncion like CONCAT(?1,'%')")
	public List<Funciones>buscarFuncionesLikeTipo_Funcion(String tipFuncion);

}
