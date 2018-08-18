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
	public String guardar(@ModelAttribute @Valid Autor objAutor, 
							BindingResult bindResult,
							RedirectAttributes redirAtt, Model model) {
		if(bindResult.hasErrors()) {
			if(objAutor.getId()>0) {
				return "admin/autor_editar";
			}else {
				return "admin/autor_agregar";
			}
		}else {
			boolean flag;
			flag = service.agregar(objAutor);
			if(flag) {
				//model.addAttribute("mensaje", "Autor guardado");
				redirAtt.addFlashAttribute("mensaje", "Autor guardado");
				return "redirect:/admin/autor/listado";
			}else {
				model.addAttribute("mensaje", "Ocurrió un error");
				if(objAutor.getId()>0) {
					return "admin/autor_editar";
				}else {
					return "admin/autor_agregar";
				}			
			}
		}
	}
	
	@RequestMapping(value="/admin/autor/eliminar/{id}", 
									method=RequestMethod.GET)
	public String eliminar(@PathVariable int id, RedirectAttributes redirAtt) {
		boolean flag = service.eliminar(id);
		if(flag) {
			redirAtt.addFlashAttribute("mensaje", "Autor eliminado");
		}else {
			redirAtt.addFlashAttribute("error", "Ocurrió un error");
		}
		return "redirect:/admin/autor/listado";
	}
	
	@RequestMapping(value="/admin/autor/editar/{id}", 
									method=RequestMethod.GET)
	public String editar(@PathVariable int id, 
							RedirectAttributes redirAtt,
							Model model) {
		Optional<Autor> obj = service.buscarPorID(id);

		if(!obj.isPresent()) {
			redirAtt.addFlashAttribute("error", "Autor no existe");
			return "redirect:/admin/autor/listado";
		}else {
			model.addAttribute("autor", obj);
			return "admin/autor_editar";
		}
	}
}
