<%@page import="modelo.Tm_Pro_Product"%>
<%@page import="modelo.Tm_Cem_Customer_Employee"%>
<%@page import="modelo.Tm_Ode_Order_Detail"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="modelo.Tm_Cus_Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Cestaticket Services C.A. - Pedidos 123</title>
<link rel="stylesheet" href="estilo.css" type="text/css">
<script language='javascript' src="popcalendar1.js"></script> 
<script>
 
function mostrardiv(name) { 
div = document.getElementById(name);
div.style.height= "350px";
div.style.display = ''; 
}
 
function cerrardiv(name) { 
div = document.getElementById(name); 
div.style.display='none'; 
}
 


</script>
</head>
<body>
	<%@ include file = "encabezado.jsp" %>
	<%
		Tm_Cus_Customer cus = (Tm_Cus_Customer) request.getAttribute("cus");
		if (cus == null)
			cus = new Tm_Cus_Customer();
		
	%>
	<h2>Paso 2: Datos del Pedido</h2>
	<br/>
	<div id="datos">	
		<h3>Datos del Cliente</h3>	                
		<table>
		<tr>
			<th align = "left">Rif:</th>
			<td><%=cus.getCus_rif() %></td>
		    <th align = "left">Razón Social:</th>
			<td><%= cus.getCus_name() %></td>
		</tr>
		<tr>
			<th align = "left">Telófono:</th>
			<td><%= cus.getCus_phone() %></td>
			<th align = "left">Persona de Contacto:</th>
			<td><%= cus.getCus_contact()%></td>
		</tr>
		<tr>
			<th align = "left">Dirección:</th>
			<td colspan = "3"><%= cus.getCus_address() %></td>
			
		</tr>
		</table>
		<h3>Datos del Pedido</h3>	 
		               
		<table>
			<tr>
				<th>Producto: </th>
				<td><select name = "producto">
					<option value = "0">Seleccione...</option>
					<%	Tm_Pro_Product p = null;
						Vector<Tm_Pro_Product> prods = new Tm_Pro_Product().findAll();
						Iterator it = prods.iterator();
						while (it.hasNext())
						{	p = (Tm_Pro_Product) it.next();
							out.print("<option value = '" + p.getPro_code() + "'>" + p.getPro_name() + "</option>");
						}
					%>
				
				</select></td>
				<th>Fecha de Entrega: </th>
				<td><form name = "form1" method = "post"><input name="fecha" type="text" id="dateArrival" onClick="popUpCalendar(this, form1.dateArrival, 'dd-mm-yyyy');" size="10"/></form></td>
			</tr>
		</table>
		
		<div  id='botones' style = 'height:250px'>
			<br/>
			<h3>Seleccione la opción de su preferencia:</h3><br/>
			<input type = "button" value = "Cargar Pedido Manual" onClick = "cerrardiv('botones');cerrardiv('archivo');mostrardiv('manual')"/><br/>
			<input type = "button" value = "Cargar Archivo de Pedido" onClick = "cerrardiv('botones');cerrardiv('manual');mostrardiv('archivo')"/>
		</div>
		<div id='manual' style="display:none">
			<br/>
			<h3>Detalles del Pedido</h3>
			
			<iframe name = "tabla" src = "tabla.jsp" height = "250px" width = "500px" ></iframe>
			
			<br/>
			<input type = "button" value = "Cerrar" onclick = "cerrardiv('manual');mostrardiv('botones');"/>
		</div>	
		<div id='archivo' style="display:none">
			<br/>
			<h3>Seleccione el archivo a cargar:</h3><br/>
			<input type = "file" name = "archivo" size = "50" /><br/>
			<input type = "button" value = "Cerrar" onclick = "cerrardiv('archivo');mostrardiv('botones');"/>
		</div>	
		<table>
		<tr>
			<td colspan = "2" align = "center">
				<br/>
				<input type = "button" value = "Atras: Paso 1 Datos del Cliente" onclick = "location.href = 'paso1.jsp'" />
				<input type = "button" value = "Paso 3: Visualización de Resultados" />
				<input type = "button" value = "Cancelar" onclick = "location.href = 'index.jsp'" />
			</td> 
		</tr>
		
	</table>
	</div>
	<hr/>
	
	
	<br/>
	<br/>
	<br/>
	<br/>
	<%@ include file = "pie.jsp" %>
	
</body>
</html>