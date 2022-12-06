<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="usuario" class="display.javabean.CustomerBean" scope="session"/>
<%@ page import="java.util.concurrent.TimeUnit" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Desconectando</title>
<link href="/Práctica3/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
String nextPage = "../../index.jsp"; 
usuario.setUsuario(null);
usuario.setRol(null);
%>
	
<jsp:forward page="<%=nextPage%>" />
</body>
</html>