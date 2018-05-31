package semana09.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import semana09.entidad.Libro;
import semana09.service.IAutorService;
import semana09.service.IEditorialService;
import semana09.service.IGeneroService;
import semana09.service.ILibroService;

@Controller
public class LibroController {

	private static String FILE_ROUTE = "./src/main/resources/static/images/";

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
	public String guardar(@ModelAttribute @Valid Libro objLibro, BindingResult bindResult ,Model model,
							RedirectAttributes ra , @RequestParam("imagen") MultipartFile file ){
		if(bindResult.hasErrors()) {
			
			if(objLibro.getId() > 0) {
				return "admin/libro_editar";
			}else {
				return "admin/libro_agregar";
			}
		}else {
			objLibro.setImage(FILE_ROUTE +  file.getOriginalFilename());
			libroService.saveImage(file);
			boolean flag = libroService.agregar(objLibro);
			if(flag) {
				ra.addFlashAttribute("mensaje", "Autor guardado");
				return "redirect:/admin/libro/listado";
			}else {
				model.addAttribute("mensaje", "Ocurrió un error");
				if(objLibro.getId()>0) {
					return "admin/libro_editar";
				}else {
					return "admin/libro_agregar";
				}			
			}
		}
	}

	
	@RequestMapping(value="/admin/libro/listado", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("libros",libroService.listado());
		return "admin/libro_listado";
	}
	
	@RequestMapping(value="/admin/libro/eliminar/{id}", method=RequestMethod.GET)
	public String listar(@PathVariable int id , RedirectAttributes ra) {
		boolean flag = libroService.eliminar(id);
		if(flag) {
			ra.addFlashAttribute("mensaje", "Libro eliminado");
		}else {
			ra.addFlashAttribute("mensaje", "Ocurrio un error");
		}
		return "redirect:/admin/libro/listado";
	}
	
	@RequestMapping(value="/admin/libro/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable int id, 
			RedirectAttributes redirAtt,
			Model model) {
			Optional<Libro> obj = libroService.buscarPorID(id);
			
			if(!obj.isPresent()) {
				redirAtt.addFlashAttribute("error", "Libro no existe");
				return "redirect:/admin/libro/listado";
			}else {
				model.addAttribute("libro", obj);
				model.addAttribute("autores", autorService.listado());
				model.addAttribute("generos", serviceGenero.listado());
				model.addAttribute("editoriales", editorialService.listado());
				return "admin/libro_editar";
			}
	}
	
	
	
}
