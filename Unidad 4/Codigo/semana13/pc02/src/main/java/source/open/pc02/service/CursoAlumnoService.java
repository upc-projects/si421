package source.open.pc02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import source.open.pc02.entidades.Curso;
import source.open.pc02.entidades.CursoAlumno;

@Service
public interface CursoAlumnoService {

	public List<CursoAlumno> listar();
	
	public boolean guardar(CursoAlumno obj);
}
