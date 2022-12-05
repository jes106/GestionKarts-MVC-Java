package data.dao;

import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.ResultSet;

import business.UsuarioDTO;
import data.common.DBConnection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * This class manages the users
 * @author Juan José Trenado Zafra
 * @version 06/10/2022
 */
public class UsuarioDAO {
  /**
   * Constructor without parameters
   */
  public UsuarioDAO(){}

  /**
   * makes a new user
   * @throws SQLException 
   * @throws IOException 
   * @throws FileNotFoundException 
   */
  public static boolean altaUsuario(UsuarioDTO user) throws SQLException, FileNotFoundException, IOException{
    if(comprobarEsxistenciaUsuario(user.getEmail()) == false) {
    	
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
	    
	    Properties cons = new Properties();
	    cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
	    
	    PreparedStatement ps = connection.prepareStatement(cons.getProperty("InsertUser"));
	    ps.setString(1, user.getNameSurname());
	    ps.setTimestamp(2, user.getBirthDate());
	    ps.setTimestamp(3,  user.getInscriptionDate());
	    ps.setString(4, user.getEmail());
	    ps.setString(5, user.getPassword());
	    ps.setString(6, user.getRol());
	    
	    // Lo alamcenamos en la base de datos
	    ps.executeUpdate();
	    
	    dbConnection.closeConnection();
	    return true;
    }
    else {
    	return false;
    }

  }

  /**
   * probes by email that the user is in the system
   * @return true if the user exists
   * @throws SQLException 
   */
  public static boolean comprobarEsxistenciaUsuario(String email){
	  	boolean ret = false;
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			
			Properties cons = new Properties();
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		
			Statement stmt = null;
			try {
				stmt = connection.createStatement();
			} catch (SQLException e) { e.printStackTrace(); }
			
			ResultSet rs = null;
			
			try {
				rs = (ResultSet) stmt.executeQuery(cons.getProperty("CheckUser") + "'" + email + "'");
			} catch (SQLException e) { e.printStackTrace(); }
			
			try {
				if(rs.next() == true) { ret = true; }
			} catch (SQLException e) { e.printStackTrace();	}
				
				if(stmt != null) { 
					try {
						stmt.close();
					} catch (SQLException e) { e.printStackTrace(); } 
				}
				
				dbConnection.closeConnection();
			
		} catch (FileNotFoundException e) {	e.printStackTrace(); } 
		  catch (IOException e) { e.printStackTrace(); }
		return ret;
  }
  
  
  public static boolean comprobarPassword(String email, String password) throws SQLException{
	  boolean ret = false;
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			
			Properties cons = new Properties();
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		
			Statement stmt = null;
			try {
				stmt = connection.createStatement();
			} catch (SQLException e) { e.printStackTrace(); }
			
			ResultSet rs = null;
			
			try {
				rs = (ResultSet) stmt.executeQuery(cons.getProperty("CheckPassword") + "'" + email + "'");
			} catch (SQLException e) { e.printStackTrace(); }
			
			rs.next();
//			System.out.println("contraseña: " + rs.getString(1));
			if(rs.getString(1).contentEquals(password)) { ret = true; }
				
				if(stmt != null) { 
					try {
						stmt.close();
					} catch (SQLException e) { e.printStackTrace(); } 
				}
				
				dbConnection.closeConnection();
			
		} catch (FileNotFoundException e) {	e.printStackTrace(); } 
		  catch (IOException e) { e.printStackTrace(); }
		return ret;
}
  
  public static UsuarioDTO getUser(String email) {
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
		
	  Properties cons = new Properties();
	  
	  try {
		  cons.load(new FileReader("./src/main/java/Consultas.properties"));
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  PreparedStatement ps = null;
	  
	  try {
		  ps = connection.prepareStatement(cons.getProperty("GetUser"));
		  ps.setString(1, email);
	  } catch (SQLException e) { e.printStackTrace(); }
	  	  
	  ResultSet rs = null;
	  
	  try {
		  rs = (ResultSet) ps.executeQuery();
		  rs.next();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  try {
		UsuarioDTO user = new UsuarioDTO(rs.getString("Name"), rs.getTimestamp("BirthDay"), rs.getString("Email"), rs.getString("Rol"));
		user.setInscription(rs.getTimestamp("InscriptionD"));
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  return null;
  }
    
  public static void modBirhtUser(UsuarioDTO user) {
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateBirthUser"));
			ps.setTimestamp(1, user.getBirthDate());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
  }
  
  public static void modNameUser(UsuarioDTO user) {
	  	DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateNameUser"));
			ps.setString(1, user.getNameSurname());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
  }
  
  public static void modRolUser(UsuarioDTO user) {
	  	DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateRolUser"));
			ps.setString(1, user.getRol());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
  }

  public static void modPassUser(UsuarioDTO user) {
	  	DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdatePassUser"));
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
}
  
  /**
   * print the list of users
 * @throws SQLException 
 * @throws IOException 
 * @throws FileNotFoundException 
   */
  public static ArrayList<String> listarUsuarios(){
	  	ArrayList<String> users = new ArrayList<String>();
	  
	  	DBConnection dbConnection = new DBConnection();
	  	Connection connection = null;
	  	
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		Properties cons = new Properties();
	  
		try {
			cons.load(new FileReader("./src/main/java/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	  
		Statement stmt = null;
		
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) { e.printStackTrace(); }
		
		ResultSet rs = null;
	
		try {
			rs = (ResultSet) stmt.executeQuery(cons.getProperty("InfoAllUsers"));
		} catch (SQLException e) { e.printStackTrace(); }
	  
		try {
			while(rs.next()) {
				UsuarioDTO usu = null;
				
				try {
					usu = new UsuarioDTO(rs.getString("Name"), rs.getTimestamp("BirthDay"), rs.getString("Email"), rs.getString("Rol"));
					usu.setInscription(rs.getTimestamp("InscriptionD"));
				} catch (SQLException e) { e.printStackTrace(); }

			  users.add(usu.toString());
			}
		} catch (SQLException e) { e.printStackTrace(); }
	  dbConnection.closeConnection();
	  return users;
  }

  
  
  
  /**
   * Function to calculate the seniority of a client
   * @return the seniority of the user
   */

   @SuppressWarnings("deprecation")
public static int calcularAntiguedad(String mail){
	   
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
		
	  Properties cons = new Properties();
	  
	  try {
		  cons.load(new FileReader("./src/main/java/Consultas.properties"));
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  PreparedStatement ps = null;
	  
	  try {
		  ps = connection.prepareStatement(cons.getProperty("SeniorityUser"));
		  ps.setString(1, mail);
	  } catch (SQLException e) { e.printStackTrace(); }

	  ResultSet rs;
	  
	  try {
		  rs = (ResultSet) ps.executeQuery();
		  while(rs.next()) {
			  int diferencia = (new Date(new java.util.Date().getTime()).getYear() + 1900) - ((rs.getDate("InscriptionD")).getYear() + 1900);
			  if( (rs.getDate("InscriptionD")).getMonth() > new Date(new java.util.Date().getTime()).getMonth() ) {
				  diferencia--;
			  }
			  
			  return Math.abs(diferencia);
		  }
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  dbConnection.closeConnection();
	  
	  return -1;
   }
}