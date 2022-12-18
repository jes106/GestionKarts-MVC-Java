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
 * Servlet implementation class GetTieneBono
 */
@WebServlet("/GetTieneBono")
public class GetTieneBono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTieneBono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		String type = request.getParameter("Tipo").toLowerCase();
		
		boolean bool = ReservaDAO.CompruebaBono(email, type);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(bool == true) { out.println("true"); }
		else { out.println("false"); }
	}
}
