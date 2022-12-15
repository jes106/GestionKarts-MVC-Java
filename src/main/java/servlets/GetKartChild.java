package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.KartDTO;
import data.dao.KartDAO;

/**
 * Servlet implementation class GetKartChild
 */
@WebServlet("/GetKartChild")
public class GetKartChild extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetKartChild() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> karts = KartDAO.kartListNoAssociatedChild();		
		request.setAttribute("ID", karts);
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}
}
