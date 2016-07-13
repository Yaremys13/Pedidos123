<%@page import="modelo.Tm_Cus_Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cestaticket Services C.A. - Pedidos 123</title>
<link rel="stylesheet" href="estilo.css" type="text/css">

</head>
<body>
	<%@ include file = "encabezado.jsp" %>
	<%
		Tm_Cus_Customer cus = (Tm_Cus_Customer) request.getAttribute("cus");
		HttpSession sesion = request.getSession();
		
	%>
	<h3>Paso 1: Datos del Cliente</h3>
	<br/>
	<form name = "f1" method = "post" action = "Paso1Servlet">
	<table>
		<tr>
			<th align = "left">Rif:</th>
			<td><input name = "cus_rif" value = "<%= (cus == null)?"":cus.getCus_rif() %>"/></td>
		</tr>
	</table>
	<% 	if (sesion.getAttribute("ban")== null) { %>
			<div style = "visibility:collapse">
	<% 	}
		else { 
			sesion.setAttribute("ban","paso2.jsp");
	%>
			<div style = "visibility:visible">
	<%		
		}			
	%>
	<table>
		<tr>
			<th align = "left">Razón Social:</th>
			<td><input name = "cus_name" size = "50"  /></td>
		</tr>
		<tr>
			<th align = "left">Teléfono:</th>
			<td><input name = "cus_phone"/></td>
		</tr>
		<tr>
			<th align = "left">Dirección:</th>
			<td><textarea name = "cus_address" cols = "50" rows = "5"></textarea></td>
			
		</tr>
		<tr>
			<th align = "left">Persona de Contacto:</th>
			<td><input name = "cus_contact" size = "50"/></td>
		</tr>
		
			
	</table>
	</div>
	<table>
		<tr>
			<td align = "center">
				<br/>
				<input type = "submit" value = "Paso 2: Datos del Pedido" />
				<input type = "button" value = "Cancelar" onclick = "location.href = 'index.jsp'" />
			</td> 
		</tr>	
	</table>
	</form>
	<br/>
	<br/>
	<br/>
	<br/>
	<%@ include file = "pie.jsp" %>
	
</body>
</html>