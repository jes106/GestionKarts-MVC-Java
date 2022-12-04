package display;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import business.*;
import data.dao.*;
import data.common.*;

public class Menu {
	
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static int Principal() {
		int opcion;
	    System.out.println("Bienvenido, a nuestro sistema.");
	    System.out.println("¿Que gestor desea abrir?");
	    System.out.println("\tPulse 1 para Gestor de Usuarios.");
	    System.out.println("\tPulse 2 para Gestor de Pistas.");
	    System.out.println("\tPulse 3 para Gestor de Reservas");
	    System.out.println("\tPulse 0 para salir");
	    System.out.print("Escoja una opción y pulse enter: ");
	    opcion = teclado.nextInt();
	    teclado.nextLine();
	    
	    return opcion;
	}
	
	public static void Usuario() {
		int opcion = 1;
		System.out.println(ANSI_BLUE + "\n\nGESTIÓN DE USUSARIO\n-----------------------" + ANSI_RESET);
		System.out.println("\t1. Añadir un nuevo usuario (se comprobará que no estuviera añadido previamente.)");
		System.out.println("\t2. Modificar un usuario que ya existía.");
		System.out.println("\t3. Listar los usuarios que están registrados.");
		System.out.print("Escoja una opción y pulse enter: ");
	    opcion = teclado.nextInt();
	    teclado.nextLine();
	    
	   switch(opcion) {
			case 1:{	//Añadir Usuario
				String nombre;
				String mail;
				int dia,mes,año;
				int i = 0;
				boolean back = false;
				
				do{
					System.out.print("Introduzca el nombre y apellidos del usuario: ");
					nombre = teclado.nextLine();
					System.out.print("Introduzca el día de nacimiento del ususario: " );
					dia = teclado.nextInt();
					System.out.print("Introduzca el mes (de la forma 01) de nacimiento del usuario: ");
					mes = teclado.nextInt();
					System.out.print("Introduzca el año de nacimiento (YYYY) del usuario: ");
					año = teclado.nextInt();
					teclado.nextLine();
					System.out.print("Introduzca el mail del usuario: ");
					mail = teclado.nextLine();
					System.out.print("Introduzca el rol del usuario: ");
					String rol = teclado.nextLine();
					String date = dia + "-" + mes + "-" + año + " " + 00 + ":" + 00 + ":" + 00;		
					back = UsuarioMgr.addUser(nombre, SystemManager.StringToDateSQL(date), mail, rol);
					
					i++;
				}while(back == false && i <3);
			}break;
			case 2:{	//Modificar Usuario
				String mail;
				int i = 0;
				boolean back = false;
				
				do{
					System.out.print("Introduzca el e-mail del usuario que desea modificar: ");
					mail = teclado.nextLine();
					// Comprobamos el email
					back = UsuarioDAO.comprobarEsxistenciaUsuario(mail);
					if(back == false) {
						System.out.println("El e-mail no pertenece a ningun usario.");
						i++;
					}
					if(i == 3) { System.out.println("Se a alcanzado el maximo de intentos."); }
				}while(back == false && i <3);
				
				if(back == true) {
					System.out.println("Introduce que dato desea modicar");
					System.out.println("\t1. Fecha de nacimiento. \n");
					System.out.println("\t2. Nombre.\n");
					System.out.println("\t3. Rol.\n");
					opcion = teclado.nextInt();
					teclado.nextLine();
					
					switch(opcion) {
						case 1:{
							int day,month,year;
							System.out.print("Introduzca el día de nacimiento del ususario: " );
							day = teclado.nextInt();
							System.out.print("Introduzca el mes (de la forma 01) de nacimiento del usuario: ");
							month = teclado.nextInt();
							System.out.print("Introduzca el año de nacimiento (YYYY) del usuario: ");
							year = teclado.nextInt();
							teclado.nextLine();
							String date = day + "-" + month + "-" + year + " 00:00:00";
							UsuarioDTO user = UsuarioDAO.getUser(mail);
							user.setBirthDate(SystemManager.StringToDateSQL(date));
							
							UsuarioDAO.modBirhtUser(user);
							}break;
						case 2:{
							System.out.println("Introduce el nuevo nombre.");
							String name = teclado.nextLine();
							
							UsuarioDTO user = UsuarioDAO.getUser(mail);
							user.setNameSurname(name);
							
							UsuarioDAO.modNameUser(user);
							}break;
					}
					
					System.out.println("El usuario se ha modificado con exito."); }
				
				}break;
			case 3:	//Listar Usuarios
				UsuarioDAO.listarUsuarios();
			break;
	    }
	}
	
