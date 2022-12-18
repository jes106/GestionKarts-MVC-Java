package servlets.clientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.ReservaDAO;

/**
 * Servlet implementation class GetReservasUsuarioModificables
 */
@WebServlet("/GetReservasUsuarioModificables")
public class GetReservasUsuarioModificables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReservasUsuarioModificables() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		
		ArrayList<ArrayList<String>> reservas = ReservaDAO.listReservasModificables(email);
		int i = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		while (i < reservas.size()) {
        	Iterator<String> iterator = reservas.get(i).iterator();
        	while(iterator.hasNext()) {
        		out.println(iterator.next());
        		if(iterator.hasNext()) {
        			out.println("  -  ");
        		}
        	}
        	out.println("//");
        	i++;
        }

        out.close();
	}
}