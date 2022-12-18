package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.PistaDAO;

/**
 * Servlet implementation class PostAsociarKartPista
 */
@WebServlet("/PostAsociarKartPista")
public class PostAsociarKartPista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher disp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAsociarKartPista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rol=(String) request.getParameter("rol");
		if(rol==null) {
			disp = request.getRequestDispatcher("/mvc/views/ERROR.jsp");
			disp.forward(request, response);
		}
		else if(rol.equals("Administrador")){
			disp = request.getRequestDispatcher("/mvc/views/SelectTypeView.jsp");
			disp.include(request, response);
		}
		else {
			disp = request.getRequestDispatcher("/mvc/views/error.jsp");
			disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String track = request.getParameter("Nombre");
		int kart = Integer.parseInt(request.getParameter("ID"));
		response.setContentType("text/html");
		
		PistaDAO.asociarKartAPistaDisponible(kart, track);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);		
	}

}
