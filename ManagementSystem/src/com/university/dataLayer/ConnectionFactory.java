package com.university.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	static Statement statement = null;
	PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;

	public static Connection getConnection() throws SQLException {

		String dbURL = "jdbc:mysql://127.0.0.1:3306/university_db?useSSL=false";
		String user = "root";
		String pass = "12345678";

		return DriverManager.getConnection(dbURL, user, pass);

	}
}
