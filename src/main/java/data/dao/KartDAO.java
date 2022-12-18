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

/***
 * A class to manage the model of data of karts
 * @author Antonio Díaz Pérez
 *
 */
public class KartDAO {
	/***
	 * Function to create a new kart (add it to the database)
	 * @param kart the DTO of the kart
	 */
	public static void crearKart(KartDTO kart){

		  DBConnection dbConnection = new DBConnection();
		  Connection connection = null;
		  try {
			  connection = dbConnection.getConnection();
		  } catch (IOException e) { e.printStackTrace(); }
		  
		  
		  PreparedStatement ps;
		  
		  try {
			  ps = connection.prepareStatement("INSERT INTO Karts (Id, Child, State) values(?,?,?)");
			  ps.setInt(1, kart.getId());
			  ps.setBoolean(2, kart.getChild());
			  ps.setString(3, kart.getEstado().toString());
			  
			  // Lo alamcenamos en la base de datos
			  ps.executeUpdate();
		  } catch (SQLException e) { e.printStackTrace(); }
		    
		  dbConnection.closeConnection();
	}
	
	/***
	 * Create a kart without DTO
	 * @param id
	 * @param child
	 * @param estado
	 * @param track
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void crearKart(int id, boolean child, String estado, String track) throws FileNotFoundException, IOException, SQLException {

		  DBConnection dbConnection = new DBConnection();
		  Connection connection = dbConnection.getConnection();
		  
		  
		  if(PistaDAO.comprobarExistenciaPista(track) == true) {
			  PreparedStatement ps = connection.prepareStatement("INSERT INTO Karts (Id, Child, State) values(?,?,?)");
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

		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Karts WHERE Id = ?");
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

	public static ArrayList<Integer> kartListNoAssociated(int child){
		ArrayList<Integer> karts = new ArrayList<Integer>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e2) { e2.printStackTrace(); }
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
		  

		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Karts WHERE TrackName IS NULL AND Child = ? ORDER BY Id");
			ps.setInt(1, child);
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
	
	public static ArrayList<Integer> kartList(){
		ArrayList<Integer> karts = new ArrayList<Integer>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e2) { e2.printStackTrace(); }
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
		  
		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Karts ORDER BY Id");
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

	public static void ModifyStateKart(int id, String state) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e2) { e2.printStackTrace(); }
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }

		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Karts set State = ? WHERE Id = ?");
			ps.setString(1, state);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e1) { e1.printStackTrace(); }
		    
		dbConnection.closeConnection();
	}
}
