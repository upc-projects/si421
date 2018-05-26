package semana09.service;

import java.util.List;

import org.springframework.stereotype.Service;

import semana09.entidad.Autor;

@Service
public interface IAutorService {

	public List<Autor> listado();
	
	public boolean agregar(Autor obj);

	public boolean eliminar(int id);
	
	public Autor buscarPorId(int id);
	
	public boolean actualizar(Autor obj);
	
}
