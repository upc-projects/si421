package service.implement;

import java.util.List;

import dao.ILibroDAO;
import dao.implement.LibroDAO;
import entities.Libro;
import service.ILibroService;

public class LibroService implements ILibroService{
	
	ILibroDAO dao = null;
	
	public LibroService() {
		dao = new LibroDAO();
	}
	
	@Override
	public List<Libro> listar() {
		return dao.listar();
	}

	@Override
	public boolean crearLibro(Libro l) {
		return dao.crearLibro(l);
	}

	@Override
	public boolean eliminarLibro(int id) {
		return dao.eliminarLibro(id);
	}

}
