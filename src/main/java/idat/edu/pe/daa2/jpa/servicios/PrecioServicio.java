package idat.edu.pe.daa2.jpa.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Precio;
import idat.edu.pe.daa2.jpa.repositorio.PrecioRepositorio;

@Service
@Transactional

public class PrecioServicio {

	@Autowired
	private PrecioRepositorio repositorio;

	public PrecioServicio() {
	}

	public List<Precio> buscarTodo() {
		return (ArrayList<Precio>) repositorio.findAll();
	}

	public Precio crear(Precio precio) {

		return repositorio.save(precio);
	}

	public Precio actualizar(Precio precioActualizar) {

		Precio precioActual = repositorio.findById(precioActualizar.getIdPrecio()).get();
		precioActual.setIdPrecio(precioActualizar.getIdPrecio());
		precioActual.setPrecio(precioActualizar.getPrecio());
		precioActual.setDescripPrecio(precioActualizar.getDescripPrecio());

		Precio precioActualizado = repositorio.save(precioActual);
		return precioActualizado;
	}

	public Precio buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
	
}












