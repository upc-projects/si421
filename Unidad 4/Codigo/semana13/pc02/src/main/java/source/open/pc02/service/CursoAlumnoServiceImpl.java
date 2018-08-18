package source.open.pc02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.open.pc02.entidades.CursoAlumno;
import source.open.pc02.repositorios.CursoAlumnoRepositorio;

@Service
public class CursoAlumnoServiceImpl 
				implements CursoAlumnoService {
	@Autowired
	CursoAlumnoRepositorio repositorio;
	@Override
	public List<CursoAlumno> listar() {
		return repositorio.findAll();
	}

	@Override
	public boolean guardar(CursoAlumno obj) {
		boolean flag = false;
		try {
			repositorio.save(obj);
			flag=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
}
