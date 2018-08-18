package service.impl;

import java.util.List;

import dao.IGeneroDAO;
import dao.impl.GeneroDAOImpl;
import entities.Genero;
import service.IGeneroService;

public class GeneroServiceImpl implements IGeneroService {
	IGeneroDAO dao = null;
	
	public GeneroServiceImpl() {
		dao = new GeneroDAOImpl();
	}

	public List<Genero> listar() {
		
		return dao.listar();
	}

	@Override
	public boolean registrar(Genero obj) {
		// TODO Auto-generated method stub
		
		return dao.registrar(obj);
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}

}
