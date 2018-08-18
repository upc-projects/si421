package source.open.pc02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.open.pc02.entidades.Sede;
import source.open.pc02.repositorios.SedeRepositorio;

@Service
public class SedeServiceImpl implements SedeService {
	@Autowired
	SedeRepositorio repositorio;
	
	@Override
	public List<Sede> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

}
