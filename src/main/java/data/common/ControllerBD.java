package data.common;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="conexBD", urlPatterns="/conexBD")
public class ControllerBD extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static String dbURL;
	static String dbUsername;
	static String dbPassword;
	public void init() throws ServletException{

		ServletConfig config = getServletConfig();
	    dbURL=config.getInitParameter("dbURL");
	    dbUsername=config.getInitParameter("dbUsername");
	    dbPassword=config.getInitParameter("dbPassword");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println (dbURL);
		out.println (dbUsername);

	}
	
	
	

}
