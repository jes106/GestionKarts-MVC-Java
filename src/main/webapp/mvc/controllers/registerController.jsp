<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="User" scope="session" class="display.javabean.NewCustomerBean"></jsp:useBean>
<%@ page import="business.UsuarioDTO" %>
<%@ page import="data.common.SystemManager" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="data.dao.UsuarioDAO" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%
		String nextPage = "../views/RegisterView.jsp";
		String nextPageMessage = null;
		
		String name = request.getParameter("name");
		
		String Sday = request.getParameter("day");
		int day = Integer.parseInt(Sday);
		
		String Smonth = request.getParameter("month");
		int month = Integer.parseInt(Smonth);
		
		String Syear = request.getParameter("year");
		int year = Integer.parseInt(Syear);
		
		String email = request.getParameter("email");
		String rol = request.getParameter("rol");
	
		String date = day + "-" + month + "-" + year + " " + 00 + ":" + 00 + ":" + 00;		
	
		
		if(UsuarioDAO.altaUsuario(new UsuarioDTO(name, SystemManager.StringToDateSQL(date), email, rol)) == true) {
			nextPage = "../../index.jsp";
			nextPageMessage = "";
		

		} else if(email != null) { 
			nextPageMessage = "error";
	%>
	
	<%
		} else {
	%>
	<jsp:setProperty property="email" value="" name="User"/>
	<%
		}
	%>
	
</body>
</html>
<%
	if(email != null) {
%>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
</jsp:forward>
<%
	} else {
%>
<jsp:forward page="<%=nextPage%>" />
<% 
	}
%>