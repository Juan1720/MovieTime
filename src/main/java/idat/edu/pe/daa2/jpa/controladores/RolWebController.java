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

import idat.edu.pe.daa2.jpa.modelo.Rol;
import idat.edu.pe.daa2.jpa.servicios.RolServicio;

@Controller
@RequestMapping("/rol")

public class RolWebController {
	
	@Autowired
	private RolServicio servicio;
	
	 @RequestMapping("/listarTodo")
	 public String listarRol(Model model) {
		 List<Rol> listaRol= servicio.buscarTodo();
		 model.addAttribute("listaRol",listaRol);
		 return"/moduloRol/listarTodo";
	 }
	 
	 @RequestMapping("Nuevo")
	 public String nuevoRol(Model model) {
		 Rol rol= new Rol();
		 model.addAttribute("rol",rol);
		 return "/moduloRol/nuevoRol";
	 }
	 
	 @RequestMapping(value="/guardar",method= RequestMethod.POST)
	 public String CrearRol(@ModelAttribute("rol")Rol rol) {
		 servicio.crear(rol);
		 return "redirect:/rol/listarTodo";
	 }
	 
	 @RequestMapping(value="/actualizar/{id}")
	 public ModelAndView editarRol(@PathVariable(name="id")int id) {
		 ModelAndView mav = new ModelAndView("moduloRol/editarRol");
		 Rol rol = servicio.buscarPorId(id);
		 mav.addObject("rol",rol);
		 return mav;
	 }
	 
	 @RequestMapping(value="/elimnar/{id}")
	 public String eliminarRol(@PathVariable(name="id")int id) {
		 servicio.borrarPorID(id);
		 return "redirect:/rol/listarTodo";
	 }
	 
	 
	 
	 
	 
	 
	 
	 

}
