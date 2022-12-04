package display.javabean;

import java.sql.Timestamp;

import business.UsuarioDTO;
import data.dao.UsuarioDAO;

public class NewCustomerBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Timestamp date;
	private String mail;
	private String rol;
	
	public NewCustomerBean() {
		
	}

	public Boolean AltaUsuario() {
		
		try{
			UsuarioDAO.altaUsuario(new UsuarioDTO(name, date, mail, rol));
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
		
	public void setVariablesRegistro(String nombre, Timestamp fecha, String email, String role) {
		name=nombre;
		date=fecha;
		mail=email;
		rol=role;	
		
	}
}
