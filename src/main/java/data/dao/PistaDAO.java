package data.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.ResultSet;

import business.PistaDTO;
import data.common.*;
import data.common.Dificultad;
/**
 * This class manages the pista class
 * @author Juan José Trenado Zafra
 * @version 06/10/2022
 */
public class PistaDAO {
  /**
   * Constructor without parameters
   */
  public PistaDAO(){
  }

  /**
   * creates a pista
 * @throws IOException 
 * @throws SQLException 
 * @throws FileNotFoundException 
   */
  public static void crearPista(PistaDTO track){
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  Properties cons = new Properties();
	  
	  try {
		  cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  PreparedStatement ps = null;
	  
	  try {
		  ps = connection.prepareStatement(cons.getProperty("InsertTrack"));
		  ps.setString(1, track.getNombrePista());
		  ps.setBoolean(2, track.getEstadoPista());
		  ps.setString(3, track.getDificultad().toString());
		  ps.setInt(4, track.getMaxKarts());
		  ps.executeUpdate();
	  } catch (SQLException e1) { e1.printStackTrace(); }

	  dbConnection.closeConnection();
  }

  /**
   * Check a track
   */
  public static boolean comprobarExistenciaPista(String name){
	  boolean ret = false;
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  Properties cons = new Properties();
	  
	  try {
		  cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  Statement stmt = null;
	  
	  try {
		  stmt = connection.createStatement();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  ResultSet rs = null;
	  
	  try {
		  rs = (ResultSet) stmt.executeQuery(cons.getProperty("CheckTrack") + "'" + name + "'");
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  try {
		  if(rs.next() == true) {
			  	ret = true;
		  }
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  if(stmt != null) { 
		  try {
			  stmt.close();
		  } catch (SQLException e) { e.printStackTrace(); } 
	  }
			
	  dbConnection.closeConnection();
		
	  return ret;
}

  /**
   * asociates an avaliable kart to a pista
   * @return true if the kart can be asociated
 * @throws IOException 
 * @throws FileNotFoundException 
 * @throws SQLException 
   */
  public static int asociarKartAPistaDisponible(int kart, String track){
	  int ret = 2;
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	    
	  Properties cons = new Properties();
	  
	  try {
		  cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
	  } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	  
		  
	  if(comprobarExistenciaPista(track) == true && comprobarSitiosLibrePista(track) == true) {
		  PreparedStatement ps;
		  
		  try {
			  ps = connection.prepareStatement(cons.getProperty("AssociateTrackToKart"));
			  ps.setString(1, track);
			  ps.setInt(2, kart);
			  
			  // Lo alamcenamos en la base de datos
			  ps.executeUpdate();
			  ret = 1;
		  } catch (SQLException e) { e.printStackTrace(); }
		  
	  }
	  dbConnection.closeConnection();
	  return ret;
  }

  private static boolean comprobarSitiosLibrePista(String track){
	  
	  boolean bool = false;
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
	    
	  Properties cons = new Properties();
	  
	  try {
		  cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  Statement stmt_track = null;
	  
	  try {
		  stmt_track = connection.createStatement();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  ResultSet rs_track = null;
	  
	  try {
		  rs_track = (ResultSet) stmt_track.executeQuery(cons.getProperty("GetTrack") + "'" + track + "'");
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  Statement stmt_kart = null;
	  
	  try {
		  stmt_kart = connection.createStatement();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  ResultSet rs_kart = null;
	  
	  try {
		  rs_kart = (ResultSet) stmt_kart.executeQuery(cons.getProperty("GetKartTrack") + "'" + track + "'");
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  
	  try {
		  if(rs_track.next() && rs_kart.next()) {
			  	try {
			  		if(rs_track.getInt("MaxKarts") > rs_kart.getInt(1)) { bool = true; }
			  	} catch (SQLException e) { e.printStackTrace(); }
		  }
	  } catch (SQLException e) { e.printStackTrace(); }
	  	  
	  dbConnection.closeConnection();
	  return bool;
  }

/**
   * lists pistas that are on manteniance
 * @throws IOException 
 * @throws FileNotFoundException 
 * @throws SQLException 
   */
  public static ArrayList<String> listarPistasMantenimiento(){
	  ArrayList<String> tracks = new ArrayList<String>();
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
	    
	  Properties cons = new Properties();
	  
	  try {
		  cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  PreparedStatement ps = null;
	  
	  try {
		  ps = connection.prepareStatement(cons.getProperty("TracksMaintenance"));
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  ResultSet rs = null;
	  
	  try {
		  rs = (ResultSet) ps.executeQuery();
		  while(rs.next()) {
			  PistaDTO track = new PistaDTO(rs.getString("Name"), rs.getBoolean("State"), Dificultad.valueOf(rs.getString("Difficulty")), rs.getInt("MaxKarts"));
			  tracks.add(track.toString());
		  }
	  } catch (SQLException e) { e.printStackTrace(); }

	  dbConnection.closeConnection();
	  return tracks;
  }

// Dado un número de karts y tipo de pista, devolver el conjunto de pistas que estén
// libres (no reservadas ni en mantenimiento) y tengan al menos ese número de karts
// asociados.
  /**
   * Dado un número de karts y tipo de pista, devolver el conjunto de pistas que estén libres (no reservadas ni en mantenimiento) y tengan al menos ese número de karts asociados.
   * @return pistas that meet the requirements
   */
  public static void pistasLibresConXKarts(int nKarts, Dificultad dificultad){


	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	    
	  Properties cons = new Properties();
	  
	  try {
		  cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
	  } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	  
	  // Lo primero es obtener aquellas pistas que no esten en mantenimiento y con la dificultad especificada
	  PreparedStatement ps = null;
	  
	  try {
		  ps = connection.prepareStatement(cons.getProperty("GetTracksDificultyMinKarts"));
		  ps.setInt(1, 1);
		  ps.setString(2, dificultad.toString());
	  } catch (SQLException e2) { e2.printStackTrace(); }


	  ResultSet rs = null;
	  
	  try {
		  rs = (ResultSet) ps.executeQuery();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  try {
		while(rs.next()) {
			  // Ahora obtenemos cuantos Kart tiene las pistas que hemos obtenido en la consulta
			  Statement stmt_kart = null;
			  
			  try {
				  stmt_kart = connection.createStatement();
			  } catch (SQLException e) { e.printStackTrace(); }
			  
			  ResultSet rs_kart = null;
			
			  try {
				  rs_kart = (ResultSet) stmt_kart.executeQuery(cons.getProperty("GetKartTrack") + "'" + rs.getString("Name") + "'");
				  rs_kart.next();
				  
				  if(rs_kart.getInt(1) >= nKarts) {
					  System.out.println("Track -> " + rs.getString("Name"));
				  }
			  } catch (SQLException e1) { e1.printStackTrace(); }
		  }
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  dbConnection.closeConnection();

		
	}

  public static ArrayList<String> trackList(int child){
	  	ArrayList<String> tracks = new ArrayList<String>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e2) { e2.printStackTrace(); }
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
		  
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (IOException e) { e.printStackTrace(); }
		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("GetListTrack"));
			ps.setString(1, Dificultad.familiar.toString());
			if(child == 1) { ps.setString(2, Dificultad.infantil.toString()); }
			else { ps.setString(2, Dificultad.adultos.toString()); }
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				if(comprobarSitiosLibrePista(rs.getString("Name")) == true) {
					tracks.add(rs.getString("Name"));
				}
			}
		} catch (SQLException e) { e.printStackTrace(); }
		    
		dbConnection.closeConnection();
		
		return tracks;
  }
}




