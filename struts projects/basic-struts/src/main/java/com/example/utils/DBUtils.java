package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static final String URL = "jdbc:mysql://localhost:3306/health_app";
	private static final String USER_NAME ="root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
	}
	
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
