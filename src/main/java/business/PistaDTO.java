package business;

import data.common.Dificultad;


/**
* A class to represent a pista
* @author Juan José Trenado zafra
* @version 06/10/2022
*/

public class PistaDTO {
	
	/**
   * Attributes
   */
	private String NombrePista;
	private boolean EstadoPista;
	private Dificultad Dificultad;
	private int MaxKarts;
	
	/**
   * Constructor without parameters
   */
	public PistaDTO() {

  }
	
	/**
	 * Constructor with parameters
	 * @param NombrePista The name of the pista
	 * @param EstadoPista The state of the pista (disponible o mantenimiento)
	 * @param Dificultad The dificulty of the pista
	 * @param MaxKarts maximun karts that can play on the pista
	 * @param Karts list of karts asociated to the pista
	 */
	public PistaDTO( String nombrePista, boolean estadoPista, Dificultad dificultad, int maxKarts) {
		this.NombrePista = nombrePista;
		this.EstadoPista = estadoPista;
		this.Dificultad = dificultad;
		this.MaxKarts = maxKarts;
	}
	
	
	/* Getters and setters */
	/**
   * @return the name of the pista
   */
	public String getNombrePista() {
		return NombrePista;
	}
	/**
   * set the name of the pista
   */
	public void setNombrePista(String nombrePista) {
		this.NombrePista = nombrePista;
	}
	/**
   * @return the state of the pista
   */
  public Boolean getEstadoPista() {
		return EstadoPista;
	}
	/**
   * set the name of the pista
   */
	public void setEstadoPista(Boolean estadoPista) {
		this.EstadoPista = estadoPista;
	}
	/**
   * @return the dificulty of the pista
   */
	public Dificultad getDificultad() {
		return Dificultad;
	}
	/**
   * set the name of the pista
   */
	public void setDificultad(Dificultad dificultad) {
		this.Dificultad = dificultad;
	}
	/**
   * @return maximun karts that can play on the pista
   */
  public int getMaxKarts() {
		return MaxKarts;
	}
	/**
   * set maximun karts that can play on the pista
   */
	public void setMaxKarts(int maxKarts) {
		this.MaxKarts = maxKarts;
	}

	/* Other methods */
	/**
   * @return all information of the pista by string
   */
	@Override
	public String toString() {
		return "NombrePista: " + NombrePista + "\tEstadoPista: " + EstadoPista + "\tDificultad: " + Dificultad + "\tMaxximo de Karts: " + MaxKarts;
	}

}
