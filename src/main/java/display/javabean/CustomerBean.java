package display.javabean;

import data.dao.UsuarioDAO;

public class CustomerBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String user;
	private String rol;
	
	public CustomerBean() {
		
	}
	
	public Boolean login(String usuario) {
		
		if(UsuarioDAO.comprobarEsxistenciaUsuario(usuario)==true) {
			user=usuario;
			//rol=userdao.comprobarRol(user);
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public String getUsuario() {
		return user;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setUsuario (String usuario) {
		user=usuario;
	}
	
	public void setRol(String role) {
		rol=role;
	}
	

}
