package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Funciones;
import idat.edu.pe.daa2.jpa.repositorio.FuncionesRepositorio;

@Service
@Transactional
public class FuncionesServicio {
	
	@Autowired
	private FuncionesRepositorio repositorio;
	
	public FuncionesServicio() {
		
	}
	
	public List<Funciones>buscarTodo(){
		return(List<Funciones>)repositorio.findAll();
	}
	
	public Funciones crear(Funciones funciones) {
		return repositorio.save(funciones);
	}
	
	public Funciones actualizar(Funciones funcionesActualizar) {
		Funciones funcionesActual= repositorio.findById(funcionesActualizar.getIdFuncion()).get();
		funcionesActual.setIdFuncion(funcionesActualizar.getIdFuncion());
		funcionesActual.setCartelera(funcionesActualizar.getCartelera());
		funcionesActual.setCine(funcionesActualizar.getCine());
		
		funcionesActual.setSala(funcionesActualizar.getSala());
		funcionesActual.setFecha(funcionesActualizar.getFecha());
		funcionesActual.setHora(funcionesActualizar.getHora());
		
		funcionesActual.setTipFuncion(funcionesActualizar.getTipFuncion());
		funcionesActual.setEstado(funcionesActualizar.getEstado());
		
		Funciones funcionesActualizado = repositorio.save(funcionesActual);
		return funcionesActualizado;
		
	}
	
	public Funciones buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
