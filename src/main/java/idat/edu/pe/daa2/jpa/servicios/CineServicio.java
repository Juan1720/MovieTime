package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Cine;
import idat.edu.pe.daa2.jpa.repositorio.CineRepositorio;

@Service
@Transactional

public class CineServicio {
	
	@Autowired
	private CineRepositorio repositorio;
	
	public CineServicio() {
		
	}
	
	public List<Cine>buscarTodo(){
		return(List<Cine>) repositorio.findAll();
	}
	
	public Cine crear(Cine cine) {
		return repositorio.save(cine);
	}
	
	public Cine actualizar(Cine cineActualizar) {
		Cine cineActual= repositorio.findById(cineActualizar.getIdCine()).get();
		cineActual.setIdCine(cineActualizar.getIdCine());
		cineActual.setCine(cineActualizar.getCine());
		cineActual.setDistrito(cineActualizar.getDistrito());
		cineActual.setTelefono(cineActualizar.getTelefono());
		cineActual.setDireccion(cineActualizar.getDireccion());
		cineActual.setImagen(cineActualizar.getImagen());
		cineActual.setEstado(cineActualizar.getEstado());
		
		Cine cineActualizado = repositorio.save(cineActualizar);
		return cineActualizado;
	}
	
	public Cine buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
