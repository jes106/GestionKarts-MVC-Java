package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.KartDTO;
import data.dao.KartDAO;

/**
 * Servlet implementation class KartListServelt
 */
@WebServlet("/KartListServelt")
public class KartListServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KartListServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<KartDTO> karts = KartDAO.kartListNoAssociated();		
		request.setAttribute("karts", karts);
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}
}
