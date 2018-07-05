package com.example.demo.servicios.impl;

import com.example.demo.entidades.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositorio.IEmpresaRepositorio;
import com.example.demo.servicios.IEmpresaService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements IEmpresaService {
    @Autowired
    IEmpresaRepositorio repositorio;


    @Override
    public boolean create(Empresa empresa) {
        Empresa obj = repositorio.save(empresa);
        if(obj != null){
            System.out.println("Exito");
            return true;
        }else {
            System.out.println("No funciona");
            return false;
        }
    }

    @Override
    public List<Empresa> list() {
        return repositorio.findAll();
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            repositorio.deleteById(id);
            flag = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean update(Empresa empresa) {
        return false;
    }

    @Override
    public Optional<Empresa> searchById(int id) {
        Optional<Empresa> emp = null;
        try {
            emp = repositorio.findById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return emp;
    }
}
