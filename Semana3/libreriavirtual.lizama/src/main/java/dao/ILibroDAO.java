package dao;

import java.util.List;

import entidades.Libro;

public interface ILibroDAO {
	public boolean crear(Libro libro);
	public List<Libro> listar();
	public boolean eliminar(int id);
	public Libro buscarPorId(int id);
	public boolean actualizar(Libro objLibro);
}
