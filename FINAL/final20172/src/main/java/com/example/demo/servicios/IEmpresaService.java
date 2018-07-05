package com.example.demo.servicios;

import com.example.demo.entidades.Empresa;

import java.util.Optional;

public interface IEmpresaService extends IGenericService<Empresa> {
    Optional<Empresa> searchById(int id);
}
