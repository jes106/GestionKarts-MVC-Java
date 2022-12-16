package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.common.SystemManager;
import data.dao.ReservaDAO;
/**
 * Servlet implementation class GetConsultarReservas
 */
@WebServlet("/GetConsultarReservas")
public class GetConsultarReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetConsultarReservas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		Timestamp inicio = SystemManager.StringToDateSQL2(request.getParameter("StartDate") + " " + request.getParameter("StartTime") + ":00");
		Timestamp fin = SystemManager.StringToDateSQL2(request.getParameter("EndDate") + " " + request.getParameter("EndTime") + ":00");
		
		ArrayList<ArrayList<String>> reservas = ReservaDAO.listarReservaFechas(inicio, fin, email);
		int i = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		while (i < reservas.size()) {
        	Iterator<String> iterator = reservas.get(i).iterator();
        	while(iterator.hasNext()) {
        		out.println(iterator.next() + "," + iterator.next() + "," + iterator.next() + "," + iterator.next() + "," + iterator.next() + "," 
        				+ iterator.next() + "," + iterator.next());
        	}
        	out.println("//");
        	i++;
        }

        out.close();
	}
}
