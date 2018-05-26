package semana09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(value="/admin/login", method=RequestMethod.GET)
	public String login() {
		
		return "admin/login";
	}
	
	@RequestMapping(value="/admin/dashboard", method=RequestMethod.GET)
	public String dashboard() {
		
		
		return "admin/dashboard";
	}
}
