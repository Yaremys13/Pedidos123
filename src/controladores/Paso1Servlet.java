package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Tm_Cus_Customer;



public class Paso1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Paso1Servlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tm_Cus_Customer cusPage = new Tm_Cus_Customer();
		cusPage.setCus_rif(request.getParameter("cus_rif"));
		cusPage.setCus_name(request.getParameter("cus_name"));
		cusPage.setCus_phone(request.getParameter("cus_phone"));
		cusPage.setCus_address(request.getParameter("cus_address"));
		cusPage.setCus_contact(request.getParameter("cus_contact"));
		
		Tm_Cus_Customer cus = new Tm_Cus_Customer().findByRif(cusPage.getCus_rif());
		
		request.setAttribute("cus", cus);
		
		RequestDispatcher rd = null;
		
		String mensaje = null;
		
		HttpSession sesion = request.getSession();
		
		if (cus == null) //ES NUEVO
		{	if (sesion.getAttribute("ban")== null)
			{	rd = request.getRequestDispatcher("paso1.jsp");
				cus = new Tm_Cus_Customer();
				cus.setCus_rif(cusPage.getCus_rif());
				request.setAttribute("cus", cus);
				sesion.setAttribute("ban","paso2.jsp");
				
			}
			else 
			{	if (!new Tm_Cus_Customer().insertCustomer(cusPage))
				{	mensaje = "Error en el registro del Cliente, intente de nuevo";
					rd = request.getRequestDispatcher("paso1.jsp");				
					
				}
				else
				{	mensaje = null;
					request.setAttribute("cus", cusPage);
					sesion.removeAttribute("ban");
					
					rd = request.getRequestDispatcher("paso2.jsp");
					
					
				}
			}
		}
		else
		{	mensaje = "Ya está registrado, proceda a introducir los datos del pedido (Paso 2)";
			sesion.removeAttribute("ban");
			rd = request.getRequestDispatcher("paso2.jsp");
			//rd.forward(request, response);
		}
		 
		request.setAttribute("mensaje", mensaje);
		rd.forward(request, response);
		
			
		
		
	}

}
