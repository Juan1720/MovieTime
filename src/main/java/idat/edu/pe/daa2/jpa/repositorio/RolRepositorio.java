package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Rol;

public interface RolRepositorio extends CrudRepository<Rol,Integer>{
	
	@Query(value="SELECT r FROM Rol r WHERE r.rol=?1")
	public List<Rol>buscarRolPorRol(String rol);
	
	@Query(value="SELECT r FROM Rol  r WHERE r.rol like CONCAT(?1,'%')")
	public List<Rol>buscarRolLikeRol(String rol);


}
