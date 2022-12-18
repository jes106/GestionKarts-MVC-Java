package data.common.reservationfactory;

import data.dao.ReservaDAO;
import data.common.reservationtypes.*;

/***
 * The reservation factory for individual reservation
 * @author Jesús Escribano Serena
 *
 */
public class ConcreteIndividualReservationFactory extends ReservationAbstractFactory{

	/***
	 * Function to create an individual child reservation
	 */
	@Override
	public ChildReservation createChildReservation(ChildReservation child){
		ReservaDAO reservaDAO = new ReservaDAO();
		if(child.getbonusNumber() != -1) {
			child.setDescuento(reservaDAO.calcularDescuento(child.getEmail(), true));
			child.setPrecio(reservaDAO.calcularPrecio(child.getDuracion(), child.getDescuento()));
		}
		else {
			child.setDescuento(reservaDAO.calcularDescuento(child.getEmail(), false));
			child.setPrecio(reservaDAO.calcularPrecio(child.getDuracion(), child.getDescuento()));
		}
		return child;
	}

	/***
	 * Function to create an individual adults reservation
	 */
	@Override
	public AdultsReservation createAdultsReservation(AdultsReservation adult){
		ReservaDAO reservaDAO = new ReservaDAO();
		if(adult.getbonusNumber() != -1) {
			adult.setDescuento(reservaDAO.calcularDescuento(adult.getEmail(), true));
			adult.setPrecio(reservaDAO.calcularPrecio(adult.getDuracion(), adult.getDescuento()));
		}
		else {
			adult.setDescuento(reservaDAO.calcularDescuento(adult.getEmail(), false));
			adult.setPrecio(reservaDAO.calcularPrecio(adult.getDuracion(), adult.getDescuento()));
		}
		return adult;
	}

	/***
	 * Function to create an individual familiar reservation
	 */
	@Override
	public FamiliarReservation createFamiliarReservation(FamiliarReservation fam){
		
		ReservaDAO reservaDAO = new ReservaDAO();
		if(fam.getbonusNumber() != -1) {
			fam.setDescuento(reservaDAO.calcularDescuento(fam.getEmail(), true));
			fam.setPrecio(reservaDAO.calcularPrecio(fam.getDuracion(), fam.getDescuento()));
		}
		else {
			fam.setDescuento(reservaDAO.calcularDescuento(fam.getEmail(), false));
			fam.setPrecio(reservaDAO.calcularPrecio(fam.getDuracion(), fam.getDescuento()));
		}
		return fam;
	}
	
	

}
