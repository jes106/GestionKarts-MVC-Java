package data.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import data.common.*;

/**
 * A class to manage the MySQL connection (general methods and configuration).
 * @author Antonio Diaz Perez
 * @version 14/10/2022
 */
public class DBConnection {
	
	protected Connection connection = null;

	public DBConnection() {

		
	}
	
	
	/***
	 * Function to connect to the database
	 * @return The pipe with the database
	 * @throws FileNotFoundException If the file with the properties is not found
	 * @throws IOException If there are any problems with the I/O
	 */
	public Connection getConnection() throws FileNotFoundException, IOException{
		
	    
	    
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i02dipea", "i02dipea", "BDPW");
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

	/***
	 * Function to close the conection with the database
	 */
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
