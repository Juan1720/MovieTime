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

import idat.edu.pe.daa2.jpa.modelo.VentaEntrada;
import idat.edu.pe.daa2.jpa.servicios.VentaEntradaServicio;

@Controller
@RequestMapping("/ventaEntrada")
public class VenteEntradaWebController {

	@Autowired
	private VentaEntradaServicio servicio;

	@RequestMapping("/listarTodo")
	public String listarVentaEntrada(Model model) {
		List<VentaEntrada> listaVentaEntrada= servicio.buscarTodo();
		model.addAttribute("listaVentaEntrada", listaVentaEntrada);
		return "/moduloVentaEntrada/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoEstudiante(Model model) {
		VentaEntrada ventaEntrada= new VentaEntrada();
		model.addAttribute("ventaEntrada", ventaEntrada);		
		return "/moduloVentaEntrada/nuevoVentaEntrada";
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearVentaEntrada(@ModelAttribute("ventaEntrada") VentaEntrada ventaEntrada) {
		 servicio.crear(ventaEntrada);
	    return "redirect:/estudiante/listarTodo";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarVentaEntrada(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloVentaEntrada/editarVentaEntrada");
	    VentaEntrada ventaEntrada= servicio.buscarPorId(id);
	    mav.addObject("ventaEntrada",ventaEntrada);
	    return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarVentaEntrada(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
	    return "redirect:/ventaEntrada/listarTodo";       
	}
}
