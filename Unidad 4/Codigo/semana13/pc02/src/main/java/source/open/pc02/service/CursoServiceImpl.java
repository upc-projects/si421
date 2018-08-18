package source.open.pc02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.open.pc02.entidades.Curso;
import source.open.pc02.repositorios.CursoRepositorio;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoRepositorio repositorio;
	
	@Override
	public List<Curso> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

}
