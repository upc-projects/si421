package service;

import java.util.List;

import entities.Editorial;

public interface IEditorialService {
	
	public List<Editorial> listar();
	
	public boolean registrar(Editorial obj);
	
	public boolean eliminar(int id);
}
