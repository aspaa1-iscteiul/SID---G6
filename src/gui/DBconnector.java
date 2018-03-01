package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {
	private Connection 	con;
	private String dbUrl = "jdbc:sqlanywhere:";

	public void connect(String user, String password) throws SQLException{
		con = DriverManager.getConnection(dbUrl, user, password);
		System.out.println("Login efectuado com sucesso!");
	}
	
	public static void main(String[] args) {
		try {
			new DBconnector().connect("dba", "sql");
			System.out.println("Resultou");
		} catch (SQLException e) {
			System.out.println("falhou");
		}
	}
}
