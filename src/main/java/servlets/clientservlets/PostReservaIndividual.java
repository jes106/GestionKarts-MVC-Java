package servlets.clientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ReservaMgr;
import data.common.Dificultad;
import data.common.SystemManager;

/**
 * Servlet implementation class PostReservaIndividual
 */
@WebServlet("/PostReservaIndividual")
public class PostReservaIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReservaIndividual() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		String type = request.getParameter("Tipo");
		Timestamp date = SystemManager.StringToDateSQL2(request.getParameter("Date") + " " + request.getParameter("Time") + ":00");
		String track = request.getParameter("Nombre");
		int lenght = Integer.parseInt(request.getParameter("Duracion"));
		boolean bono = Boolean.parseBoolean(request.getParameter("Bono"));
			// True -> Reserva bono (buscar el id)
			// False -> Reserva individual
		int child = 0, adult = 0;
		
		if(request.getParameter("Child") != null) { child = Integer.parseInt(request.getParameter("Child")); }
		if(request.getParameter("Adult") != null) { adult = Integer.parseInt(request.getParameter("Adult")); }
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(track);
		
		
		if(bono == false) {
			if(type.equals("Infantil")) {
				ReservaMgr.addReservaChild(email, date, lenght, track, Dificultad.infantil, child, -1);
			}else if(type.equals("Familiar")) {
				ReservaMgr.addReservaFam(email, date, lenght, track, Dificultad.familiar, child, adult, -1);
			}else if(type.equals("Adultos")) {
				ReservaMgr.addReservaAdult(email, date, lenght, track, Dificultad.adultos, adult, -1);
			}
		}
		
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
