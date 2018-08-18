package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.Conexion;
import dao.IEditorialDAO;
import entidades.Editorial;

public class EditorialDAO implements IEditorialDAO {

	@Override
	public List<Editorial> listar() {
		List<Editorial> editoriales = new ArrayList<Editorial>();
		try {
			Connection conex = Conexion.conectar();
			Statement stmt = conex.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from editoriales");
			Editorial objEditorial = null;
			while(rs.next()) {
				objEditorial = new Editorial();
				objEditorial.setId(rs.getInt("id"));
				objEditorial.setNombre(rs.getString("nombre"));
				
				editoriales.add(objEditorial);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return editoriales;
	}

}
