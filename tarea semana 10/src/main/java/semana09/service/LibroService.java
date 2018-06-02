package semana09.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import semana09.entidad.Libro;
import semana09.repositorio.ILibroRepositorio;

@Service
public class LibroService implements ILibroService {
	
	static String FILE_ROUTE = "./src/main/resources/static/images/"; 
	
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

	@Override
	public void saveImage(MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(FILE_ROUTE + file.getOriginalFilename());
				Files.write(path, bytes);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void deleteImage(int id) {
		Libro obj = buscarPorID(id).get();
		try {
			Path path = Paths.get(obj.getImage());
			Files.delete(path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
