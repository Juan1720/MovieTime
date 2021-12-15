package idat.edu.pe.daa2.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.daa2.jpa.modelo.Cine;
import idat.edu.pe.daa2.jpa.servicios.CineServicio;

@RestController
@RequestMapping ("/rest/cine")

public class CineRestController {
	
	@Autowired
	private CineServicio servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Cine>listaCine= servicio.buscarTodo();
		return new ResponseEntity<>(listaCine, HttpStatus.OK);
		
	}
	
}
