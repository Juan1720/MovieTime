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

import idat.edu.pe.daa2.jpa.modelo.Asientos;
import idat.edu.pe.daa2.jpa.servicios.AsientosServicio;

@Controller
@RequestMapping("/asientos")

public class AsientosWebController {
	
	@Autowired
	private AsientosServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarAsientos(Model model) {
		List<Asientos> listarAsientos = servicio.buscarTodo();
		model.addAttribute("listarAsientos",listarAsientos);
		return"/moduloAsientos/listarTodo";
				
	}
	
	@RequestMapping("/nuevo")
	public String nuevoAsientos(Model model) {
		Asientos asientos= new Asientos();
		model.addAttribute("asientos", asientos);
		return "/moduloAsientos/nuevoAsiento";
	}
	
	@RequestMapping(value="/guardar", method= RequestMethod.POST)
	public String CrearAsientos(@ModelAttribute("asientos")Asientos asientos) {
		servicio.crear(asientos);
		return "redirect:/asientos/listarTodo";
	}
	
	@RequestMapping(value="/actualicar/{id}")
	public ModelAndView editarAsientos (@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("/moduloAsientos/editarAsientos");
		Asientos asientos = servicio.buscarPorId(id);
		mav.addObject("asientos",asientos);
		return mav;
	}
	
	@RequestMapping(value="/actualizar/{id}")
	public String eliminarAsientos(@PathVariable(name="id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/asientos/listarTodo";
	}
	

}
