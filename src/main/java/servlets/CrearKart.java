package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		String rol = (String) request.getParameter("rol");
		if(rol==null) {
			disp = request.getRequestDispatcher("/mvc/views/Error/ErrorView.jsp");
			disp.forward(request, response);
		}
		else if(rol.equals("Administrador")) {
			disp = request.getRequestDispatcher("/mvc/views/altaKartView.jsp");
			disp.forward(request, response);
		}
		else {
			disp = request.getRequestDispatcher("/mvc/views/Error/ErrorView.jsp");
			disp.forward(request, response);
		}

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String estado = (String) request.getParameter("Estado");
		String tipo = (String) request.getParameter("Tipo");
		EstadoKart state=null;
		boolean child=false;
		if(estado.equals("Disponible")) {
			state=EstadoKart.Disponible;
		}
		else if(estado.equals("Mantenimiento")) {
			state=EstadoKart.Mantenimiento;
		}
		else if(estado.equals("Reservado")) {
			state=EstadoKart.Reservado;
		}
		
		if(tipo.equals("Child")) {
			child=true;
		}
		
		
		if(KartMgr.addKart(66, child, state)==true) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<br><h2>Kart creado correctamente</h2>");
			disp = request.getRequestDispatcher("/index.jsp");
			disp.include(request, response);
		}
		else {
			disp = request.getRequestDispatcher("error");
			disp.forward(request, response);
		}
	}

}
