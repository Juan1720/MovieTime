package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Usuario;
import idat.edu.pe.daa2.jpa.repositorio.UsuarioRepositorio;

@Service
@Transactional

public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public UsuarioServicio() {
		
	}
	
	
	public List<Usuario> buscarTodo(){
		
		return(List<Usuario>) repositorio.findAll();
	}
	
	public Usuario crear(Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	public Usuario actualizar(Usuario usuarioActualizar) {
		Usuario usuarioActual= repositorio.findById(usuarioActualizar.getIdUsuario()).get();
		usuarioActual.setIdUsuario(usuarioActualizar.getIdUsuario());
		usuarioActual.setTipRol(usuarioActualizar.getTipRol());
		usuarioActual.setContrasena(usuarioActualizar.getContrasena());
		usuarioActual.setNombres(usuarioActualizar.getNombres());
		usuarioActual.setApellidos(usuarioActualizar.getApellidos());
		usuarioActual.setDni(usuarioActualizar.getDni());
		usuarioActual.setCorreo(usuarioActualizar.getCorreo());
		usuarioActual.setTelefono(usuarioActualizar.getTelefono());
		usuarioActual.setDireccion(usuarioActualizar.getDireccion());
		
		Usuario usuarioActualizado = repositorio.save(usuarioActual);
		return usuarioActualizado;
	}
	
	public Usuario buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
