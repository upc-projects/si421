package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.Conexion;
import dao.IGeneroDAO;
import entidades.Editorial;
import entidades.Genero;

public class GeneroDAO implements IGeneroDAO {

	@Override
	public List<Genero> listar() {
		List<Genero> generos = new ArrayList<Genero>();
		try {
			Connection conex = Conexion.conectar();
			Statement stmt = conex.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from generos");
			Genero objGenero = null;
			while(rs.next()) {
				objGenero = new Genero();
				objGenero.setId(rs.getInt("id"));
				objGenero.setNombre(rs.getString("nombre"));
				
				generos.add(objGenero);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return generos;
	}

}
