package semana09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import semana09.entidad.Libro;
import semana09.service.IAutorService;
import semana09.service.IEditorialService;
import semana09.service.IGeneroService;
import semana09.service.ILibroService;

@Controller
public class LibroController {
	
	@Autowired
	IGeneroService serviceGenero;
	@Autowired
	IEditorialService editorialService;
	@Autowired
	IAutorService autorService;
	
	@Autowired
	ILibroService libroService;

	@RequestMapping(value="/admin/libro/agregar", method=RequestMethod.GET)
	public String agregar(Model model) {
		
		Libro objLibro = new Libro();
		model.addAttribute("libro", objLibro);
		
		model.addAttribute("autores", autorService.listado());
		model.addAttribute("generos", serviceGenero.listado());
		model.addAttribute("editoriales", editorialService.listado());
		
		return "admin/libro_crear";
	}
	
	@RequestMapping(value="/admin/libro/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute Libro objLibro, Model model) {
		boolean flag = libroService.agregar(objLibro);
		if(flag) {
			model.addAttribute("mensaje", "Libro guardado");
		}else {
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		return "admin/resultado";
	}
}
