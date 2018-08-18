package semana09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import semana09.entidad.Administrador;
import semana09.service.AdministradorService;

@Controller
public class AdminController {
		
	@Autowired
	AdministradorService adminService;

	@RequestMapping(value="/admin/login", method=RequestMethod.GET)
	public String login(Model model) {
		Administrador objAdmin = new Administrador();
		
		model.addAttribute("admin", objAdmin);
		
		return "admin/login";
	}
	
	@RequestMapping(value="/admin/dashboard", method=RequestMethod.GET)
	public String dashboard() {
		
		
		return "admin/dashboard";
	}
	
	@RequestMapping(value={"/admin/denied"})
	public String denied(){
		
		return "admin/denied";
	}
	
	@RequestMapping(value={"/admin/logout"})
	public String logout(){
		
		return "admin/login";
	}
}
