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

import idat.edu.pe.daa2.jpa.modelo.Precio;
import idat.edu.pe.daa2.jpa.servicios.PrecioServicio;

@Controller
@RequestMapping("/precio")

public class PrecioWebController {
	
	@Autowired
	private PrecioServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarPrecio(Model model) {
		List<Precio> listaPrecio= servicio.buscarTodo();
		model.addAttribute("listaPrecio",listaPrecio);
		return"/moduloPrecio/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoPrecio(Model model) {
		Precio precio= new Precio();
		model.addAttribute("precio", precio);
		return "/moduloPrecio/nuevoPrecio";
	}
	
	@RequestMapping(value= "/guardar", method = RequestMethod.POST)
	public String CrearPrecio(@ModelAttribute("precio")Precio precio) {
		servicio.crear(precio);
		return "redirect:/precio/listarTodo";
		
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarPrecio(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloPrecio/editarPrecio");
	    Precio precio= servicio.buscarPorId(id);
	    mav.addObject("usuario", precio);
	    return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarPrecio(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
	    return "redirect:/precio/listarTodo";       
	}
	
}
