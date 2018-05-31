package semana09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import semana09.service.ILibroService;

import javax.jws.WebParam;

@Controller
public class HomeController {

	@Autowired
	ILibroService bookService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("books",bookService.listado());
		return "home";
	}
	
	@RequestMapping(value="/contacto", method=RequestMethod.GET)
	public String contacto(Model model) {
		
		model.addAttribute("telefono", "12345678");
		model.addAttribute("correo", "correo@dominio.com");
		return "contacto";
	}
}
