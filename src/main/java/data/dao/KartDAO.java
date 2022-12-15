package data.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import business.KartDTO;
import data.common.DBConnection;
import data.common.EstadoKart;

public class KartDAO {
	public static void crearKart(KartDTO kart){

		  DBConnection dbConnection = new DBConnection();
		  Connection connection = null;
		  try {
			  connection = dbConnection.getConnection();
		  } catch (IOException e) { e.printStackTrace(); }
		  
		  Properties cons = new Properties();
		  
		  try {
			  cons.load(new FileReader("./src/main/java/Consultas.properties"));
		  } catch (IOException e) { e.printStackTrace(); }
		  
		  PreparedStatement ps;
		  
		  try {
			  ps = connection.prepareStatement(cons.getProperty("InsertKart"));
			  ps.setInt(1, kart.getId());
			  ps.setBoolean(2, kart.getChild());
			  ps.setString(3, kart.getEstado().toString());
			  
			  // Lo alamcenamos en la base de datos
			  ps.executeUpdate();
		  } catch (SQLException e) { e.printStackTrace(); }
		    
		  dbConnection.closeConnection();
	}
	
	
	public static void crearKart(int id, boolean child, String estado, String track) throws FileNotFoundException, IOException, SQLException {

		  DBConnection dbConnection = new DBConnection();
		  Connection connection = dbConnection.getConnection();
		  
		  Properties cons = new Properties();
		  cons.load(new FileReader("./src/main/java/Consultas.properties"));
		  
		  if(PistaDAO.comprobarExistenciaPista(track) == true) {
			  PreparedStatement ps = connection.prepareStatement(cons.getProperty("InsertKart"));
			  ps.setInt(1, id);
			  ps.setBoolean(2, child);
			  ps.setString(3, estado);
			  PistaDAO.asociarKartAPistaDisponible(id, track);
			  
			  // Lo alamcenamos en la base de datos
			  ps.executeUpdate();
		  }
		    
		  dbConnection.closeConnection();
	}
	
	public static boolean comprobarExistenciaKart(int id){
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
			ps = connection.prepareStatement(cons.getProperty("GetKart"));
			ps.setInt(1, id);
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) { e.printStackTrace(); }
		    
		dbConnection.closeConnection();
		
		return false;
	}

	public static ArrayList<Integer> kartListNoAssociatedChild(){
		ArrayList<Integer> karts = new ArrayList<Integer>();
		
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
			cons.load(new FileReader("./src/main/java/Consultas.properties"));
		} catch (IOException e) { e.printStackTrace(); }
		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("GetListKartNoAssociatedChild"));
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				karts.add(rs.getInt("id"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		    
		dbConnection.closeConnection();
		
		return karts;
	}
	
}
