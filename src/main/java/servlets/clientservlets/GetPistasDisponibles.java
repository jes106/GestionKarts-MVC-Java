
package servlets.clientservlets;

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
import data.dao.PistaDAO;
import data.dao.ReservaDAO;

/**
 * Servlet implementation class GetPistasDisponibles
 */
@WebServlet("/GetPistasDisponibles")
public class GetPistasDisponibles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPistasDisponibles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("Tipo").toLowerCase();
		Timestamp date = SystemManager.StringToDateSQL2(request.getParameter("Date") + " " + request.getParameter("Time") + ":00");
		int min = Integer.parseInt(request.getParameter("Min"));
		
		ArrayList<String> track = PistaDAO.listTrackDisponible(type, min);
		ArrayList<String> track_ = new ArrayList<String>();
		for(String iterator_:track) {
			if(ReservaDAO.CompruebaFechaReserva(date, 120, iterator_) == true) { track_.add(iterator_); }
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Iterator<String> iterator = track_.iterator();
        while (iterator.hasNext()) {
    		out.print(iterator.next());
            if (iterator.hasNext()) {
                out.print(",");
            }            
        }
	}
}
