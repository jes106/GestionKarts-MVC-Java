package data.common.reservationtypes;

import java.sql.Timestamp;

import business.ReservaDTO;

/***
 * The adults reservation type
 * @author Jesús Escribano Serena
 *
 */
public class AdultsReservation extends ReservaDTO{
	
	private int adultsNumber;
	private int bonusNumber;
	
	/***
	 * The constructor for a reservation without bonus
	 * @param correo the email of the user that make the reservation
	 * @param date the date of the reservation
	 * @param lenght the length of the reservation
	 * @param adultos the number of the adults for the reservation
	 */
	public AdultsReservation(String correo, Timestamp date, int lenght, int adultos) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		adultsNumber=adultos;
		
	}
	
	/***
	 * The constructor for a reservation with bonus
	 * @param correo the email of the user that make the reservation (adult)
	 * @param date the date of the reservation
	 * @param lenght the length of the reservation
	 * @param adultos the number of the adults on the reservation
	 * @param bonus the bonus number
	 */
	public AdultsReservation(String correo, Timestamp date, int lenght, int adultos, int bonus) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		adultsNumber=adultos;
		bonusNumber=bonus;
		
	}
	
	/**
	 * 
	 * @return the number of adults
	 */
	public int getadultsNumber() {
		return adultsNumber;
	}
	
	/**
	 * Set the number of adults
	 * @param newnumber the new number of adults
	 */
	public void setadultsNumber(int newnumber) {
		adultsNumber=newnumber;
	}
	
	/**
	 * 
	 * @return the bonus number
	 */
	public int getbonusNumber() {
		return bonusNumber;
	}
	
	/***
	 * Set the bonus number
	 * @param newnumber the new bonus number
	 */
	public void setbonusNumber(int newnumber) {
		bonusNumber=newnumber;
	}
}
