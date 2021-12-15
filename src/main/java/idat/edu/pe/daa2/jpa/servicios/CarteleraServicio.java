package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Cartelera;
import idat.edu.pe.daa2.jpa.repositorio.CarteleraRepositorio;

@Service
@Transactional

public class CarteleraServicio {
	
	@Autowired
	private CarteleraRepositorio repositorio;
	
	public CarteleraServicio() {
		
	}
	
	public List<Cartelera>buscarTodo(){
		return(List<Cartelera>) repositorio.findAll();
		
	}
	
	public Cartelera crear(Cartelera cartelera) {
		return repositorio.save(cartelera);
	}
	
	public Cartelera actualizar(Cartelera carteleraActualizar) {
		Cartelera carteleraActual= repositorio.findById(carteleraActualizar.getIdCartelera()).get();
		carteleraActual.setIdCartelera(carteleraActualizar.getIdCartelera());
		carteleraActual.setTitulo(carteleraActualizar.getTitulo());
		carteleraActual.setGenero(carteleraActualizar.getGenero());
		carteleraActual.setDuracion(carteleraActualizar.getDuracion());
		carteleraActual.setDirector(carteleraActualizar.getDirector());
		carteleraActual.setClasificacion(carteleraActualizar.getClasificacion());
		carteleraActual.setImagen(carteleraActualizar.getImagen());
		
		Cartelera carteleraActualizado = repositorio.save(carteleraActual);
		return carteleraActualizado;
	}
	
	public Cartelera buscarPorId(Integer id) {
		return repositorio.findById(id).get();
		
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
