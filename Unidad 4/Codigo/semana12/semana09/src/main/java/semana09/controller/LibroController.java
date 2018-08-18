package semana09.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import semana09.entidad.Autor;
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
	public String guardar(@ModelAttribute @Valid Libro objLibro, 
			BindingResult bindResult,
			RedirectAttributes redirAtt, Model model) {
		
		if(bindResult.hasErrors()) {
			model.addAttribute("autores", autorService.listado());
			model.addAttribute("generos", serviceGenero.listado());
			model.addAttribute("editoriales", editorialService.listado());
			
			if(objLibro.getId()>0) {
				return "admin/libro_editar";
			}else {
				return "admin/libro_crear";
			}
		}else {
			boolean flag;
			flag = libroService.agregar(objLibro);
			if(flag) {
				redirAtt.addFlashAttribute("mensaje", "Libro guardado");
				return "redirect:/admin/libro/listado";
			}else {
				model.addAttribute("mensaje", "Ocurrió un error");
				if(objLibro.getId()>0) {
					return "admin/libro_editar";
				}else {
					return "admin/libro_crear";
				}			
			}
		}
	}
	
	@RequestMapping(value="/admin/libro/listado")
	public String listado(Model model){
		model.addAttribute("libro", new Libro());
		model.addAttribute("listadoLibros", libroService.listado());
		
		return "admin/libro_listado";
	}
	
	@RequestMapping(value="/admin/libro/buscarPorPrecio")
	public String busquedaPorPrecio(@ModelAttribute Libro objLibro, Model model){
		model.addAttribute("listadoLibros", libroService.buscarPorPrecio(objLibro.getPrecio()));
		
		
		return "admin/libro_listado";
	}
	
	@RequestMapping(value="/admin/libro/eliminar/{id}", method=RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes redirAtt) {
		boolean flag = libroService.eliminar(id);
		if(flag) {
			redirAtt.addFlashAttribute("mensaje", "Libro eliminado");
		}else {
			redirAtt.addFlashAttribute("error", "Ocurrió un error");
		}
		return "redirect:/admin/libro/listado";
	}
	
	@RequestMapping(value="/admin/libro/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable int id,  RedirectAttributes redirAtt, Model model) {
		Optional<Libro> obj = libroService.buscarPorID(id);
		
		if(!obj.isPresent()) {
			redirAtt.addFlashAttribute("error", "Libro no existe");
			return "redirect:/admin/libro/listado";
		}else {
			model.addAttribute("autores", autorService.listado());
			model.addAttribute("generos", serviceGenero.listado());
			model.addAttribute("editoriales", editorialService.listado());
			
			
			model.addAttribute("libro", obj);
			return "admin/libro_editar";
		}
	}
}
