package service.implement;

import java.util.List;

import dao.IAutorDAO;
import dao.implement.AutorDAO;
import entities.Autor;
import service.IAutorService;

public class AutorService implements IAutorService{
	
	IAutorDAO autor = null;
	
	public AutorService() {
		autor = new AutorDAO();
	}
	
	@Override
	public List<Autor> listar() {
		return autor.listar();
	}

	@Override
	public boolean crearAutor(Autor l) {
		return autor.crearAutor(l);
	}

	@Override
	public boolean eliminarAutor(int id) {
		return autor.eliminarAutor(id);
	}

}
