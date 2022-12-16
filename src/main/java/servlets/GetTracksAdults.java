package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.PistaDAO;

/**
 * Servlet implementation class GetTracksAdults
 */
@WebServlet("/GetTracksAdults")
public class GetTracksAdults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTracksAdults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> tracks = PistaDAO.trackList(0);		
		request.setAttribute("Nombre", tracks);
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}
}