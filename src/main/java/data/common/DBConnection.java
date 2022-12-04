package data.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A class to manage the MySQL connection (general methods and configuration).
 * @author Antonio Diaz Perez
 * @version 14/10/2022
 */

public class DBConnection {
	
	protected Connection connection = null;
	
	public Connection getConnection() throws FileNotFoundException, IOException{
		
		// Open the properties file
		Properties propiedades = new Properties();
		propiedades.load(new FileReader("./src/main/java/data/common/config.properties"));

		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(propiedades.getProperty("URL"), propiedades.getProperty("User"), propiedades.getProperty("Password"));
			System.out.println("Database connection successfully opened!");
		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;
	}


	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				System.out.println("Database connection successfully closed!");
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
	
}
