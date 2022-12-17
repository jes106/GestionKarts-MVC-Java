package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.KartMgr;
import data.common.EstadoKart;

@WebServlet(name="crearKart", urlPatterns="/crearkart")
public class CrearKart extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	RequestDispatcher disp;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String rol = (String) request.getAttribute("rol");
		if(rol.equals("Administrador")) {
			disp = request.getRequestDispatcher("/mvc/altaKartView.jsp");
			disp.include(request, response);
		}
		else {
			disp = request.getRequestDispatcher("error");
			disp.forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int estado = (int) request.getAttribute("Estado");
		boolean finish=false;
		if(estado==0) {
			finish=KartMgr.addKart(5, false, EstadoKart.Disponible);
			
		}
		else if(estado==1){
			finish=KartMgr.addKart(5, true, EstadoKart.Disponible);
		}
		
		if(finish==true) {
			disp = request.getRequestDispatcher("/index.jsp");
			disp.forward(request, response);
		}
		else {
			disp = request.getRequestDispatcher("error");
			disp.forward(request, response);
		}
	}

}
