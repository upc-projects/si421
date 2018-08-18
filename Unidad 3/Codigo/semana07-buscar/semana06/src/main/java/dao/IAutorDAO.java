package dao;

import java.util.List;

import entities.Autor;

public interface IAutorDAO {
	public List<Autor> listar();
	public boolean registrar(Autor obj);
	public boolean eliminar(int id);
}
