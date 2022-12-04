package data.common.reservationtypes;

import java.sql.Timestamp;

import business.ReservaDTO;

public class ChildReservation extends ReservaDTO{
	
	private int childrenNumber;
	private int bonusNumber;
	
	public ChildReservation(String correo, Timestamp date, int lenght, int niños) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		childrenNumber=niños;
		
	}
	
	public ChildReservation(String correo, Timestamp date, int lenght, int niños, int bonus) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		childrenNumber=niños;
		bonusNumber=bonus;
		//sessionNumber=session;
		
	}
	
	public int getchildrenNumber() {
		return childrenNumber;
	}
	
	public void setchildrenNumber(int newnumber) {
		childrenNumber=newnumber;
	}
	
	public int getbonusNumber() {
		return bonusNumber;
	}
	
	public void setbonusNumber(int newnumber) {
		bonusNumber=newnumber;
	}
}
