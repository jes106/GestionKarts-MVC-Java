package business;

import java.sql.Timestamp;

import data.dao.ReservaDAO;
import data.common.reservationfactory.*;
import data.common.reservationtypes.*;
import data.common.Dificultad;
/***
 * A handler that helps to create reservations
 * @author Antonio Díaz Pérez
 *
 */
public class ReservaMgr {

	/***
	 * A function to add a child reservation
	 * @param mail the email of the adult that made the reservation
	 * @param date the date for the reservation
	 * @param lenght the length of the reservation
	 * @param track the track for the reservation
	 * @param type the type of reservation
	 * @param child the number of children in the reservation
	 * @param idbono the id of the reservation bono
	 * @return
	 */
	public static boolean addReservaChild(String mail, Timestamp date, int lenght, String track, Dificultad type, int child, int idbono) {
		ChildReservation childR = new ChildReservation(mail, date, lenght, child);
		childR.setPista(track);
		childR.setType(type);
		if(idbono != -1){	// Reserva de bono
			childR.setbonusNumber(idbono);
			ConcreteBonusReservationFactory bonusReservation = new ConcreteBonusReservationFactory();
			childR = bonusReservation.createChildReservation(childR);
		}else {
			ConcreteIndividualReservationFactory individualReservation = new ConcreteIndividualReservationFactory();
			childR = individualReservation.createChildReservation(childR);
		}
		
		if(ReservaDAO.CompruebaFechaReserva(date, lenght, track) == true) {
			ReservaDAO.altaReservaChild(childR);
			return true;
		}else { return false; }
	}
	/***
	 * Function to create a new familiar reservation
	 * @param mail the mail of the adults that creates the reservation
	 * @param date the date of the reservation
	 * @param lenght the length of the reservation
	 * @param track the track for the reservation
	 * @param type the type of the reservation (Child, Adults, Familiar)
	 * @param child the number of children
	 * @param adult the number of adults
	 * @param idbono the id of the bono for the reservation
	 * @return
	 */
	public static boolean addReservaFam(String mail, Timestamp date, int lenght, String track, Dificultad type, int child, int adult, int idbono) {
		FamiliarReservation fam = new FamiliarReservation(mail, date, lenght, adult, child);
		fam.setPista(track);
		fam.setType(type);
		if(idbono != -1){	// Reserva de bono
			fam.setbonusNumber(idbono);
			ConcreteBonusReservationFactory bonusReservation = new ConcreteBonusReservationFactory();
			fam = bonusReservation.createFamiliarReservation(fam);
		}else {
			ConcreteIndividualReservationFactory individualReservation = new ConcreteIndividualReservationFactory();
			fam = individualReservation.createFamiliarReservation(fam);
		}
		
		if(ReservaDAO.CompruebaFechaReserva(date, lenght, track) == true) {
			ReservaDAO.altaReservaFamiliar(fam);
			return true;
		}else { return false; }
		
	}
	
	/***
	 * Function to create a new adult reservation
	 * @param mail the mail of the adults that create the reservation
	 * @param date the date for the reservation
	 * @param lenght the length of the reservation
	 * @param track the track that the reservation will be done
	 * @param type the type of reservation (Adults, Familiar, Child)
	 * @param adults the number of adults in the reservation
	 * @param idbono the id of the bono for the reservation
	 * @return
	 */

	public static boolean addReservaAdult(String mail, Timestamp date, int lenght, String track, Dificultad type, int adults, int idbono) {
		AdultsReservation adult = new AdultsReservation(mail, date, lenght, adults);
		adult.setPista(track);
		adult.setType(type);
		if(idbono != -1){	// Reserva de bono
			adult.setbonusNumber(idbono);
			ConcreteBonusReservationFactory bonusReservation = new ConcreteBonusReservationFactory();
			adult = bonusReservation.createAdultsReservation(adult);
		}else {
			ConcreteIndividualReservationFactory individualReservation = new ConcreteIndividualReservationFactory();
			adult = individualReservation.createAdultsReservation(adult);
		}
		
		if(ReservaDAO.CompruebaFechaReserva(date, lenght, track) == true) {
			ReservaDAO.altaReservaAdults(adult);
			return true;
		}else { return false; }
		
	}
}
