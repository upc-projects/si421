package semana09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import semana09.entidad.Autor;
import semana09.service.IAutorService;

@Controller
public class AutorController {
	
	@Autowired
	IAutorService service;

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
}
