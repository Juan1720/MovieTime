package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.VentaEntrada;
import idat.edu.pe.daa2.jpa.repositorio.VentaEntradaRepositorio;

@Service
@Transactional

public class VentaEntradaServicio {
	
	@Autowired
	private VentaEntradaRepositorio repositorio;

	
	public VentaEntradaServicio() {
		
	}
	
	public List<VentaEntrada>buscarTodo(){
		return(List<VentaEntrada>)repositorio.findAll();
	}
	
	public VentaEntrada crear(VentaEntrada ventaentrada) {
		return repositorio.save(ventaentrada);
		
	}
	
	public VentaEntrada actualizar(VentaEntrada ventaentradaActualizar) {
		VentaEntrada ventaentradaActual = repositorio.findById(ventaentradaActualizar.getIdEntrada()).get();
		ventaentradaActual.setIdEntrada(ventaentradaActualizar.getIdEntrada());
		ventaentradaActual.setFunciones(ventaentradaActualizar.getFunciones());
		ventaentradaActual.setUsuario(ventaentradaActualizar.getUsuario());
		ventaentradaActual.setFecha(ventaentradaActualizar.getFecha());
		ventaentradaActual.setCantEntradas(ventaentradaActualizar.getCantEntradas());
		ventaentradaActual.setMontoTotal(ventaentradaActualizar.getMontoTotal());
		
		VentaEntrada ventaentradaActualizado = repositorio.save(ventaentradaActual);
		return ventaentradaActualizado;
	}
	
	public VentaEntrada buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
