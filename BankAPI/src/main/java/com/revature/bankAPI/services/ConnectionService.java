package com.revature.bankAPI.services;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionService {
private static Connection connection;
	
	public static Connection getConnection() {
		
		if(connection ==null) {
			try {
				FileInputStream fis = new FileInputStream("connection.properties");
				Properties prop = new Properties();
				prop.load(fis);
				
				connection = DriverManager.getConnection(prop.getProperty("url"), 
						prop.getProperty("username"), prop.getProperty("password"));
				//return connection;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	public static void closeConnection() {
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
