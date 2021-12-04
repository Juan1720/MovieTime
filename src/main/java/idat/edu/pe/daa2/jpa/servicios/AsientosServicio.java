package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Asientos;
import idat.edu.pe.daa2.jpa.repositorio.AsientosRepositorio;

@Service
@Transactional

public class AsientosServicio {
	
	@Autowired
	private AsientosRepositorio repositorio;
	
	public AsientosServicio() {
		
	}
	
	public List<Asientos> buscarTodo(){
		return(List<Asientos>) repositorio.findAll();
	}
	
	public Asientos crear(Asientos asientos) {
		return repositorio.save(asientos);
	}
	
	public Asientos Actualizar(Asientos asientosActualizar) {
		Asientos asientosActual= repositorio.findById(asientosActualizar.getIdAsientos()).get();
		asientosActual.setIdAsientos(asientosActualizar.getIdAsientos());
		asientosActual.setAsiento(asientosActualizar.getAsiento());
		asientosActual.setSala(asientosActualizar.getSala());
		asientosActual.setEstado(asientosActualizar.getEstado());
		
		Asientos asientosActualizado = repositorio.save(asientosActual);
		return asientosActualizado;
	}
	
	public Asientos buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorId(Integer id) {
		repositorio.deleteById(id);
	}
	
	public void actualizar(int id,Asientos asientos) {
		Asientos asientosActual = repositorio.findById(id).get();
		asientosActual.setAsiento(asientos.getAsiento());
		asientosActual.setSala(asientos.getSala());
		asientosActual.setEstado(asientos.getEstado());
	}

}
