package com.example.demo.repositorio;

import com.example.demo.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmpresaRepositorio extends JpaRepository<Empresa,Integer> {
}
