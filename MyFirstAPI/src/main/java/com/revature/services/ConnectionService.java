package com.revature.services;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// A ConnectionService provides a centralized place to store your Connection object.
// Now whenever one is needed, you can simply call ConnectionService.getConnection() and forget about it.
// It is a singleton. A singleton only has one instance (or zero) and carries a centralized place for data and functionality.
public class ConnectionService {
	private static Connection connection;
	/*public static void main(String[] args) {
		Connection connect=ConnectionService.getConnection();
		ConnectionService.closeConnection();
	}*/
	public static Connection getConnection() {
		
		if(connection ==null) {
			try {
				File testFile = new File(".");
				/*System.out.println(testFile.getAbsolutePath());
				System.out.println(testFile.isFile());
				System.out.println(testFile.canRead());
				//System.out.println(testFile==null);
				/*File file = new File("connection.properties");
				System.out.println(file.exists());
				System.out.println(file.isFile());
				System.out.println(file.canRead());*/
				/*FileInputStream fis = new FileInputStream("connection.properties");
				Properties prop = new Properties();
				prop.load(fis);*/
				Class.forName("org.postgresql.Driver");
				String url="jdbc:postgresql://lallah.db.elephantsql.com:5432/cwnjniff";
				String username="cwnjniff";
				String password="hmwiSbLZy0eX_tvia3Fdp8wwigPMSGbb";
				connection = DriverManager.getConnection(url, username, password);
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
