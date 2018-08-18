package semana09.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semana09.entidad.Libro;
import semana09.repositorio.ILibroRepositorio;

@Service
public class LibroService implements ILibroService {
	
	@Autowired
	ILibroRepositorio repositorio;
	
	@Override
	public List<Libro> listado() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public boolean agregar(Libro obj) {
		// TODO Auto-generated method stub
		Libro nuevo = repositorio.save(obj);
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
	public Optional<Libro> buscarPorID(int id) {
		Optional<Libro> objLibro = null;
		try {
			//objLibro = repositorio.getOne(id);
			objLibro = repositorio.findById(id);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objLibro;
	}

	@Override
	public boolean actualizar(Libro obj) {
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
