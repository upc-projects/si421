package source.open.semana14.services;

import java.util.List;

import org.springframework.stereotype.Service;

import source.open.semana14.entidades.Sede;

@Service
public interface SedeService {

	public List<Sede> listado();
	
	
}
