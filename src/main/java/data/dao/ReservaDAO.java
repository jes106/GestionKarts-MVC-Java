package data.dao;

import data.common.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.ResultSet;
import java.sql.*;

import business.PistaDTO;
import business.ReservaDTO;
import business.ReservaMgr;
import data.common.SystemManager;
import data.common.DBConnection;
import data.common.reservationfactory.*;
import data.common.reservationtypes.*;



/**
 * This class manages the Reserva class
 * @author Antonio Diaz Barbancho
 * @version 09/10/2022
 */

public class ReservaDAO {
	
	static ConcreteBonusReservationFactory bonusReservationGestor = new ConcreteBonusReservationFactory();
	static ConcreteIndividualReservationFactory individualReservationGestor = new ConcreteIndividualReservationFactory();
	
	public ReservaDAO() {
		
	}
	
	
	public static void altaReservaChild(ChildReservation child){
	
		DBConnection dbConnection = new DBConnection();
	    Connection connection = null;
		
	    try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	    
	 	
	 	if(child.getbonusNumber() != 0) {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement("INSERT INTO Reservations (Email, Date, Lenght, Price, Discount, Track, Type, ChildremNumber, IdBono) values(?,?,?,?,?,?,?,?,?)");
				ps_2.setString(1, child.getEmail());
			 	ps_2.setTimestamp(2, child.getFecha());
			 	ps_2.setInt(3, child.getDuracion());
			 	ps_2.setFloat(4, child.getPrecio());
			 	ps_2.setFloat(5, child.getDescuento());
			 	ps_2.setString(6, child.getPista());
			 	ps_2.setString(7, "infantil");
			 	ps_2.setInt(8, child.getchildrenNumber());
			 	ps_2.setInt(9, child.getbonusNumber());
			 	ps_2.executeUpdate();
			} catch (SQLException e) { e.printStackTrace(); }
		 	
	 	}else {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement("INSERT INTO Reservations (Email, Date, Lenght, Price, Discount, Track, Type, ChildremNumber) values(?,?,?,?,?,?,?,?)");
				ps_2.setString(1, child.getEmail());
			 	ps_2.setTimestamp(2, child.getFecha());
			 	ps_2.setInt(3, child.getDuracion());
			 	ps_2.setFloat(4, child.getPrecio());
			 	ps_2.setFloat(5, child.getDescuento());
			 	ps_2.setString(6, child.getPista());
			 	ps_2.setString(7, "infantil");
			 	ps_2.setInt(8, child.getchildrenNumber());
			 	ps_2.executeUpdate();
			} catch (SQLException e) { e.printStackTrace(); }
	 	}
		  
		dbConnection.closeConnection();
			
	}
	
	public static void altaReservaAdults(AdultsReservation adult){
		DBConnection dbConnection = new DBConnection();
	    Connection connection = null;
		
	    try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	    
	 	
	 	if(adult.getbonusNumber() != 0) {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement("INSERT INTO Reservations (Email, Date, Lenght, Price, Discount, Track, Type, AdultsNumber, IdBono) values(?,?,?,?,?,?,?,?,?)");
				ps_2.setString(1, adult.getEmail());
			 	ps_2.setTimestamp(2, adult.getFecha());
			 	ps_2.setInt(3, adult.getDuracion());
			 	ps_2.setFloat(4, adult.getPrecio());
			 	ps_2.setFloat(5, adult.getDescuento());
			 	ps_2.setString(6, adult.getPista());
			 	ps_2.setString(7, Dificultad.adultos.toString());
			 	ps_2.setInt(8, adult.getadultsNumber());
			 	ps_2.setInt(9, adult.getbonusNumber());
			 	ps_2.executeUpdate();
			} catch (SQLException e) { e.printStackTrace(); }
		 	
	 	}else {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement("INSERT INTO Reservations (Email, Date, Lenght, Price, Discount, Track, Type, AdultsNumber) values(?,?,?,?,?,?,?,?)");
				ps_2.setString(1, adult.getEmail());
			 	ps_2.setTimestamp(2, adult.getFecha());
			 	ps_2.setInt(3, adult.getDuracion());
			 	ps_2.setFloat(4, adult.getPrecio());
			 	ps_2.setFloat(5, adult.getDescuento());
			 	ps_2.setString(6, adult.getPista());
			 	ps_2.setString(7, Dificultad.adultos.toString());
			 	ps_2.setInt(8, adult.getadultsNumber());
			 	ps_2.executeUpdate();
			} catch (SQLException e) { e.printStackTrace(); }
	 	}
		  
		dbConnection.closeConnection();

	}
	
	public static void altaReservaFamiliar(FamiliarReservation fam){
		DBConnection dbConnection = new DBConnection();
	    Connection connection = null;
		
	    try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }

	    
	 	if(fam.getbonusNumber() != 0) {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement("INSERT INTO Reservations (Email, Date, Lenght, Price, Discount, Track, Type, ChildremNumber, AdultsNumber, IdBono) values(?,?,?,?,?,?,?,?,?,?)");
				ps_2.setString(1, fam.getEmail());
			 	ps_2.setTimestamp(2, fam.getFecha());
			 	ps_2.setInt(3, fam.getDuracion());
			 	ps_2.setFloat(4, fam.getPrecio());
			 	ps_2.setFloat(5, fam.getDescuento());
			 	ps_2.setString(6, fam.getPista());
			 	ps_2.setString(7, Dificultad.familiar.toString());
			 	ps_2.setInt(8, fam.getchildrenNumber());
			 	ps_2.setInt(9, fam.getadultsNumber());
			 	ps_2.setInt(10, fam.getbonusNumber());
			 	ps_2.executeUpdate();
			} catch (SQLException e) { e.printStackTrace(); }
		 	
	 	}else {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement("INSERT INTO Reservations (Email, Date, Lenght, Price, Discount, Track, Type, ChildremNumber, AdultsNumber) values(?,?,?,?,?,?,?,?,?)");
				ps_2.setString(1, fam.getEmail());
			 	ps_2.setTimestamp(2, fam.getFecha());
			 	ps_2.setInt(3, fam.getDuracion());
			 	ps_2.setFloat(4, fam.getPrecio());
			 	ps_2.setFloat(5, fam.getDescuento());
			 	ps_2.setString(6, fam.getPista());
			 	ps_2.setString(7, Dificultad.familiar.toString());
			 	ps_2.setInt(8, fam.getchildrenNumber());
			 	ps_2.setInt(9, fam.getadultsNumber());
			 	ps_2.executeUpdate();
			} catch (SQLException e) { e.printStackTrace(); }
	 	}
		  
		dbConnection.closeConnection();
	}
		
	public float calcularPrecio(int duracion, float descuento){
		
		float precio = 0;
		
		if(duracion==60) {
			precio = 20;
		}
		else if(duracion==90) {
			precio = 30;
		}
		else if(duracion==120) {
			precio = 40;
		}
		
		if(descuento != 0) {
			precio = precio * descuento;
		}	
		
		return precio;
	}	
	
	public float calcularDescuento(String email, boolean bonus){
		
		float descuento = 0;

		if(UsuarioDAO.calcularAntiguedad(email)>=2) {
			descuento = (float)0.90;
		}
		
		if(bonus == true) {
			descuento = (float)0.95;
		}
		
		return descuento;
	}	
		
	public ArrayList<String> getMiReservations(String email){
		ArrayList<String> res = new ArrayList<String>();
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }

	  
		Statement stmt = null;
		
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) { e.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) stmt.executeQuery("SELECT * FROM Reservations WHERE Email =" + "'" + email + "'");
			while(rs.next()) {
				String re = "Datos de la reserva:\n"+"ID"+rs.getString("Id")+"Email de usuario: "+rs.getString("Email")+" "+"Fecha de reserva: "+rs.getTimestamp("Date")+" "+
				"Duracion de la reserva: "+rs.getInt("Lenght")+" "+"Pista: "+rs.getString("Track")+" "+"Precio total de la reserva: "+rs.getFloat("Price")+" "+"Descuento: "+
				rs.getFloat("Discount")+" Número de niños: "+rs.getInt("ChildremNumber")+" Número de adultos: "+rs.getInt("AdultsNumber")+" Número de bono: "+rs.getInt("AdultsNumber");
				res.add(re);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		dbConnection.closeConnection();
		return res;
	}
		
	public static void elegirPista(Dificultad type, int people){
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } 
		  catch (IOException e) { e.printStackTrace(); }
		
		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Tracks WHERE Difficulty = ?");
			ps.setString(1, type.toString());
		} catch (SQLException e) { e.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				
				PistaDTO track = new PistaDTO(rs.getString("Name"), rs.getBoolean("State"), Dificultad.valueOf(rs.getString("Difficulty")), rs.getInt("MaxKarts"));
				Statement stmt = connection.createStatement();
				ResultSet rs_2 = (ResultSet) stmt.executeQuery(cons.getProperty("GetKartTrack") + "'" + rs.getString("Name") + "'");
				rs_2.next();
				
				if(people <= rs_2.getInt(1)) {
					System.out.println(track.toString());
				}	
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		dbConnection.closeConnection();
	}

	public static int CompruebaBono(String mail, int idbono, Dificultad type) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
	  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Bono WHERE IdNumber = ?");
			ps.setInt(1, idbono);
		} catch (SQLException e) { e.printStackTrace(); }

		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			if(rs.next()) {
				if(!rs.getString("Email").equals(mail)) { return 2; }
				else if(!rs.getString("Type").equals(type.toString())) { return 3; }
			}else { return 1; }
		} catch (SQLException e) { e.printStackTrace(); }

		dbConnection.closeConnection();
		return 0;
	}
	
	public static boolean CompruebaFechaReserva(Timestamp date, int lenght, String track){
		
		boolean bool = true;
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		   
		
		//Primero obtenemos todas las reservas comprendidas entre la hora de la reserva a realizar y dos horas antes
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Reservations WHERE ? <= Date AND Date <= ? AND Track = ?");
			ps.setTimestamp(1, SystemManager.SumaRestaFecha(date, 120, "r"));
			ps.setTimestamp(2, date);
			ps.setString(3, track);
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				if(SystemManager.SumaRestaFecha(rs.getTimestamp("Date"), rs.getInt("Lenght"), "s").after(date)) { bool = false; }
				else { bool = true; }
			}
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		if(bool == true) {
			//Segundo comprobamos que nuestra reserva no se pise con las siguientes
			PreparedStatement ps2 = null;
			
			try {
				ps2 = connection.prepareStatement("SELECT * FROM Reservations WHERE ? <= Date AND Date <= ? AND Track = ?");
				ps2.setTimestamp(1, date);
				ps2.setTimestamp(2, SystemManager.SumaRestaFecha(date, lenght, "s"));
				ps2.setString(3, track);
			} catch (SQLException e) { e.printStackTrace(); }
	
			ResultSet rs2 = null;
			
			try {
				rs2 = (ResultSet) ps2.executeQuery();
				if(rs2.next()) { bool = false; }
				else { bool = true; }
			} catch (SQLException e) { e.printStackTrace(); }
		}
		
		dbConnection.closeConnection();
		return bool;
	}

	/* Modificacion de Email */
	public static void modEmailResv(ChildReservation child, String mail) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }

		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Email = ? WHERE Email = ?");
			ps.setString(1, child.getEmail());
			ps.setString(2, mail);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static void modEmailResv(AdultsReservation adult, String mail) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		

		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Email = ? WHERE Email = ?");
			ps.setString(1, adult.getEmail());
			ps.setString(2, mail);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	public static void modEmailResv(FamiliarReservation fam, String mail) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Email = ? WHERE Email = ?");
			ps.setString(1, fam.getEmail());
			ps.setString(2, mail);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	/* Modificacion de Fecha */
	public static void modDateResv(ChildReservation child) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Date = ? WHERE Email = ?");
			ps.setTimestamp(1, child.getFecha());
			ps.setString(2, child.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static void modDateResv(AdultsReservation adult) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		

		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Date = ? WHERE Email = ?");
			ps.setTimestamp(1, adult.getFecha());
			ps.setString(2, adult.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static void modDateResv(FamiliarReservation fam) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Date = ? WHERE Email = ?");
			ps.setTimestamp(1, fam.getFecha());
			ps.setString(2, fam.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	/* Modificacion de Duracion */
	public static void modLenghtResv(ChildReservation child) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Lenght = ?, Price = ? WHERE Email = ?");
			ps.setInt(1, child.getDuracion());
			ps.setFloat(2, child.getDescuento());
			ps.setString(3, child.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static void modLenghtResv(AdultsReservation adult) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		

		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Lenght = ?, Price = ? WHERE Email = ?");
			ps.setInt(1, adult.getDuracion());
			ps.setFloat(2, adult.getDescuento());
			ps.setString(3, adult.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	public static void modLenghtResv(FamiliarReservation fam) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Lenght = ?, Price = ? WHERE Email = ?");
			ps.setInt(1, fam.getDuracion());
			ps.setFloat(2, fam.getDescuento());
			ps.setString(3, fam.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	/* Modificacion de Pista */
	public static void modTrackResv(ChildReservation child) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Track = ? WHERE Email = ?");
			ps.setString(1, child.getPista());
			ps.setString(2, child.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	public static void modTrackResv(AdultsReservation adult) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Track = ? WHERE Email = ?");
			ps.setString(1, adult.getPista());
			ps.setString(2, adult.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	public static void modTrackResv(FamiliarReservation fam) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set Track = ? WHERE Email = ?");
			ps.setString(1, fam.getPista());
			ps.setString(2, fam.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	/* Modificacion de Numero de adultos */
	public static void modNAdultResv(AdultsReservation adult) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set AdultsNumber = ? WHERE Email = ?");
			ps.setInt(1, adult.getadultsNumber());
			ps.setString(2, adult.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static void modNAdultResv(FamiliarReservation fam) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set AdultsNumber = ? WHERE Email = ?");
			ps.setInt(1, fam.getadultsNumber());
			ps.setString(2, fam.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	/* Modificacion de Numero de Niños */
	public static void modNChildResv(ChildReservation child) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set AdultsNumber = ? WHERE Email = ?");
			ps.setInt(1, child.getchildrenNumber());
			ps.setString(2, child.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static void modNChildResv(FamiliarReservation fam) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Reservations set AdultsNumber = ? WHERE Email = ?");
			ps.setInt(1, fam.getchildrenNumber());
			ps.setString(2, fam.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	/* Otras */
	public static ArrayList<String> ListarReservasFuturas(){
		ArrayList<String> res = new ArrayList<String>();
		
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
			ps = connection.prepareStatement("SELECT * FROM Reservations WHERE Date >= ?");
			ps.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				res.add(rs.getString("Id"));
				res.add(rs.getString("Email"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		    
		dbConnection.closeConnection();
		
		return res;
	}

	public static void eliminarReserva(int id) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("DELETE FROM Reservations WHERE Id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static ArrayList<ArrayList<String>> listarReservaFechas(Timestamp inicio, Timestamp fin, String Email){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int i = 0;
		
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
			ps = connection.prepareStatement("SELECT * FROM Reservations WHERE ? <= Date AND Date <= ? AND Email = ?");
			ps.setTimestamp(1, inicio);
			ps.setTimestamp(2, fin);
			ps.setString(3, Email);
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> var = new ArrayList<String>();
				var.add(rs.getTimestamp("Date").toString());
				var.add(rs.getString("Price"));
				var.add(rs.getString("Track"));
				var.add(rs.getString("Type"));
				var.add(rs.getString("ChildremNumber"));
				var.add(rs.getString("AdultsNumber"));
				if(rs.getTimestamp("Date").before(new Timestamp(new java.util.Date().getTime()))) { var.add("Finalizada"); }
				else { var.add("Futura"); }
				res.add(var);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		    
		dbConnection.closeConnection();
		
		return res;
	}

	public static boolean CompruebaBono(String email, String type) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
	    

	  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Bono WHERE Email = ? AND Type = ? AND SessionNumber < 5");
			ps.setString(1, email);
			ps.setString(2, type);
		} catch (SQLException e) { e.printStackTrace(); }

		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) { e.printStackTrace(); }

		dbConnection.closeConnection();
		return false;
	}

	public static ArrayList<ArrayList<String>> listReservasModificables(String email){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
	    

		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Reservations WHERE Email = ? AND Date >= ?");
			ps.setString(1, email);
			ps.setTimestamp(2, SystemManager.SumaRestaFecha(new Timestamp(new java.util.Date().getTime()), 1440, "s"));
		} catch (SQLException e) { e.printStackTrace(); }

		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> var = new ArrayList<String>();
				var.add(String.valueOf(rs.getInt("Id")));
				var.add(rs.getString("Track"));
				var.add(rs.getString("Date"));
				var.add(String.valueOf(rs.getInt("IdBono")));
				res.add(var);
			}
		} catch (SQLException e) { e.printStackTrace(); }

		dbConnection.closeConnection();
		
		return res;
	}

	public static int obtenerBono(String email, String type) {
		int id = -1;
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }

	  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Bono WHERE Email = ? AND Type = ? AND SessionNumber < 5");
			ps.setString(1, email);
			ps.setString(2, type);
		} catch (SQLException e) { e.printStackTrace(); }

		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			if(rs.next()) {
				id = rs.getInt("IdNumber");
			}
		} catch (SQLException e) { e.printStackTrace(); }

		dbConnection.closeConnection();
		return id;
	}
	
	public static void crearBono(String email, String type) {
		DBConnection dbConnection = new DBConnection();
	    Connection connection = null;
		
	    try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }

	    
	 	
 		PreparedStatement ps_2;
		try {
			ps_2 = connection.prepareStatement("INSERT INTO Bono (SessionNumber, DateCreated, Type, Email) values (?,?,?,?)");
			ps_2.setInt(1, 0);
		 	ps_2.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));
		 	ps_2.setString(3, type);
		 	ps_2.setString(4, email);
		 	ps_2.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }	
		  
		dbConnection.closeConnection();
	}

	public static void updateSessionBono(int idBono) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }

		
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("UPDATE Bono set SessionNumber = SessionNumber+1 WHERE IdNumber = ?");
			ps.setInt(1, idBono);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		
		dbConnection.closeConnection();
	}

	public static boolean compruebaReservaBono(int id) {
		boolean bool = false;
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
	    

	  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Reservations WHERE Id = ? AND IdBono IS NOT NULL");
			ps.setInt(1, id);
		} catch (SQLException e) { e.printStackTrace(); }

		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			if(rs.next()) {
				bool = true;
			}
		} catch (SQLException e) { e.printStackTrace(); }

		dbConnection.closeConnection();
		return bool;
	}

	public static int getIdBonoReserva(int id) {
		int idBono = -1;
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
	   
	  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Reservations WHERE Id = ?");
			ps.setInt(1, id);
		} catch (SQLException e) { e.printStackTrace(); }

		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			if(rs.next()) {
				idBono = rs.getInt("IdBono");
			}
		} catch (SQLException e) { e.printStackTrace(); }

		dbConnection.closeConnection();
		return idBono;		
	}

	public static void DeleteSessionBono(int idBono) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }

		
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("UPDATE Bono set SessionNumber = SessionNumber-1 WHERE IdNumber = ?");
			ps.setInt(1, idBono);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		
		dbConnection.closeConnection();
	}

	public static int getSessionBono(int idBono) {
		int session = 0;
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }

	  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Bono WHERE IdNumber = ?");
			ps.setInt(1, idBono);
		} catch (SQLException e) { e.printStackTrace(); }

		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			if(rs.next()) {
				session = rs.getInt("SessionNumber");
			}
		} catch (SQLException e) { e.printStackTrace(); }

		dbConnection.closeConnection();
		return session;
	}

	public static void deleteBono(int idBono) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("DELETE FROM Bono WHERE IdNumber = ?");
			ps.setInt(1, idBono);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		
		dbConnection.closeConnection();
	}
}
