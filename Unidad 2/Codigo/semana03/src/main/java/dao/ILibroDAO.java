package dao;

import java.util.List;

import entidades.Libro;

public interface ILibroDAO {
	
	public boolean crear(Libro objLibro);

	public List<Libro> listar();
	
	public boolean eliminar(int id);
	
	public Libro buscarPorID(int id);
	
	public boolean actualizar(Libro objLibro);
}
