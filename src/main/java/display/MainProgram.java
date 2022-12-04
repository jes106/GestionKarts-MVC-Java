package display;

import java.io.*;
import java.sql.*;
import java.text.*;
/**
 * Contains the main program and some auxiliary functions
 * @author Antonio Diaz Bárbancho
 * @author Antonio Diaz Perez
 * @author Jesus Escribano Serena
 * @author Juan José Trenado Zafra
 * @version 07/10/2022
 */

public class MainProgram {
	
	
	/********************************************************************************/
	//										MAIN				    				//
	/********************************************************************************/
	/* 
	 * @throws SQLException
	 */
	public static void main(String[] args) throws IOException, ParseException, SQLException {
		
		int opcion;
		
		opcion = Menu.Principal();
		
		while(opcion != 0) {
			switch(opcion) {
				case 1:	//Gestor Usuario
					Menu.Usuario();
				break;
				
				case 2:	//Gestor Pistas
					Menu.Pistas();
				break;
				
				case 3:	//Gestor Usuario
					Menu.Reservas();
				break;
			}
			
			
			System.out.println("\n\n");
			opcion = Menu.Principal(); 
		}		
	}

}