	public static void Pistas() throws FileNotFoundException, IOException, SQLException {
		int opcion;
		System.out.println(ANSI_RED+"\n\nGESTIÓN DE PISTAS\n-----------------------"+ANSI_RESET);
		System.out.println("\t1. Crear Pista");
		System.out.println("\t2. Crear Karts");
		System.out.println("\t3. Asignar un kart a una pista (se comprobará que esté disponible y se adapte al tipo de pista)");
		System.out.println("\t4. Listas las pistas en mantenimiento");
		System.out.println("\t5. Solicitar pistas de un tipo disponibles y con un número mínimo de karts");
		System.out.print("Escoja una opción y pulse enter: ");
	    opcion = teclado.nextInt();
	    teclado.nextLine();
	    
	    switch(opcion) {
			case 1:{	//Crear Pista
				String nombrePista, dificultadString;
				boolean estadoPista;
				Dificultad dificultad = null;
				int maxKarts;
				boolean back;
				
				System.out.print("Introduzca el nombre de la pista: ");
				nombrePista = teclado.nextLine();
				System.out.print("Introduzca el estado de la pista: ('true' si está disponible, 'false' si está en mantenimento): ");
				estadoPista = Boolean.parseBoolean(teclado.nextLine());
				do{
					back = true;
					System.out.print("Introduzca la dificultad de la pista: (1 si es infantil, 2 si es familiar o 3 si es de adultos): ");	
					dificultadString=teclado.nextLine();
					if (dificultadString.equals("1")) {
						dificultad = Dificultad.infantil;
					}
					else if (dificultadString.equals("2")){
						dificultad = Dificultad.familiar;
					}
					else if (dificultadString.equals("3")){
						dificultad = Dificultad.adultos;
					}
					else{
						System.out.print("Dificultad incorrecta.");	
						back = false;
					}
				}while(back == false);

				System.out.print("Introduzca la cantidad maxima de karts que puede haber en la pista: ");	
				maxKarts = Integer.parseInt(teclado.nextLine());

				if (dificultad!=null) {
					PistaMgr.addTrack(nombrePista, estadoPista, dificultad, maxKarts);
					System.out.println("Pista creada correctamente.");
				}
			}break;
			case 2:{	//Crear Kart
				int id_;
				EstadoKart state = null;
				String estado, child_;
				boolean back;
				
				do {
					System.out.print("Introduzca la id del kart (solo numeros): ");
					id_ = Integer.parseInt(teclado.nextLine());
					back = KartDAO.comprobarExistenciaKart(id_);
					if(back == true) { System.out.println("El id ya pertenece a otro kart, por favor introduca otro."); }
				}while(back == true);
				
				do {
					System.out.print("Introduzca 'true' si el kart es infantl o 'false' si es de adultos): ");
					child_ = teclado.nextLine();
					if(!child_.equals("true") && !child_.equals("false")) { System.out.println("Error. Introduzca `true´ o `false´"); }
				}while(!child_.equals("true") && !child_.equals("false"));
				
				do{
					back = true;
					System.out.print("Introduzca el estado del kart: (1 reservado, 2 disponible o 3 mantenimiento): ");	
					estado = teclado.nextLine();
					if (estado.equals("1")) {
						state = EstadoKart.Reservado;
					}
					else if (estado.equals("2")) {
						state = EstadoKart.Disponible;
					}
					else if (estado.equals("3")) {
						state = EstadoKart.Mantenimiento;
					}
					else{
						System.out.print("Estado incorrecto.");	
						back = false;
					}
				}while(back == false);

				KartMgr.addKart(id_, Boolean.parseBoolean(child_), state);
			}break;
			case 3:{	//Asignar Kart-Pista
				boolean bool;
				int idBuscada;
				String track;
				int i = 0;
				
				do {
					bool = false;
					System.out.print("Introduzca la id del kart que desea asociar: ");
					idBuscada = Integer.parseInt(teclado.nextLine());
					bool = KartDAO.comprobarExistenciaKart(idBuscada);
					if(bool == false) { System.out.println("El id introducido no corresponde a ningun kart."); }
					i++;
					if(i == 3) { break; }
				}while (bool == false && i<3);
				
				do {
					i = 0;
					System.out.println("Introduce el nombre de la pista a la que quiere asociar el Kart:");
					track = teclado.nextLine();
					bool = PistaDAO.comprobarExistenciaPista(track);
					if(bool == false) { System.out.println("No existe ninguna pista asociada."); }
					i++;
					if(i == 3) { break; }
				}while (bool == false && i<3);
				
				
				if (PistaDAO.asociarKartAPistaDisponible(idBuscada, track) == 1) {
					System.out.println("El kart se asoció correctamente.");
				}
				else if (PistaDAO.asociarKartAPistaDisponible(idBuscada, track) == 2) {
					System.out.println("No se ha posido asociar la pista al kart.");
				}
			}break;
			case 4:	//Listar Pistas Mantenimiento
				PistaDAO.listarPistasMantenimiento();
			break;
			case 5:{	//Solicitar Pista Disponible y con Minimo Kart
				String dificultadString;
				Dificultad dificultad = null;
				int nKarts;
				boolean back;
				
				do{
					back = true;
					System.out.print("Introduzca la dificultad de la pista: (1 si es infantil, 2 si es familiar o 3 si es de adultos): ");	
					dificultadString=teclado.nextLine();
					if (dificultadString.equals("1")) {
						dificultad = Dificultad.infantil;
					}
					else if (dificultadString.equals("2")){
						dificultad = Dificultad.familiar;
					}
					else if (dificultadString.equals("3")){
						dificultad = Dificultad.adultos;
					}
					else{
						System.out.print("Dificultad incorrecta.");	
						back = false;
					}
				}while(back == false);

				System.out.print("Introduzca el numero de karts: ");
				nKarts = Integer.parseInt(teclado.nextLine());
				PistaDAO.pistasLibresConXKarts(nKarts, dificultad);
			}break;
	    }
	}
		
