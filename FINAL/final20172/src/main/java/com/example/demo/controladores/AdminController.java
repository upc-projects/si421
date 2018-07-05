package com.example.demo.controladores;

import com.example.demo.entidades.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.servicios.IEmpresaService;
import com.example.demo.servicios.IRubroService;
import com.example.demo.servicios.ISoftwareService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.RecursiveTask;

@Controller
public class AdminController {

    @Autowired
    IEmpresaService empresaService;

    @Autowired
    IRubroService rubroService;

    @Autowired
    ISoftwareService softwareService;

    @RequestMapping(value = "/empresa/agregar", method = RequestMethod.GET)
    private String agregar(Model model){
        Empresa empresa = new Empresa();
        model.addAttribute("empresa",empresa);
        model.addAttribute("rubros",rubroService.list());
        model.addAttribute("tecnologias",softwareService.list());
        return "index";
    }

    @RequestMapping(value = "/empresa/agregar", method = RequestMethod.POST)
    private String agregar(@ModelAttribute @Valid Empresa obj){
        boolean flag = false;
        flag = empresaService.create(obj);
        if(flag){
            System.out.println("Creado");
        }else{
            System.out.println("Salio mal");
        }
        return "redirect:/empresa/listado";
    }


    @RequestMapping(value = "/empresa/listado", method = RequestMethod.GET)
    private String listado(Model model){
        model.addAttribute("empresas",empresaService.list());
        return "lista_empresa";
    }


    @RequestMapping(value = "/empresa/busca", method = RequestMethod.GET)
    private String buscar(){
        return "busqueda";
    }

    @RequestMapping(value = "/empresa/buscar", method = RequestMethod.GET)
    private String buscar(@RequestParam("search") String idSearch, RedirectAttributes redirectAttributes, Model model){
        Optional<Empresa> obj = empresaService.searchById(Integer.parseInt(idSearch));

        if(obj.isPresent()){
            List<Empresa> lista = new ArrayList<Empresa>();
            lista.add(obj.get());
            model.addAttribute("empresas",lista);
            return "lista_empresa";
        }else{
            return "redirect:/empresa/buscar";
        }
    }


}
