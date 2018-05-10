package service;

import java.util.List;

import entities.Profesor;

public interface IProfesorService {
	public List<Profesor> listar();
	public boolean  crearProfe(Profesor p);
	public boolean eliminarProfe(int id);
	public Profesor buscarCodigo(String cod);
}
