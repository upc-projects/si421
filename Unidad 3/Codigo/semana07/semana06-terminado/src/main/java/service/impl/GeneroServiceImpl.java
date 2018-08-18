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

	@Override
	public List<Genero> listar() {
		
		return dao.listar();
	}

	@Override
	public boolean agregar(Genero obj) {
		// TODO Auto-generated method stub
		
		return dao.agregar(obj);
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub

		return dao.eliminar(id);
	}

}