	public static void Reservas() {
		System.out.println(ANSI_GREEN+"GESTION DE RESERVAS\n-----------------------\n"+ANSI_RESET
				  + "\t1. Hacer reserva\n"
				  + "\t2. Consultar mi número de reservas futuras\n"
				  + "\t3. Consultar reservas para un día y una pista\n"
				  + "\t0. Salir");
		System.out.print("Escoja una opción y pulse enter: ");
	    int opcion = teclado.nextInt();
	    teclado.nextLine();
	    
	    switch(opcion) {
			case 1:{	//Crear Reserva
				String var, track;
				Dificultad type = null;
				boolean back, bono = false, res = false;
				int idbono = -1, child, adult;
				
				do{
					back = true;
					System.out.print("¿La reserva se realizara con bono: (1 `si´, 2 `no´): ");	
					var = teclado.nextLine();
					
					if (var.equals("1")) { bono = true; }
					else if (var.equals("2")){ bono = false; }
					else{ System.out.print("Opcion incorrecta.\n"); }
					
				}while(!var.equals("1") && !var.equals("2"));
				
				System.out.print("Introduzca el mail del cliente que realiza la reserva: ");
				String mail=teclado.nextLine();
				System.out.print("¿Qué dia (dd) desea hacer la reserva? ");
				String dia = teclado.nextLine();
				System.out.print("¿Qué mes (MM) desea hacer la reserva? ");
				String mes = teclado.nextLine();
				System.out.print("¿Para qué año (MM) desea hacer la reserva? ");
				String año = teclado.nextLine();
				System.out.print("¿A que hora (HH:mm:ss) desea hacer la reserva? ");
				String hour = teclado.nextLine();
				String date = dia + "-" + mes + "-" + año + " " + hour;
				System.out.println("Introduzca la duración de la reserva: ");
				int lenght = teclado.nextInt();
				teclado.nextLine();
				
				do{
					System.out.print("¿Qué tipo de reserva desea realizar: (1 si es infantil, 2 si es familiar o 3 si es de adultos): ");	
					var = teclado.nextLine();
					
					if (var.equals("1")) { type = Dificultad.infantil; }
					else if (var.equals("2")){ type = Dificultad.familiar; }
					else if (var.equals("3")){ type = Dificultad.adultos; }
					else{ System.out.print("Dificultad incorrecta."); }
					
				}while(!var.equals("1") && !var.equals("2") && !var.equals("3"));
				
				if(bono == true) {
					do {
						back = false;
						System.out.println("Introduzca el id del bono (solo números): ");
						idbono = Integer.parseInt(teclado.nextLine());
						int i = ReservaDAO.CompruebaBono(mail, idbono, type);
						if(i == 0) { back = true; }
						if(i == 1) { System.out.println("No existe ningun bono con ese id."); }
						if(i == 2) { System.out.println("El bono no corresponde con el email introducido."); }
						if(i == 3) { System.out.println("El bono no corresponde con el tipo de reserva que desea hacer"); }
					}while(back == false);
				}
				
				switch(type) {
					case infantil:
						System.out.print("Introduzca el numero de niños: ");
						child = Integer.parseInt(teclado.nextLine());
						
						do {
							ReservaDAO.elegirPista(type, child);
							System.out.println("Introduzca el nombre de la pista: ");
							track = teclado.nextLine();
						}while(PistaDAO.comprobarExistenciaPista(track) == false);
						
						res = ReservaMgr.addReservaChild(mail, SystemManager.StringToDateSQL(date), lenght, track, type, child, idbono);
						break;
						
					case familiar:
						System.out.print("Introduzca el numero de niños: ");
						child = Integer.parseInt(teclado.nextLine());
						System.out.print("Introduzca el numero de adultos: ");
						adult = Integer.parseInt(teclado.nextLine());
						
						do {
							ReservaDAO.elegirPista(type, child+adult);
							System.out.println("Introduzca el nombre de la pista: ");
							track = teclado.nextLine();
						}while(PistaDAO.comprobarExistenciaPista(track) == false);
						
						res = ReservaMgr.addReservaFam(mail, SystemManager.StringToDateSQL(date), lenght, track, type, child, adult, idbono);
						break;
						
					case adultos:
						System.out.print("Introduzca el numero de adultos: ");
						adult = Integer.parseInt(teclado.nextLine());
						
						do {
							ReservaDAO.elegirPista(type, adult);
							System.out.println("Introduzca el nombre de la pista: ");
							track = teclado.nextLine();
						}while(PistaDAO.comprobarExistenciaPista(track) == false);
						
						res = ReservaMgr.addReservaAdult(mail, SystemManager.StringToDateSQL(date), lenght, track, type, adult, idbono);
						break;
				}
				
				if (res == true) { System.out.println("Reserva realizada"); }
				else { System.out.println("No se ha podido hacer una reserva para esa fecha."); }
				}break;
			case 2:{	//Consultar Reservas Futuras
				System.out.println("Introduzca el mail del usuario del que quiere ver las reservas: ");
				String mail=teclado.nextLine();
				ReservaDAO res = new ReservaDAO();
				res.getMiReservations(mail);
	    	}break;
			case 3:{	//Consultar Reservas Fechadas
				System.out.println("Introduzca el dia para el que quiere consultar la reserva: ");
				int dia = teclado.nextInt();
				System.out.println("Introduzca el mes para el que quiere consultar la reserva: ");
				int mes = teclado.nextInt();
				System.out.println("Introduzca el año para el que quiere consultar la reserva: ");
				int año = teclado.nextInt();
				System.out.print("Introduzca la hora (HH:mm:ss) para la que quiere consultar la reserva: ");
				String hour = teclado.nextLine();
				String date = dia + "-" + mes + "-" + año + " " + hour;
				System.out.print("Introduzca la duracion (min) para la que quiere consultar la reserva: ");
				String min = teclado.nextLine();
				System.out.println("Introduzca el nombre de la pista para el que quiere listar las reservas: ");
				String pista=teclado.nextLine();
				ReservaDAO.CompruebaFechaReserva(SystemManager.StringToDateSQL(date), Integer.parseInt(min), pista);
			}break;
			case 0:	//Salir
				opcion = 0;
			break;
	    }
	}
}
