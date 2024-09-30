package com.industryaudit.industryaudit.repositories;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public final class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/industryaudit";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static Connection conn = null;

	protected static Connection getCurrentConnection() throws SQLException {

		if (conn == null)
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			

		return conn;

	}

	protected static Connection getNewConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
