package source.open.pc02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.open.pc02.entidades.Alumno;
import source.open.pc02.repositorios.AlumnoRepositorio;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepositorio repositorio;
	
	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

}
