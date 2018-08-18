package source.open.semana14.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.open.semana14.entidades.Sede;
import source.open.semana14.repositorios.SedeRepositorio;

@Service
public class SedeServiceImpl implements SedeService {
	@Autowired
	SedeRepositorio repo;
	
	@Override
	public List<Sede> listado() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
