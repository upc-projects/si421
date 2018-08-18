package service.impl;

import java.util.List;

import dao.IEditorialDAO;
import dao.impl.EditorialDAOImpl;
import entities.Editorial;
import service.IEditorialService;

public class EditorialServiceImpl implements IEditorialService {
	IEditorialDAO dao = null;
	
	public EditorialServiceImpl() {
		dao = new EditorialDAOImpl();
	}

	public List<Editorial> listar() {
		
		return dao.listar();
	}

	@Override
	public boolean registrar(Editorial obj) {
		// TODO Auto-generated method stub
		
		return dao.registrar(obj);
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}

}
