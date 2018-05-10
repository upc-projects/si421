package service.implement;

import java.util.List;

import dao.ILibritoDAO;
import dao.implement.LibritoDAO;
import entities.Librito;
import service.ILibritoService;

public class LibritoService implements ILibritoService{
	
	ILibritoDAO librito = null;
	
	public LibritoService() {
		librito = new LibritoDAO();
	}

	@Override
	public List<Librito> listar() {
		return librito.listar();
	}

	@Override
	public boolean crearLibrito(Librito l) {
		return librito.crearLibrito(l);
	}

	@Override
	public boolean eliminarLibrito(int id) {
		return librito.eliminarLibrito(id);
	}

	@Override
	public Librito listarISBN(String isbn) {
		return librito.listarISBN(isbn);
	}
	
	

}
