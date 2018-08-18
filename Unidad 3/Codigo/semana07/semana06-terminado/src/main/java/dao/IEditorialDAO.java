package dao;

import java.util.List;

import entities.Autor;
import entities.Editorial;

public interface IEditorialDAO {

	public List<Editorial> listar();
	
	public boolean agregar(Editorial obj);
	
	public boolean eliminar(int id);
}
