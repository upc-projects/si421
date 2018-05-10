package service;

import java.util.List;

import entities.Libro;

public interface ILibroService {
	
	public List<Libro> listar();
	public boolean crearLibro(Libro l);
	public boolean eliminarLibro(int id);

}
