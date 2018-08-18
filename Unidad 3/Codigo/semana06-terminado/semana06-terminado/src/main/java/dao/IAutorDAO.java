package dao;

import java.util.List;

import entities.Autor;

public interface IAutorDAO {

	public List<Autor> listar();
	
	public boolean agregar(Autor obj);
	
	public boolean eliminar(int id);
}
