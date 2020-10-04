package com.revature;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class App {
	public static void main(String[] args) {
		//template jdbc:postgresql://host_or_server_name:port/server_name
		Connection connection =null;
		
		
		try {
			//Might need this:
			//Class.forName("org.postresql.Driver");
			
			//The Connection objects represents our authenticated connection to our database
			//Its where Statement and PreparedStatement objects come from 
			FileInputStream fis = new FileInputStream("connection.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			connection = DriverManager.getConnection(prop.getProperty("url"), 
					prop.getProperty("username"), prop.getProperty("password"));
			//connection = DriverManager.getConnection(connectionString, username, password);
			regularStatement(connection);
			preparedStatement(connection);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//We should close our connection at the end.
				//connection.close
				//Could also be in finally block, would need to check if connection is null
				//And surround close with another try catch block.
		finally {
			if(connection!=null) {
				try{
					connection.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void regularStatement(Connection connection) throws SQLException{
		//Statement used to execute query, not store query
		//Statement object doesn't represent a statement
		//it's the vehicle for running statements
		Statement stmt = connection.createStatement();
		
		//just execute will say if execution is successful
		//Use Statement to execute a query, which will return a ResultSet
		//ResultSets contain the rows returned by the query
		ResultSet rs = stmt.executeQuery("SELECT * FROM residents;");
		
		//ResultSet has an internal iterator that starts at row above first row
		//We move it along by calling ResultSet.next()
		// If there is no next row, next() returns false.
		while (rs.next()) {
			// In order to get data out of the row, we can call a variety of get methods, such as
			// ResultSet.getString, and give either the column number or name as the parameter
			// to identify the column.
			System.out.println(rs.getString(2) + " " + rs.getString("last_name"));
		}
		
		
	}
	public static void preparedStatement(Connection connection) throws SQLException {
		//PreparedStatements are Statements that have question marks in them.
		//The ?s represent parameters, or variables that are then set after PreparedStatement is created.
		//The ?s can be anything
		PreparedStatement ps =connection.prepareStatement("SELECT * FROM residents where id = ?");
		// We use PreparedStatmenet.set<Type>(position, value) to set the particular value of a parameter
		// As with columns in ResultSet.gets, the first number is
		// position is the positionth question mark in the query.
		ps.setInt(1, 2);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("first_name")+ " "  + rs.getString("last_name"));
		}
	}
	
}
