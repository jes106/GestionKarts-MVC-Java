package data.common.reservationfactory;

import data.common.reservationtypes.*;

/***
 * The abstract factory for reservations
 * @author Jesús Escribano Serena
 *
 */
public abstract class ReservationAbstractFactory {
	/***
	 * Abstract function to create a child reservation
	 * @param child A child reservation
	 * @return a child reservation
	 */
	public abstract ChildReservation createChildReservation(ChildReservation child);
	
	/***
	 * Abstract function to create an adult reservation
	 * @param adult An adult reservation
	 * @return the adult reservation
	 */
	public abstract AdultsReservation createAdultsReservation(AdultsReservation adult);
	
	/***
	 * Abstract function to create a familiar reservation
	 * @param fam A familiar reservation
	 * @return the familiar reservation
	 */
	public abstract FamiliarReservation createFamiliarReservation(FamiliarReservation fam);
	

}
