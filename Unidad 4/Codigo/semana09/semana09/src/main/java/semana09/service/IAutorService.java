package semana09.service;

import java.util.List;

import org.springframework.stereotype.Service;

import semana09.entidad.Autor;

@Service
public interface IAutorService {

	public List<Autor> listado();
	
	public boolean agregar(Autor obj);
	
}
