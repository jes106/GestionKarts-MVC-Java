package business;

import data.common.EstadoKart;

/**
 * A class to represent a kart
 * @author Antonio Diaz Perez
 * @version 07/10/2022
 */

public class KartDTO {
	
	/**
	 * Attributes	
	 */
	private int Id;
	private boolean Child;	// True -> child  ;  False -> adult
	private EstadoKart Estado;
	
	
	/**
	 * Constructor without parameters
	 */
	
	public KartDTO() {
		
	}
	
	/**
	 * Constructor with parameters
	 * @param id_ The id of the kart
	 * @param child_ Indicates whether the kart is intended for children or adults.
	 * @param estado Indicates the status of the kart (Reserved | Available | Maintenance).
	 */
	public KartDTO(int id, boolean child, EstadoKart estado) {
		Id = id;
		Child = child;
		Estado = estado;
	}
	
	
	/* Getters y Setters for all the variables */
	
	/**
	 * Give the id of a car
	 * @return The id of the kart
	 */
	public int getId() {
		return Id;
	}
	
	/**
	 * Set the kart ID
	 * @param id_ Id of the kart to assign
	 */
	public void setId(int id_) {
		Id = id_;
	}
	
	/**
	 * Give you if the kart is for children
	 * @return True if the kart is intended for children, false if for adults.
	 */
	public boolean getChild() {
		return Child;
	}
	
	/**
	 * Sets the type of kart
	 * @param child_ True if the kart is intended for children, false if for adults.
	 */
	public void setChild(boolean child_) {
		Child = child_;
	}
	
	/**	
	 * Give you the status of the kart
	 * @return The status of the kart
	 */
	public EstadoKart getEstado() {
		return Estado;
	}
	
	/**
	 * Sets the kart status
	 * @param Estado_ Kart status
	 */
	public void setEstado(EstadoKart Estado_) {
		Estado = Estado_;
	}
	
	/**
	 * Print kart information
	 * @return Kart information
	 */
	public String toString() {
		String tipo;
		if(Child == true){ tipo = "Child"; }
		else { tipo = "Adult"; }
				
		return "Informacion Kart: \n" + "-------------------------\n" + "Id -> " + Id + "\nTipo -> " + tipo + "\nEstado -> " + Estado;
	}

}
