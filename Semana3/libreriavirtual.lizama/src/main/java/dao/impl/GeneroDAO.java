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

public class GeneroDAO implements IGeneroDAO{
	@Override
	public List<Genero> listar() {
		List<Genero> generos = new ArrayList<Genero>();
		try {
			Connection con = Conexion.conectar();
			Statement smt = con.createStatement();
			ResultSet set = smt.executeQuery("select * from Genero");
			Genero objEdit = null;
			while(set.next()) {
				objEdit = new Genero();
				objEdit.setId(set.getInt("idGenero"));
				objEdit.setNombre(set.getString("nombreGenero"));
				
				generos.add(objEdit);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return generos;
	}
}
