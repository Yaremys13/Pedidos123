package modelo;

import java.io.Serializable;

public class Tm_Cem_Customer_Employee implements Serializable {
	
	
	private static final long serialVersionUID = -71753373813597979L;
	
	private int cem_code;
	private String cem_id;
	private String cem_name;
	
	
	public Tm_Cem_Customer_Employee() {
		cem_code = 0;
		cem_id = "";
		cem_name = "";
	}


	public int getCem_code() {
		return cem_code;
	}


	public void setCem_code(int cem_code) {
		this.cem_code = cem_code;
	}


	public String getCem_id() {
		return cem_id;
	}


	public void setCem_id(String cem_id) {
		this.cem_id = cem_id;
	}


	public String getCem_name() {
		return cem_name;
	}


	public void setCem_name(String cem_name) {
		this.cem_name = cem_name;
	}
	
	
	

}
