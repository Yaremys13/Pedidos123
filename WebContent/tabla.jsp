<%@page import="java.math.BigDecimal"%>
<%@page import="modelo.Tm_Cem_Customer_Employee"%>
<%@page import="java.util.Vector"%>
<%@page import="modelo.Tm_Ode_Order_Detail"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<form action="tabla.jsp">
	<table border = '1'>
		<tr>
			<th>Nombre</th>
			<th>Cédula de Identidad</th>
			<th>Monto del Beneficio</th>
		</tr>
		<tr>
			<td><input type = 'text' size = '30' name = 'nombre'/> </td>
			<td><input type = 'text' size = '15' name = 'cedula'/></td>
			<td><input type = 'text' size = '15' name = 'monto'/></td>
		</tr>
<%		HttpSession sesion = request.getSession();
		Vector<Tm_Ode_Order_Detail> ben = (Vector<Tm_Ode_Order_Detail>) sesion.getAttribute("ben");
		if (ben == null)
			ben = new Vector<Tm_Ode_Order_Detail>();
		if (request.getParameter("cedula") != null && request.getParameter("nombre") != null && request.getParameter("monto") != null)
		{	Tm_Cem_Customer_Employee cem = new Tm_Cem_Customer_Employee();
			cem.setCem_id(request.getParameter("cedula"));
			cem.setCem_name(request.getParameter("nombre"));
			
			Tm_Ode_Order_Detail ode = new Tm_Ode_Order_Detail();
			ode.setCem_obj(cem);
			ode.setOde_amount(new BigDecimal(request.getParameter("monto")));
					
			ben.add(ode);
		}	
		Iterator<Tm_Ode_Order_Detail> it = ben.iterator();
		while (it.hasNext())
		{	Tm_Ode_Order_Detail o = (Tm_Ode_Order_Detail) it.next();
			out.println("<tr>");
			out.println("	<td><input type = 'text' size = '30' name = 'n' value = "+ o.getCem_obj().getCem_name() +" disabled/> </td>");
			out.println("	<td><input type = 'text' size = '15' name = 'c' value = "+ o.getCem_obj().getCem_id() +" disabled/> </td>");
			out.println("	<td><input type = 'text' size = '10' name = 'm' value = "+ o.getOde_amount() +" disabled/> </td>");
			out.println("</tr>");
		}				
		out.println("</table>");		
		sesion.setAttribute("ben", ben);
		
%>
	
	</table>
	<input type = 'submit' value = 'Agregar' />
	</form>
</body>
</html>