package servlets.clientservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.ReservaDAO;

/**
 * Servlet implementation class PostEliminarReservas
 */
@WebServlet("/PostEliminarReservas")
public class PostEliminarReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostEliminarReservas() {
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
		String data[] = request.getParameter("ID").split(" ------- ");
		int id = Integer.parseInt(data[0]);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		
		if(ReservaDAO.compruebaReservaBono(id) == true) {
			int idBono = ReservaDAO.getIdBonoReserva(id);
			ReservaDAO.eliminarReserva(id);
			ReservaDAO.DeleteSessionBono(idBono);
			
			if(ReservaDAO.getSessionBono(idBono) == 0) {
				ReservaDAO.deleteBono(idBono);
			}
		}else {
			ReservaDAO.eliminarReserva(id);
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
