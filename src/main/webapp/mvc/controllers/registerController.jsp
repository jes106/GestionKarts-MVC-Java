<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="User" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@ page import="business.UsuarioDTO" %>
<%@ page import="data.common.SystemManager" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="data.dao.UsuarioDAO" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>



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
		String date = request.getParameter("date");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");
	
		String fechaFormateada = date + " 00:00:00";		
		if(fechaFormateada != null){
			if(UsuarioDAO.altaUsuario(new UsuarioDTO(name, password, SystemManager.StringToDateSQL(fechaFormateada), email, rol)) == true) {
				nextPage = "../../index.jsp";
				nextPageMessage = "";
			}else if(email != null) { 
			nextPageMessage = "error";
			}else{
				%>
				<jsp:setProperty property="email" value="" name="User"/>
				<%
			}
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