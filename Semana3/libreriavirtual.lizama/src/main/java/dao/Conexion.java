package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static Connection conectar() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String uri = "jdbc:mysql://localhost:3306/LibreriaVirtual";
			con = DriverManager.getConnection(uri, "root", "root");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void cerrar(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
