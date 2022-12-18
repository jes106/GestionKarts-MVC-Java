package servlets.clientservlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String track = request.getParameter("Pista");
		int lenght = Integer.parseInt(request.getParameter("Duracion"));
		int child = Integer.parseInt(request.getParameter("Child"));
		int adult = Integer.parseInt(request.getParameter("Adult"));
		
		
	}

}
