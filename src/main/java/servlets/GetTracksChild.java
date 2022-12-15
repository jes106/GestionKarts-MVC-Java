package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.KartDAO;
import data.dao.PistaDAO;

/**
 * Servlet implementation class GetTracksChild
 */
@WebServlet("/GetTracksChild")
public class GetTracksChild extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTracksChild() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> tracks = PistaDAO.trackList(1);		
		request.setAttribute("Nombre", tracks);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(tracks);
	}
}
