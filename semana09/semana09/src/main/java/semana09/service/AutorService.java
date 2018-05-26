package semana09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semana09.entidad.Autor;
import semana09.repositorio.IAutorRepositorio;

@Service
public class AutorService implements IAutorService {
	
	@Autowired
	IAutorRepositorio repositorio;
	
	@Override
	public List<Autor> listado() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public boolean agregar(Autor obj) {
		// TODO Auto-generated method stub
		Autor nuevo = repositorio.save(obj);
		if(nuevo == null) {
			return false;
		}else {
			return true;
		}		
	}

	@Override
	public boolean eliminar(int id) {
		boolean flag = false;
		try {
			repositorio.deleteById(id);
			flag = true;
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Autor buscarPorId(int id) {
		Autor autorObj = null;
		try {
			autorObj = repositorio.getOne(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return autorObj;
	}

	@Override
	public boolean actualizar(Autor obj) {
		Autor nuevo = repositorio.save(obj);
		if(nuevo == null) {
			return false;
		}else {
			return true;
		}		
	}
	
	

}
