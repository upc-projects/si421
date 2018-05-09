package service.implement;

import java.util.List;

import dao.IEditorialDAO;
import dao.implement.EditorialDAO;
import entities.Editorial;
import service.IEditorialService;

public class EditorialService implements IEditorialService{
	
	IEditorialDAO dao = null;
	
	public EditorialService() {
		dao = new EditorialDAO();
	}
	
	@Override
	public List<Editorial> listar() {
		return dao.listar();
	}

	@Override
	public boolean crearEditorial(Editorial l) {
		return dao.crearEditorial(l);
	}

	@Override
	public boolean eliminarEditorial(int id) {
		return dao.eliminarEditorial(id);
	}

}
