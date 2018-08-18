package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static Connection conectar() {
		Connection conex = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/libreriavirtual";
			conex = DriverManager.getConnection(url, "root", "root");
						
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return conex;
	}
	
	public static void cerrar(Connection conex) {
		try {
			conex.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
