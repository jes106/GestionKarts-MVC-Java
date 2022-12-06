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
	    
	    Properties cons = new Properties();
	    
	    try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties")); } catch (FileNotFoundException e) { e.printStackTrace(); } 
	    																   catch (IOException e) { e.printStackTrace(); }
	 	
	 	if(child.getbonusNumber() != 0) {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement(cons.getProperty("InsertChildReservationBono"));
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
				ps_2 = connection.prepareStatement(cons.getProperty("InsertChildReservationIndiv"));
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
	    
	    Properties cons = new Properties();
	    
	    try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties")); } catch (FileNotFoundException e) { e.printStackTrace(); } 
	    																   catch (IOException e) { e.printStackTrace(); }
	 	
	 	if(adult.getbonusNumber() != 0) {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement(cons.getProperty("InsertAdultReservationBono"));
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
				ps_2 = connection.prepareStatement(cons.getProperty("InsertAdultReservationIndiv"));
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
	    
	    Properties cons = new Properties();
	    
	    try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties")); } catch (FileNotFoundException e) { e.printStackTrace(); } 
	    																   catch (IOException e) { e.printStackTrace(); }
	    
	 	if(fam.getbonusNumber() != 0) {
	 		PreparedStatement ps_2;
			try {
				ps_2 = connection.prepareStatement(cons.getProperty("InsertFamReservationBono"));
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
				ps_2 = connection.prepareStatement(cons.getProperty("InsertFamReservationIndiv"));
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
			rs = (ResultSet) stmt.executeQuery(cons.getProperty("InfoMyReservation") + "'" + email + "'");
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
		    
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("GetTrackType"));
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
	    
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (IOException e) { e.printStackTrace(); }
	  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("CheckBonoById"));
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
		   
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (IOException e) { e.printStackTrace(); }
		
		//Primero obtenemos todas las reservas comprendidas entre la hora de la reserva a realizar y dos horas antes
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("CheckDateReservation"));
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
				ps2 = connection.prepareStatement(cons.getProperty("CheckDateReservation"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateEmailRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateEmailRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateEmailRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateDateRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateDateRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateDateRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateLenghtRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateLenghtRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateLenghtRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateTrackRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateTrackRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateTrackRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateNAdultRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateNAdultRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateNChilRes"));
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
		
		Properties cons = new Properties();
		
		try {
			cons.load(new FileReader("./src/main/java/data/common/Consultas.properties"));
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(cons.getProperty("UpdateNChilRes"));
			ps.setInt(1, fam.getchildrenNumber());
			ps.setString(2, fam.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}
}
