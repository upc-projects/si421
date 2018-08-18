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

	@Override
	public List<Editorial> listar() {
		
		return dao.listar();
	}

	@Override
	public boolean agregar(Editorial obj) {
		// TODO Auto-generated method stub
		
		return dao.agregar(obj);
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub

		return dao.eliminar(id);
	}

}
