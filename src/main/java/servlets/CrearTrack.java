package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.PistaMgr;
import data.common.Dificultad;

@WebServlet(name="crearTrack", urlPatterns="/creartrack")
public class CrearTrack extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	RequestDispatcher disp;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String rol = (String) request.getParameter("rol");
		
		if(rol==null) {
			disp = request.getRequestDispatcher("/mvc/views/Error/ErrorView.jsp");
			disp.forward(request, response);
		}
		else if(rol.equals("Administrador")) {
			disp = request.getRequestDispatcher("/mvc/views/altaPistaView.jsp");
			disp.forward(request, response);
		}
		else {
			disp = request.getRequestDispatcher("/mvc/views/Error/ErrorView.jsp");
			disp.forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String nombre = (String) request.getParameter("Nombre");
		String estado = (String) request.getParameter("Estado");
		String tipo = (String) request.getParameter("Tipo");
		int max= Integer.parseInt(request.getParameter("Max"));
		Boolean state=false;
		Dificultad dificultad=null;
		if(estado.equals("Disponible")) {
			state=true;
		}
		else if(estado.equals("Mantenimiento")) {
			state=false;
		}
		
		if(tipo.equals("Infantil")) {
			dificultad=Dificultad.infantil;
			
		}
		else if(tipo.equals("Adultos")) {
			dificultad=Dificultad.adultos;
		}
		else if(tipo.equals("Familiar")) {
			dificultad=Dificultad.familiar;
		}
		
		
		if(PistaMgr.addTrack(nombre, state, dificultad, max)==true) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<br><h2>Pista creada correctamente</h2>");
			disp = request.getRequestDispatcher("/index.jsp");
			disp.include(request, response);
		}
		else {
			disp = request.getRequestDispatcher("error");
			disp.forward(request, response);
		}
	}

}