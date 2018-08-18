package semana09.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import semana09.entidad.Editorial;
import semana09.entidad.Genero;
import semana09.entidad.Libro;
import semana09.service.IEditorialService;
import semana09.service.IGeneroService;
import semana09.service.ILibroService;
import semana09.service.LibroService;

@Controller
public class HomeController {
	@Autowired
	ILibroService libroService;
	@Autowired
	IGeneroService generoService;
	@Autowired
	IEditorialService editorialService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("libros", libroService.listado());
		model.addAttribute("generos", generoService.listado());
		model.addAttribute("editoriales", editorialService.listado());
		
		return "home.html";
	}
	
	@RequestMapping(value="/libro/genero/{id}", method=RequestMethod.GET)
	public String buscarPorGenero(@PathVariable int id, Model model) {
		Optional<Genero> objGenero = generoService.buscarPorID(id);
		if(objGenero.isPresent()) {
			List<Libro> libros = libroService.buscarPorGenero(id);
			model.addAttribute("libros", libros);
			
			model.addAttribute("generos", generoService.listado());
			model.addAttribute("editoriales", editorialService.listado());
			
			model.addAttribute("objeto", objGenero.get());
			
			return "busqueda.html";
		}else {
			return "redirect:/";
		}		
	}
	
	@RequestMapping(value="/libro/editorial/{id}", method=RequestMethod.GET)
	public String buscarPorEditorial(@PathVariable int id, Model model) {
		Optional<Editorial> objEditorial = editorialService.buscarPorID(id);
		if(objEditorial.isPresent()) {
			List<Libro> libros = libroService.buscarPorEditorial(id);
			model.addAttribute("libros", libros);
			
			model.addAttribute("generos", generoService.listado());
			model.addAttribute("editoriales", editorialService.listado());
			
			model.addAttribute("objeto", objEditorial.get());
			
			return "busqueda.html";
		}else {
			return "redirect:/";
		}		
	}
	
	@RequestMapping(value="/contacto", method=RequestMethod.GET)
	public String contacto(Model model) {
		
		model.addAttribute("telefono", "12345678");
		model.addAttribute("correo", "correo@dominio.com");
		
		return "contacto";
	}
}
