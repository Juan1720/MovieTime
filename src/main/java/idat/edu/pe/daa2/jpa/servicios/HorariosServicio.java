package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import idat.edu.pe.daa2.jpa.modelo.Horarios;
import idat.edu.pe.daa2.jpa.repositorio.HorariosRepositorio;

@Service
@Transactional
public class HorariosServicio {
	
	@Autowired
	private HorariosRepositorio repositorio;
	
	public HorariosServicio() {
		
	}
	
	public List<Horarios>buscarTodo(){
		return(List<Horarios>) repositorio.findAll();
		
	}
	
	public Horarios crear(Horarios horarios) {
		return repositorio.save(horarios);
	}
	
	public Horarios actualizar(Horarios horariosActualizar) {
		Horarios horariosActual= repositorio.findById(horariosActualizar.getIdHorario()).get();
		horariosActual.setIdHorario(horariosActualizar.getIdHorario());
		horariosActual.setDia(horariosActualizar.getDia());
		horariosActual.setHora(horariosActualizar.getHora());
		
		Horarios horariosActualizado = repositorio.save(horariosActual);
		return horariosActualizado;
	}
	
	public Horarios buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
