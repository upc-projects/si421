package service.implement;

import java.util.List;

import dao.IGeneroDAO;
import dao.implement.GeneroDAO;
import entities.Genero;
import service.IGeneroService;

public class GeneroService implements IGeneroService{
	
	IGeneroDAO dao = null;
	
	public GeneroService() {
		dao = new GeneroDAO();
	}
	
	@Override
	public List<Genero> listar() {
		return dao.listar();
	}

	@Override
	public boolean crearGenero(Genero l) {
		return dao.crearGenero(l);
	}

	@Override
	public boolean eliminarGenero(int id) {
		return dao.eliminarGenero(id);
	}

}
