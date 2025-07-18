package com.tnsif.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_ResultSet {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tnsif_jdbc", "root", "root");

		if (connection != null) {
			System.out.println("Connection Sccuesfully.........");

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tnsif;");

			 ResultSet rSet =  preparedStatement.executeQuery();
			 
			 
			 System.out.println("Id \t\t Name");
			while(rSet.next()) {
				System.out.println(rSet.getInt(1)+" \t\t "+rSet.getString(2));
	
			}
			
		} else {
			System.err.println("Connection Failed.........");
		}
	}

}
