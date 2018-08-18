package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import dao.Conexion;
import dao.ILibroDAO;
import entidades.Libro;

public class LibroDAO implements ILibroDAO {

	@Override
	public boolean crear(Libro objLibro) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Connection conex = Conexion.conectar();
			
			String sql = "insert into libros"
			+ " (titulo, precio, isbn, descripcion, genero_id, editorial_id)"
			+ " values(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conex.prepareStatement(sql);
			pstmt.setString(1, objLibro.getTitulo());
			pstmt.setDouble(2, objLibro.getPrecio());
			pstmt.setString(3, objLibro.getIsbn());
			pstmt.setString(4, objLibro.getDescripcion());
			pstmt.setInt(5, objLibro.getGeneroID());
			pstmt.setInt(6, objLibro.getEditorialID());
			
 			int filas =	pstmt.executeUpdate();
 			Conexion.cerrar(conex);
 			
 			if(filas == 1) {
 				flag = true;
 			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public List<Libro> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Libro buscarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Libro objLibro) {
		// TODO Auto-generated method stub
		return false;
	}

}
