package source.open.semana14.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.open.semana14.entidades.Cliente;
import source.open.semana14.repositorios.ClienteRepositorio;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteRepositorio repo;
	
	@Override
	public List<Cliente> listado() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
