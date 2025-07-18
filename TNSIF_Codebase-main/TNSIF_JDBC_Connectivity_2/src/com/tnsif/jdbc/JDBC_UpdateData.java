package com.tnsif.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_UpdateData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tnsif_jdbc", "root", "root");

		if (connection != null) {
			System.out.println("Connection Sccuesfully.........");
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tnsif SET name= 'Mahesh 'WHERE id = 2;");

			preparedStatement.executeUpdate();
			System.out.println("Updated...........");
		} else {
			System.err.println("Connection Failed.........");
		}
	}


}
