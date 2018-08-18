package source.open.pc02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import source.open.pc02.entidades.Curso;

@Service
public interface CursoService {
	
	public List<Curso> listar();
}
