package com.revature.bankAPI.services;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionService {
	private static Connection connection;

	public static Connection getConnection() {

		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				//File file = new File("");
				String absPath = "\"C:\\Users\\pswov\\OneDrive\\Documents\\RevatureFolder\\Swovick_code\\BankAPIWebStretch"
						+ "\\src\\main\\java\\com\\revature\\bankAPI\\services\\connection.properties\"";
				FileInputStream fis = new FileInputStream(absPath);
				Properties prop = new Properties();
				prop.load(fis);

				connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
						prop.getProperty("password"));
				// return connection;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
