package source.open.semana14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import source.open.semana14.entidades.Movimiento;
import source.open.semana14.services.CuentaService;
import source.open.semana14.services.MovimientoService;
import source.open.semana14.services.SedeService;

@Controller
public class MovimientoController {
	@Autowired
	SedeService sedeService;
	
	@Autowired
	CuentaService cuentaService;
	
	@Autowired
	MovimientoService movimientoService;
	
	@RequestMapping(value="/movimiento/agregar")
	public String agregar(Model model) {
		model.addAttribute("sedes", sedeService.listado());
		model.addAttribute("cuentas", cuentaService.listado());
		
		model.addAttribute("movimiento", new Movimiento());
		
		return "admin/movimiento_registrar.html";
	}

	@RequestMapping(value="/movimiento/guardar", method=RequestMethod.POST)
	public String guardar(@ModelAttribute Movimiento objMov, Model model) {
		
		boolean flag = cuentaService.validarSaldo(objMov);
		if(flag) {
			flag = movimientoService.registrar(objMov);
			if(flag) {
				model.addAttribute("mensaje", "Movimiento guardado");
			}else {
				model.addAttribute("mensaje", "Ocurrió un error");
			}			
		}else {
			model.addAttribute("mensaje", "Error en guardado");
		}
		
		return "admin/resultado.html";
	}
}
