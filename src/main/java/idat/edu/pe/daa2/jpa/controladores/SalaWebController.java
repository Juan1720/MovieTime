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

import idat.edu.pe.daa2.jpa.modelo.Sala;
import idat.edu.pe.daa2.jpa.servicios.SalaServicio;

@Controller
@RequestMapping("/sala")

public class SalaWebController {
	
	@Autowired
	private SalaServicio servicio;
	
	@RequestMapping("listarTodo")
	public String listarSala(Model model) {
		List<Sala> listaSala= servicio.buscarTodo();
		model.addAttribute("listaSala",listaSala);
		return"/moduloSala/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoSala(Model model) {
		Sala sala= new Sala();
		model.addAttribute("sala",sala);
		return "/moduloSala/listarTodo";
	}
	
	@RequestMapping(value="/guardar", method= RequestMethod.POST)
	public String CrearSala(@ModelAttribute("sala")Sala sala) {
		servicio.crear(sala);
		return "redirect:/sala/listarTodo";
	}
	
	@RequestMapping(value="/actualizar/{id}")
	public ModelAndView editarSala(@PathVariable(name="id")int id) {
		ModelAndView mav= new ModelAndView("/moduloSala/editarSala");
		Sala sala= servicio.buscarPorId(id);
		mav.addObject("sala",sala);
		return mav;
	}
	
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminarSala(@PathVariable(name="id")int id) {
		servicio.borrarPorId(id);
		return "redirect:/sala/listarTodo";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
