package semana09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		
		
		return "home.html";
	}
	
	@RequestMapping(value="/contacto", method=RequestMethod.GET)
	public String contacto(Model model) {
		
		model.addAttribute("telefono", "12345678");
		model.addAttribute("correo", "correo@dominio.com");
		
		return "contacto";
	}
}
