package idat.edu.pe.daa2.jpa.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Cartelera;
import idat.edu.pe.daa2.jpa.servicios.CarteleraServicio;

@Controller
@RequestMapping("/cartelera")

public class CarteleraWebController {
	
	@Autowired
	private CarteleraServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarCartelera(Model model) {
		List<Cartelera> listaCartelera=servicio.buscarTodo();
		model.addAttribute("listaCartelera",listaCartelera);
		return "/moduloCartelera/listarCartelera";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoCartelera(Model model) {
		Cartelera cartelera = new Cartelera();
		model.addAttribute("cartelera",cartelera);
		return "/moduloCartelera/nuevoCartelera";
				
	}
	
	@RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String CrearCartelera(@ModelAttribute("cartelera")Cartelera cartelera) {
		servicio.crear(cartelera);
		return "redirect:/cartelera/listarTodo";
		
	}
	
	
	
	

}
