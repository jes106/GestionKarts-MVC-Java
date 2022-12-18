package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.KartMgr;
import data.common.EstadoKart;

@WebServlet(name="ManejadorModifyTrack", urlPatterns="/ManejadorModifyTrack")
public class ManejadorModifyTrack extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	RequestDispatcher disp;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String rol = (String) request.getParameter("rol");
		if(rol==null) {
			disp = request.getRequestDispatcher("/mvc/views/Error/ErrorView.jsp");
			disp.forward(request, response);
		}
		else if(rol.equals("Administrador")) {
			disp = request.getRequestDispatcher("/mvc/views/ModifyTrackView.jsp");
			disp.forward(request, response);
		}
		else {
			disp = request.getRequestDispatcher("/mvc/views/Error/ErrorView.jsp");
			disp.forward(request, response);
		}

	}
	
}