package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {
	private Connection 	con;
//	private String dbfile = "C:\\Users\\tosh\\Documents\\ISCTE\\3º Ano 2017-18 (Projetos)"
//			+ "\\2º Semestre\\SID - Sistemas de Informação Distribuídos Agregada\\DB\\Culturas.db"; 
	private String dbfile = "bd\\Culturas.db"; 
	private String dbUrl = "jdbc:sqlanywhere:Tds:localhost:2638?START=dbeng12;DBF=" + dbfile;

	public void connect(String user, String password) throws SQLException{
		con = DriverManager.getConnection(dbUrl, user, password);
		System.out.println("Login efectuado com sucesso!");
		new TableResearchers(con).selectAll();
	}
	
}
