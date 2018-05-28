package semana09.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semana09.entidad.Editorial;
import semana09.repositorio.IEditorialRepositorio;

@Service
public class EditorialService implements IEditorialService {
	
	@Autowired
	IEditorialRepositorio repositorio;
	
	@Override
	public List<Editorial> listado() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public boolean agregar(Editorial obj) {
		// TODO Auto-generated method stub
		Editorial nuevo = repositorio.save(obj);
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
	public Optional<Editorial> buscarPorID(int id) {
		Optional<Editorial> objEditorial = null;
		try {
			//objEditorial = repositorio.getOne(id);
			objEditorial = repositorio.findById(id);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return objEditorial;
	}

	@Override
	public boolean actualizar(Editorial obj) {
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
