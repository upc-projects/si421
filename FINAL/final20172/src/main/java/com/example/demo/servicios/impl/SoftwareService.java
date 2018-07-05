package com.example.demo.servicios.impl;

import com.example.demo.entidades.Software;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositorio.ISoftwareRepository;
import com.example.demo.servicios.ISoftwareService;

import java.util.List;

@Service
public class SoftwareService implements ISoftwareService {

    @Autowired
    ISoftwareRepository repositorio;

    @Override
    public boolean create(Software software) {
        Software obj = repositorio.save(software);
        if(obj != null){
            System.out.println("Exito software");
            return true;
        }else {
            System.out.println("No funciona");
            return false;
        }
    }

    @Override
    public List<Software> list() {
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
    public boolean update(Software software) {
        return false;
    }
}
