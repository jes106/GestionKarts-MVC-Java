package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.KartDAO;
import data.dao.PistaDAO;

/**
 * Servlet implementation class PostModifyTrack
 */
@WebServlet("/PostModifyTrack")
public class PostModifyTrack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostModifyTrack() {
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
		String track = request.getParameter("Nombre");
		String state = request.getParameter("Estado");
		response.setContentType("text/html");
		
		PistaDAO.ModifyStateTrack(track, state);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
