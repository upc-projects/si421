package semana09.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semana09.entidad.Autor;
import semana09.repositorio.IAutorRepositorio;
import semana09.repositorio.IRolRepositorio;

@Service
public class RolService implements IRolService {
	
	@Autowired
	IRolRepositorio repositorio;
	
}
