package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Rol;
import idat.edu.pe.daa2.jpa.repositorio.RolRepositorio;

@Service
@Transactional

public class RolServicio {
	
	@Autowired
	private RolRepositorio repositorio;
	
	public RolServicio() {
		
	}
	
	public List<Rol>buscarTodo(){
		return(List<Rol>) repositorio.findAll();
	}
	
	public Rol crear(Rol rol) {
		return repositorio.save(rol);
	}
	
	public Rol actualizar(Rol rolActualizar) {
		Rol rolActual = repositorio.findById(rolActualizar.getIdRol()).get();
		rolActual.setIdRol(rolActualizar.getIdRol());
		rolActual.setRol(rolActualizar.getRol());
		
		Rol rolActualizado =repositorio.save(rolActual);
		return rolActualizado;
	}
	
	public Rol buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
