package data.common.reservationtypes;

import java.sql.Timestamp;

import business.ReservaDTO;

public class AdultsReservation extends ReservaDTO{
	
	private int adultsNumber;
	private int bonusNumber;
	
	public AdultsReservation(String correo, Timestamp date, int lenght, int adultos) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		adultsNumber=adultos;
		
	}
	
	public AdultsReservation(String correo, Timestamp date, int lenght, int adultos, int bonus) {
		
		email=correo;
		fecha=date;
		duracion=lenght;
		adultsNumber=adultos;
		bonusNumber=bonus;
		
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
