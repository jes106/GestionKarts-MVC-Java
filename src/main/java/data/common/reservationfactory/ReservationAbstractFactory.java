package data.common.reservationfactory;

import data.common.reservationtypes.*;

public abstract class ReservationAbstractFactory {
	
	public abstract ChildReservation createChildReservation(ChildReservation child);
	public abstract AdultsReservation createAdultsReservation(AdultsReservation adult);
	public abstract FamiliarReservation createFamiliarReservation(FamiliarReservation fam);
	

}
