package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import dao.Conexion;
import dao.ILibroDAO;
import entidades.Libro;

public class LibroDAO implements ILibroDAO{
	@Override
	public List<Libro> listar() {
		
		return null;
	}
	
	@Override
	public boolean actualizar(Libro objLibro) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public boolean crear(Libro libro) {
		boolean flag = false;
		try{
			Connection con = Conexion.conectar();
			String sql = "insert into Libros"
					+ " (titulo, precio,descripcion,isbn,genero_id,editorial_id)"
					+ " values(?,?,?,?,?,?)";
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setString(1, libro.getTitulo());
			smt.setDouble(2, libro.getPrecio());
			smt.setString(3, libro.getDescripcion());
			smt.setString(4, libro.getIsbn());
			smt.setInt(5, libro.getGenero_id());
			smt.setInt(6, libro.getEditorial_id());
			
			int filas = smt.executeUpdate();
			Conexion.cerrar(con);
			
			if (filas == 1) {
				flag = true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	@Override
	public Libro buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
