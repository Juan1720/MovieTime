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

import idat.edu.pe.daa2.jpa.modelo.Distrito;
import idat.edu.pe.daa2.jpa.servicios.DistritoServicio;

@Controller
@RequestMapping("/distrito")
public class DistritoWebController {
	
	@Autowired
	private DistritoServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarDistrito(Model model) {
		List<Distrito>listaDistrito= servicio.buscarTodo();
		model.addAttribute("listaDistrito", listaDistrito);
		return "/moduloDistrito/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoDistrito(Model model) {
		Distrito distrito = new Distrito();
		model.addAttribute("distrito",distrito);
		return ("moduloDistrito/listarTodo");
	}
	
	@RequestMapping(value="/guardar", method=RequestMethod.POST)
	public String CrearDistrito(@ModelAttribute("distrito")Distrito distrito) {
		servicio.crear(distrito);
		return "redirect:/distrito/listarTodo";
	}
	
	@RequestMapping(value="/actualizar/{id}")
	public ModelAndView editarDistrito(@PathVariable(name="id")int id) {
		ModelAndView mav = new ModelAndView("/moduloDistrito/editarDistrito");
		Distrito distrito= servicio.buscarPorId(id);
		mav.addObject("distrito",distrito);
		return mav;
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminarDistrito(@PathVariable(name="id")int id) {
		servicio.borrarPorID(id);
		return "redirect:/distrito/listarTodo";
	}

}
