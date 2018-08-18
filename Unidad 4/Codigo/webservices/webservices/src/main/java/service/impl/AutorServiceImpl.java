package service.impl;

import java.util.List;

import dao.IAutorDAO;
import dao.impl.AutorDAOImpl;
import entities.Autor;
import service.IAutorService;

public class AutorServiceImpl implements IAutorService {
	IAutorDAO dao = null;
	
	public AutorServiceImpl() {
		dao = new AutorDAOImpl();
	}

	public List<Autor> listar() {
		
		return dao.listar();
	}

	@Override
	public boolean registrar(Autor obj) {
		// TODO Auto-generated method stub
		
		return dao.registrar(obj);
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}

}
