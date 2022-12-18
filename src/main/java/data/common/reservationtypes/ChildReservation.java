package data.common.reservationtypes;

import java.sql.Timestamp;

import business.ReservaDTO;

/***
 * A class that represents a Child reservation
 * @author Jesús Escribano Serena
 *
 */
public class ChildReservation extends ReservaDTO{
	
	private int childrenNumber;
	private int bonusNumber;
	
	/***
	 * Constructor for child reservations without bonus
	 * @param correo the mail of the user that makes the reservation
	 * @param date the date of the reservation
	 * @param lenght the length of the reservation
	 * @param niños the number of children in the reservation
	 */
	public ChildReservation(String correo, Timestamp date, int lenght, int niños) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		childrenNumber=niños;
		
	}
	
	/***
	 * Constructor with bonus
	 * @param correo the mail of the adult that makes the reservation
	 * @param date the date of the reservation
	 * @param lenght the length of the reservation
	 * @param niños the number of children
	 * @param bonus the number of the bonus
	 */
	public ChildReservation(String correo, Timestamp date, int lenght, int niños, int bonus) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		childrenNumber=niños;
		bonusNumber=bonus;
		//sessionNumber=session;
		
	}
	
	/**
	 * 
	 * @return the number of children
	 */
	public int getchildrenNumber() {
		return childrenNumber;
	}
	
	/**
	 * Change the children number in a reservation
	 * @param newnumber the new number of children
	 */
	public void setchildrenNumber(int newnumber) {
		childrenNumber=newnumber;
	}
	
	/**
	 * 
	 * @return the bonus number
	 */
	public int getbonusNumber() {
		return bonusNumber;
	}
	
	/**
	 * Change the bonus number in a reservation
	 * @param newnumber the new bonus number
	 */ 
	public void setbonusNumber(int newnumber) {
		bonusNumber=newnumber;
	}
}
