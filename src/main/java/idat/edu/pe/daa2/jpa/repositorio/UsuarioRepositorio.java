package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario,Integer>{
	
	@Query(value="SELECT u FROM Usuario u WHERE u.usuario=?1")
	public List<Usuario>buscarUsuarioPorUsuario(String usuario);
	
	@Query(value="SELECT u FROM Usuario u WHERE u.usuario like CONCAT(?1,'%')")
	public List<Usuario>buscarUsuarioLikeUsuario(String Usuario);


}
