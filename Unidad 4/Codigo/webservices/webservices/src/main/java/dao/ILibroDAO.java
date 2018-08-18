package dao;

import java.util.List;

import entities.Libro;

public interface ILibroDAO {
	public List<Libro> listar();
	public boolean registrar(Libro obj);
	public boolean eliminar(int id);
}
