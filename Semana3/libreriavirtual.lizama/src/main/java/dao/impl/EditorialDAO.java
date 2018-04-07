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
			Connection con = Conexion.conectar();
			Statement smt = con.createStatement();
			ResultSet set = smt.executeQuery("select * from Editoriales");
			Editorial objEdit = null;
			while(set.next()) {
				objEdit = new Editorial();
				objEdit.setId(set.getInt("idEditorial"));
				objEdit.setNombre(set.getString("nombreEditorial"));
				
				editoriales.add(objEdit);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return editoriales;
	}
}
