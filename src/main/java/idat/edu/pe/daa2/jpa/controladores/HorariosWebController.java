package idat.edu.pe.daa2.jpa.controladores;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Horarios;
import idat.edu.pe.daa2.jpa.servicios.HorariosServicio;

@Controller
@RequestMapping("/horario")

public class HorariosWebController {
	
	@Autowired
	private HorariosServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarHorario(Model model) {
		List<Horarios> listaHorario= servicio.buscarTodo();
		model.addAttribute("listaHorario",listaHorario);
		return "/moduloHorario/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoHorarios(Model model) {
		Horarios horarios = new Horarios();
		model.addAttribute("horarios",horarios);
		return"/moduloHorario/nuevoHorario";
	}
	
	@RequestMapping(value="/actualizar/{id}")
	public ModelAndView editarHorario(@PathVariable(name="id")int id) {
		ModelAndView mav= new ModelAndView("/moduloHorari/editarHorario");
		Horarios horario= servicio.buscarPorId(id);
		mav.addObject("horario",horario);
		return mav;
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminarHorario(@PathVariable(name="id")int id) {
		servicio.borrarPorID(id);
		return "redirect:/horario/listarTodo";
	}
	
	

}
