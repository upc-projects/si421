package source.open.pc02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import source.open.pc02.entidades.CursoAlumno;
import source.open.pc02.service.AlumnoService;
import source.open.pc02.service.CursoAlumnoService;
import source.open.pc02.service.CursoService;
import source.open.pc02.service.SedeService;

@Controller
public class NotasController {
	@Autowired
	SedeService sedeService;
	@Autowired
	AlumnoService alumnoService;
	@Autowired
	CursoService cursoService;
	
	@Autowired
	CursoAlumnoService cursoAlumnoService;

	@RequestMapping(value="/admin/nota/registrar")
	public String registrar(Model model) {
		model.addAttribute("sedes", sedeService.listar());
		model.addAttribute("cursos", cursoService.listar());
		model.addAttribute("alumnos", alumnoService.listar());
		
		CursoAlumno obj = new CursoAlumno();
		model.addAttribute("cursoalumno", obj);
		
		return "admin/nota_registrar.html";
	}
	
	@RequestMapping(value="/admin/nota/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute CursoAlumno obj,  Model model) {
		
		boolean flag = cursoAlumnoService.guardar(obj);
		if(flag) {
			model.addAttribute("mensaje", "Registro guardado");
		}else {
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		return "admin/resultado.html";
	}
	
	@RequestMapping(value="admin/nota/reporte", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("notas", cursoAlumnoService.listar());
		
		return "admin/reporte.html";
	}
}
