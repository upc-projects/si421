package semana09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import semana09.entidad.Autor;
import semana09.service.IAutorService;

@Controller
public class AutorController {


	@Autowired
	private IAutorService service;

	@RequestMapping(value="/admin/autor/listado", method=RequestMethod.GET)
	public String adminListado(Model model) {
		model.addAttribute("autores", service.listado());
		return "admin/autor_listado";
	}
	
	@RequestMapping(value="/admin/autor/agregar", method=RequestMethod.GET)
	public String agregar(Model model) {
		Autor objAutor = new Autor();
		model.addAttribute("autor", objAutor);
		
		return "admin/autor_agregar";
	}
	
	@RequestMapping(value="/admin/autor/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute Autor objAutor, Model model) {
		boolean flag;
		flag = service.agregar(objAutor);
		if(flag) {
			model.addAttribute("mensaje", "Autor guardado");
		}else {
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		return "admin/resultado";
	}

	@RequestMapping(value = "/admin/autor/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes ra){
		boolean flag = service.eliminar(id);
		if (flag){
			ra.addFlashAttribute("mensaje","Autor eliminado!");
		}else{
			ra.addFlashAttribute("mensaje","Ocurrio un error!");
		}
		return "redirect:/admin/autor/listado";
	}
	
	@RequestMapping(value = "/admin/autor/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable int id,
						RedirectAttributes ra,
						Model model) {
		Autor obj = service.buscarPorId(id);
		if(obj == null) {
			ra.addFlashAttribute("error","Autor no existe");
			return "redirect:/admin/autor/listado";
		}else {
			model.addAttribute("autor",obj);
			return "admin/autor_editar";
		}
	}
		
	
	
}
