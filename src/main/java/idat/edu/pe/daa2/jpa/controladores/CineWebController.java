package idat.edu.pe.daa2.jpa.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Cine;
import idat.edu.pe.daa2.jpa.servicios.CineServicio;

@Controller
@RequestMapping("/cine")

public class CineWebController {
	
	@Autowired
	private CineServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarCine(Model model) {
		List<Cine> listaCine= servicio.buscarTodo();
		model.addAttribute("listaCine",listaCine);
		return "/moduloCine/listarTodo";	
	}
	
	@RequestMapping("/nuevo")
	public String CrearCursos(Model model) {
		Cine cine= new Cine();
		model.addAttribute("cine", cine);
		return "/moduloCine/nuevoCine";
	}
	
	@RequestMapping(value="/guardar", method= RequestMethod.POST)
	public String CrearCine(@ModelAttribute("cine")Cine cine) {
		servicio.crear(cine);
		return "redirect:/cine/listarTodo";
		
	}
	
	@RequestMapping(value="/actualizar/{id}")
	public ModelAndView editarCine(@PathVariable(name="id")int id) {
		ModelAndView mav= new ModelAndView("/moduloCine/editarCine");
		Cine cine= servicio.buscarPorId(id);
		mav.addObject("cine",cine);
		return mav;
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminarCine(@PathVariable(name="id")int id) {
		servicio.borrarPorID(id);
		return "redirect:/cine/listarTodo";
	}

}
