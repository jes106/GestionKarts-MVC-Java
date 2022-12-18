<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Indica el tipo</title>
<link href="/Práctica3/mvc/views/formStyles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		if(request.getParameter("error") != null) {
	%>
	<div class="animation">
	<div class="error"><%= request.getParameter("error") %></div>
	</div>
	<%
		}
	%>
	
	<div class="note-form">
	<form method="post" action="">
		<div class="field">
			<label for="Tipo">Selecciona el tipo: </label>
			<select onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
				<option value="/Práctica3/mvc/views/SelectTypeView.jsp">Tipo</option>
				<option value="/Práctica3/mvc/views/AsociateAdultKartPistaView.jsp">Adulto</option>
				<option value="/Práctica3/mvc/views/AsociateChildKartPistaView.jsp">Infantil</option>
			</select>
		</div>
	</form>
	</div>
</body>
</html>