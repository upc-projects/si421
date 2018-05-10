package dao;

import java.util.List;

import entities.Autor;

public interface IAutorDAO {

	public List<Autor> listar();
	public boolean crearAutor(Autor l);
	public boolean eliminarAutor(int id);
}
