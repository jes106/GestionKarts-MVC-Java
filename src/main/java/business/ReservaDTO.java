package business;

import java.sql.Timestamp;

import data.common.Dificultad;



/**
* A class to represent a Reserva
* @author Antonio Diaz Barbancho 
* @version 09/10/2022
*/

public abstract class ReservaDTO {
	
	/* Atrubutes */
		
	
	protected String email;
	protected Timestamp fecha;
	protected int duracion;
	protected float precio;
	protected float descuento;
	protected String pista;
	protected Dificultad trackType;
	
	
	/**
   * Constructor without parameters
   */
	
	public ReservaDTO()
	{
	}
	
	
	/* Getters y Setters for all the variables */
	
	
	/**
   * @return the email of the user
   */
	
	public String getEmail()
	{
		return email;
	}
	
	/**
   * @return the date of Reserva
   */
	
	public Timestamp getFecha()
	{
		return fecha;
	}
	
	
	/**
   * @return the duration of Reserva
   */
	
	public int getDuracion()
	{
		return duracion;
	}
	
	/**
   * @return the name of the pista
   */
	
	public String getPista()
	{
		return pista;
	}
	
	/**
   * @return the price of Reserva
   */
	
	public float getPrecio()
	{
		return precio;
	}
	
	
	/**
   * @return the discount
   */
	
	public float getDescuento()
	{
		return descuento;
	}
	
	
	/**
   * @return the number of the bond
   */
	
	
	/**
   * @return the Dificultad of Pista
   */
	
	public Dificultad getType() {
		return trackType;
	}
	
	
	/**
   * set the email
   */
	
	public void setEmail(String newemail)
	{
		email = newemail;
	}
	
	
	/**
   * set the date 
   @param newfecha new date 
   */
	
	public void setFecha(Timestamp newfecha )
	{
		fecha = newfecha;
	}
	
	/**
   * set the duration
   @param newduracion new duration
   */
	
	public void setDuracio(int newduracion)
	{
		duracion = newduracion;
	}
	
	/**
   * set the price
   @param newprecio new price
   */
	
	public void setPrecio(float newprecio)
	{
		precio = newprecio;
	}
	
	/**
   * set the discount
   @param newdescuento new discount
   */
	
	public void setDescuento(float newdescuento)
	{
		descuento = newdescuento;
	}
	
	
	/**
   * set the Dificultad
   @param tipo new tipo 
   */
	
	public void setType(Dificultad tipo) {
		trackType = tipo;
	}
	
	/**
	 * Method for print information of the class Reserva
   * @return the information of the Reserva
   */
	public String toString() 
	{
		return "Datos de la reserva:\n"+"ID usuario: "+email+" "+"Fecha de reserva: "+fecha+" "+"Duracion de la reserva: "+duracion+" "+
	"Pista: "+pista+" "+"Precio total de la reserva: "+precio+" "+"Descuento: "+descuento;
	}

	/**
   * set the Pista
   @param pista2 new pista 
   */
	
	public void setPista(String pista2) {
		pista = pista2;
	}
}
