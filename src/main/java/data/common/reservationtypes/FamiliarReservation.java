package data.common.reservationtypes;

import java.sql.Timestamp;
import business.ReservaDTO;

public class FamiliarReservation extends ReservaDTO{
	
	private int childrenNumber;
	private int adultsNumber;
	private int bonusNumber;
	
	public FamiliarReservation(String correo, Timestamp date, int lenght, int adultos, int niños) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		adultsNumber=adultos;
		childrenNumber=niños;
		
	}
	
	public FamiliarReservation(String correo, Timestamp date, int lenght, int adultos, int niños, int bonus) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		adultsNumber=adultos;
		childrenNumber=niños;
		bonusNumber=bonus;
		
	}
	
	public int getchildrenNumber() {
		return childrenNumber;
	}
	
	public void setchildrenNumber(int newnumber) {
		childrenNumber=newnumber;
	}
	
	public int getadultsNumber() {
		return adultsNumber;
	}
	
	public void setadultsNumber(int newnumber) {
		adultsNumber=newnumber;
	}
	
	public int getbonusNumber() {
		return bonusNumber;
	}
	
	public void setbonusNumber(int newnumber) {
		bonusNumber=newnumber;
	}
}
