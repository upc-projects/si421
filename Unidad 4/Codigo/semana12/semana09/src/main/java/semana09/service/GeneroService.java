package semana09.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semana09.entidad.Genero;
import semana09.repositorio.IGeneroRepositorio;

@Service
public class GeneroService implements IGeneroService {
	
	@Autowired
	IGeneroRepositorio repositorio;
	
	@Override
	public List<Genero> listado() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public boolean agregar(Genero obj) {
		// TODO Auto-generated method stub
		Genero nuevo = repositorio.save(obj);
		if(nuevo == null) {
			return false;
		}else {
			return true;
		}		
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			repositorio.deleteById(id);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public Optional<Genero> buscarPorID(int id) {
		Optional<Genero> objGenero = null;
		try {
			//objGenero = repositorio.getOne(id);
			objGenero = repositorio.findById(id);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objGenero;
	}

	@Override
	public boolean actualizar(Genero obj) {
		boolean flag = false;
		try {
			repositorio.save(obj);
			flag = true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}

}
