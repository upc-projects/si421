package service;

import java.util.List;

import entities.Librito;

public interface ILibritoService {
	
	public List<Librito> listar();
	public boolean crearLibrito(Librito l);
	public boolean eliminarLibrito(int id);
	public Librito listarISBN(String isbn);

}
