package idat.edu.pe.daa2.jpa.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.VentaEntrada;

public interface VentaEntradaRepositorio extends CrudRepository<VentaEntrada,Integer> {
	
	@Query(value="SELECT v FROM VentaEntrada v WHERE v.fecha=?1")
	public List<VentaEntrada>buscarVentaEntradaPorFecha(Date fecha);
	
	@Query(value="SELECT v FROM VentaEntrada v WHERE v.fecha like CONCAT(?1,'%')")
	public List<VentaEntrada>buscarVentaEntradaLikeFecha(Date fecha);


}
