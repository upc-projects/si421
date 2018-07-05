package com.example.demo.servicios.impl;

import com.example.demo.entidades.Rubro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositorio.IRubroRepositorio;
import com.example.demo.servicios.IRubroService;

import java.util.List;

@Service
public class RubroService implements IRubroService {

    @Autowired
    IRubroRepositorio repositorio;

    @Override
    public boolean create(Rubro rubro) {
        Rubro obj = repositorio.save(rubro);
        if(obj != null){
            System.out.println("Exito rubro");
            return true;
        }else {
            System.out.println("No funciona");
            return false;
        }
    }

    @Override
    public List<Rubro> list() {
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
    public boolean update(Rubro rubro) {
        return false;
    }
}
