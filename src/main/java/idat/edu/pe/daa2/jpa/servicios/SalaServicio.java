package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Sala;
import idat.edu.pe.daa2.jpa.repositorio.SalaRepositorio;

@Service
@Transactional

public class SalaServicio {
	
	@Autowired
	private SalaRepositorio repositorio;
	
	public SalaServicio() {
		
	}
	
	public List<Sala>buscarTodo(){
		return(List<Sala>) repositorio.findAll();
	}
	
	public Sala crear(Sala sala) {
		return repositorio.save(sala);
	}
	
	public Sala actualizar(Sala salaActualizar) {
		Sala salaActual= repositorio.findById(salaActualizar.getIdSala()).get();
		salaActual.setIdSala(salaActualizar.getIdSala());
		salaActual.setSala(salaActualizar.getCapacidad());
		salaActual.setCapacidad(salaActualizar.getCapacidad());
		salaActual.setCine(salaActualizar.getCine());
		
		Sala salaActualizado = repositorio.save(salaActual);
		return salaActualizado;
	}
	
	public Sala buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorId(Integer id) {
		repositorio.deleteById(id);
	}
	
	

}
