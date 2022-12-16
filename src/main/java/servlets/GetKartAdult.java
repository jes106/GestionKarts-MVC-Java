package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.KartDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Servlet implementation class GetKartAdult
 */
public class GetKartAdult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetKartAdult() {
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> karts = KartDAO.kartListNoAssociated(1);		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Iterator<Integer> iterator = karts.iterator();
        while (iterator.hasNext()) {
            out.print(iterator.next());
            if (iterator.hasNext()) {
                out.print(",");
            }
        }

        // Cerrar el PrintWriter
        out.close();
	}

}
