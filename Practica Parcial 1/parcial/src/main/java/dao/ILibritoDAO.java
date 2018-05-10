package dao;

import java.util.List;

import entities.Librito;

public interface ILibritoDAO {
	
	public List<Librito> listar();
	public boolean crearLibrito(Librito l);
	public boolean eliminarLibrito(int id);
	public Librito listarISBN(String isbn);
	
	
}
