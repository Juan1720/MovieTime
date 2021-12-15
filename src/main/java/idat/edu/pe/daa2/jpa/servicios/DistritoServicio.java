package idat.edu.pe.daa2.jpa.servicios;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Distrito;
import idat.edu.pe.daa2.jpa.repositorio.DistritoRepositorio;

@Service
@Transactional

public class DistritoServicio {
	
	@Autowired
	private DistritoRepositorio repositorio;
	
	public DistritoServicio() {
		
	}
	
	public List<Distrito>buscarTodo(){
		return(ArrayList<Distrito>) repositorio.findAll();
	}
	
	public Distrito crear(Distrito distrito) {
		
		return repositorio.save(distrito);
		
	}
	
	public Distrito actualizar(Distrito distritoActualizar) {
		
		Distrito distritoActual= repositorio.findById(distritoActualizar.getIdDistrito()).get();
		distritoActual.setIdDistrito(distritoActualizar.getIdDistrito());
		distritoActual.setDistrito(distritoActualizar.getDistrito());
		
		Distrito distritoActualizado = repositorio.save(distritoActual);
		return distritoActualizado;
	}
	
	public Distrito buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
	
	
	
	

}
