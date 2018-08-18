package service;

import java.util.List;

import entities.Genero;

public interface IGeneroService {
	
	public List<Genero> listar();
	
	public boolean registrar(Genero obj);
	
	public boolean eliminar(int id);
}
