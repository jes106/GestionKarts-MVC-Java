package business;

import java.sql.Timestamp;

import data.dao.ReservaDAO;
import data.common.reservationfactory.*;
import data.common.reservationtypes.*;
import data.common.Dificultad;

public class ReservaMgr {

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
