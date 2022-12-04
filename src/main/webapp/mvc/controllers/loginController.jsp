<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@ page import="business.UsuarioDTO" %>
<%@ page import="data.dao.UsuarioDAO" %>
<%@ page import="data.common.SystemManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loading...</title>
</head>
<body>
	<%
		String nextPage = "../views/LoginView.jsp";
		String nextPageMessage = null;
		
		String email = request.getParameter("email");
		String rol = request.getParameter("rol");
	
		if(UsuarioDAO.comprobarEsxistenciaUsuario(email) == true) {
			nextPage = "../../index.jsp";
			nextPageMessage = "";
	%>
	<jsp:setProperty property="mail" value="<%=email	%>" name="User"/>
	<%
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