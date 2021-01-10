package com.bank.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSqlConnection {
	private static Connection connection;
	
	private PostgresSqlConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");	
		String url="jdbc:postgresql://localhost:5432/postgres";
		String username="postgres";
		String password="@Advent123";
		connection=DriverManager.getConnection(url, username, password);
		return connection;
	}
}
