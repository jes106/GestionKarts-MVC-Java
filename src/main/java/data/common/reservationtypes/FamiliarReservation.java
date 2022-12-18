package data.common.reservationtypes;

import java.sql.Timestamp;
import business.ReservaDTO;

/***
 * A class that represent a Familiar reservation
 * @author Jesús Escribano Serena
 *
 */
public class FamiliarReservation extends ReservaDTO{
	
	private int childrenNumber;
	private int adultsNumber;
	private int bonusNumber;
	
	/***
	 * Constructor for familiar reservation without bonus
	 * @param correo the email of the user that makes the reservation
	 * @param date the date of the reservation
	 * @param lenght the length of the reservation
	 * @param adultos the number of adults in the reservation
	 * @param niños the number of children in the reservation
	 */
	public FamiliarReservation(String correo, Timestamp date, int lenght, int adultos, int niños) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		adultsNumber=adultos;
		childrenNumber=niños;
		
	}
	
	/***
	 * Constructor for familiar reservation with bonus
	 * @param correo the email of the user that makes the reservation
	 * @param date the date of the reservation
	 * @param lenght the length of the reservation
	 * @param adultos the number of adults in the reservation
	 * @param niños the number of children in the reservation
	 * @param bonus the number of the bonus
	 */
	
	public FamiliarReservation(String correo, Timestamp date, int lenght, int adultos, int niños, int bonus) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		adultsNumber=adultos;
		childrenNumber=niños;
		bonusNumber=bonus;
		
	}
	
	/**
	 * 
	 * @return the number of children
	 */
	public int getchildrenNumber() {
		return childrenNumber;
	}
	
	/**
	 * Change the number of children
	 * @param newnumber the new number of children
	 */
	public void setchildrenNumber(int newnumber) {
		childrenNumber=newnumber;
	}
	
	/***
	 * 
	 * @return the number of adults
	 */
	public int getadultsNumber() {
		return adultsNumber;
	}
	
	/***
	 * Change the number of adults
	 * @param newnumber the new number of adults
	 */
	public void setadultsNumber(int newnumber) {
		adultsNumber=newnumber;
	}
	
	/***
	 * 
	 * @return the number of the bonus
	 */
	public int getbonusNumber() {
		return bonusNumber;
	}
	
	/***
	 * Change the number of the bonus
	 * @param newnumber the new number of the bonus
	 */
	public void setbonusNumber(int newnumber) {
		bonusNumber=newnumber;
	}
}
