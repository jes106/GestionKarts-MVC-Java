package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.common.SystemManager;
import data.dao.ReservaDAO;

/**
 * Servlet implementation class GetCancelarReserva
 */
@WebServlet("/GetCancelarReserva")
public class GetCancelarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCancelarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		Timestamp date = SystemManager.StringToDateSQL2(request.getParameter("date") + " " + request.getParameter("time") + ":00");
		String track = request.getParameter("Pista");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(date.before(SystemManager.SumaRestaFecha(new Timestamp(new java.util.Date().getTime()), 86400, "s"))) {
			ReservaDAO.cancelarReserva(email, date, track);
		}else {
			out.println("La reserva no se puede cancelar con menos de 24 horas de antelacion");
		}
	}

}
