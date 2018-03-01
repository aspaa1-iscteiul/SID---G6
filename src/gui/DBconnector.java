package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {
	private Connection 	con;
	private String dbUrl = "jdbc:sqlanywhere:";

	public void connect(String user, String password) throws SQLException{

		try {	
			con = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Login efectuado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Não foi possível efectuar login");
		}
	}
}
