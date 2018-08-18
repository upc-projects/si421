package source.open.pc02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import source.open.pc02.entidades.Alumno;

@Service
public interface AlumnoService {
	
	public List<Alumno> listar();
}
