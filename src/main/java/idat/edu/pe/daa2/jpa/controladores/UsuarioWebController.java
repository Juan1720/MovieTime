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

import idat.edu.pe.daa2.jpa.modelo.Usuario;
import idat.edu.pe.daa2.jpa.servicios.UsuarioServicio;

@Controller	
@RequestMapping("/usuario")
public class UsuarioWebController {

	@Autowired
	private UsuarioServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarUsuario(Model model) {
		List<Usuario> listaUsuario= servicio.buscarTodo();
		model.addAttribute("listaUsuario",listaUsuario);
		return"/moduloUsuario/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoUsuario(Model model) {
		Usuario usuario= new Usuario();
		model.addAttribute("usuario", usuario);
		return "/moduloUsuario/nuevoUsuario";
	}
	
	@RequestMapping(value= "/guardar", method = RequestMethod.POST)
	public String CrearUsuario(@ModelAttribute("usuario")Usuario usuario) {
		servicio.crear(usuario);
		return "redirect:/usuario/listarTodo";
		
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarUsuario(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloUsuario/editarUsuario");
	    Usuario usuario= servicio.buscarPorId(id);
	    mav.addObject("usuario", usuario);
	    return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
	    return "redirect:/usuario/listarTodo";       
	}
}
