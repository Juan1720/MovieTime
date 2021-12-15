package idat.edu.pe.daa2.controladores.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.daa2.jpa.modelo.Distrito;
import idat.edu.pe.daa2.jpa.servicios.DistritoServicio;

@RestController
@RequestMapping ("/rest/distrito")

public class DistritoRestController {
	
	@Autowired
	private DistritoServicio servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Distrito>listaDistrito= servicio.buscarTodo();
		return new ResponseEntity<>(listaDistrito, HttpStatus.OK);
	}
	
	@GetMapping (path = "/detalle/{id}")
	public String buscarDistritoPorId(@PathVariable("id")Integer id) {
		Distrito d= Distrito.getOne(id);
		
	
	}

}
