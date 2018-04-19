package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection conectar() {
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String uri = "jdbc:mysql://localhost:3306/BDVentas";
			c = DriverManager.getConnection(uri, "root", "root");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return c;
	}
	
	public static void cerrar(Connection c) {
		try {
			c.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
