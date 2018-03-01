package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableResearchers {
	
	private Connection conn;
	ResultSet rset;
	private PreparedStatement selectAll;
	
	public TableResearchers(Connection conn){
		super();
		this.conn = conn;
		try {
			prepareStatements();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void prepareStatements() throws SQLException{
		selectAll = conn.prepareStatement("SELECT * FROM Researcher");
	}

	public void selectAll() throws SQLException{
		rset = null;	
		try {
			rset = selectAll.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		System.out.println();
		
		while (rset.next()) {
	        System.out.println("Email: " + rset.getString(1) + ", Nome: " + rset.getString(2));
	        }
	}
}
