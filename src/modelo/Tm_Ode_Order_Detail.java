package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Tm_Ode_Order_Detail implements Serializable {

	
	private static final long serialVersionUID = 7702397056573928960L;
	
	private int ode_code;
	private Tm_Ord_Order ord_obj;
	private Tm_Cem_Customer_Employee cem_obj;
	private Tm_Dep_Delivery_Point dep_obj;
	private BigDecimal ode_amount;
	
	
	public Tm_Ode_Order_Detail() {
		ode_code = 0;
		ord_obj = null;
		cem_obj = null;
		dep_obj = null;
		ode_amount = new BigDecimal(0);
	}


	public int getOde_code() {
		return ode_code;
	}


	public void setOde_code(int ode_code) {
		this.ode_code = ode_code;
	}


	public Tm_Ord_Order getOrd_obj() {
		return ord_obj;
	}


	public void setOrd_obj(Tm_Ord_Order ord_obj) {
		this.ord_obj = ord_obj;
	}


	public Tm_Cem_Customer_Employee getCem_obj() {
		return cem_obj;
	}


	public void setCem_obj(Tm_Cem_Customer_Employee cem_obj) {
		this.cem_obj = cem_obj;
	}


	public Tm_Dep_Delivery_Point getDep_obj() {
		return dep_obj;
	}


	public void setDep_obj(Tm_Dep_Delivery_Point dep_obj) {
		this.dep_obj = dep_obj;
	}


	public BigDecimal getOde_amount() {
		return ode_amount;
	}


	public void setOde_amount(BigDecimal ode_amount) {
		this.ode_amount = ode_amount;
	}
	
	

}
