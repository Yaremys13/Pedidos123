package modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Conexion;

public class Tm_Cus_Customer implements Serializable {


	private static final long serialVersionUID = -638103080426218204L;

	private int cus_code;
	private String cus_rif;
	private String cus_name;
	private String cus_phone;
	private String cus_address;
	private String cus_contact;
	
	
	public Tm_Cus_Customer() {
		cus_code = 0;
		cus_rif = "";
		cus_name = "";
		cus_phone = "";
		cus_address = "";
		cus_contact = "";
	}


	public int getCus_code() {
		return cus_code;
	}


	public void setCus_code(int cus_code) {
		this.cus_code = cus_code;
	}


	public String getCus_rif() {
		return cus_rif;
	}


	public void setCus_rif(String cus_rif) {
		this.cus_rif = cus_rif;
	}


	public String getCus_name() {
		return cus_name;
	}


	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}


	public String getCus_phone() {
		return cus_phone;
	}


	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}


	public String getCus_address() {
		return cus_address;
	}


	public void setCus_address(String cus_address) {
		this.cus_address = cus_address;
	}


	public String getCus_contact() {
		return cus_contact;
	}


	public void setCus_contact(String cus_contact) {
		this.cus_contact = cus_contact;
	}
	
	public Tm_Cus_Customer findByRif (String valor)
	{	Tm_Cus_Customer ret = null;
		
		Conexion con = new Conexion();
		try {
			if (con.getCon() != null)
			{	PreparedStatement ps = con.getCon().prepareStatement("select * from tm_cus_customer where cus_rif = ?");
				ps.setString(1, valor);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs != null)
					if (rs.next())
					{	ret = new Tm_Cus_Customer();
						ret.setCus_code(rs.getInt("cus_code"));
						ret.setCus_rif(rs.getString("cus_rif"));
						ret.setCus_name(rs.getString("cus_name"));
						ret.setCus_phone(rs.getString("cus_phone"));
						ret.setCus_address(rs.getString("cus_address"));
						ret.setCus_contact(rs.getString("cus_contact"));
					}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{	
			try {
				if (con.getCon() != null)
					con.getCon().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return ret;
	}
	
	public boolean insertCustomer (Tm_Cus_Customer valor)
	{	boolean ret = false;
		
		Conexion con = new Conexion();
		try {
			if (con.getCon() != null)
			{	PreparedStatement ps = con.getCon().prepareStatement("insert into tm_cus_customer values (0,?,?,?,?,?)");
				ps.setString(1, valor.getCus_rif());
				ps.setString(2, valor.getCus_name());
				ps.setString(3, valor.getCus_phone());
				ps.setString(4, valor.getCus_address());
				ps.setString(5, valor.getCus_contact());
				
				int rs = ps.executeUpdate();
				
				if (rs != 0)
					ret = true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{	
			try {
				if (con.getCon() != null)
					con.getCon().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return ret;
	}
	

}
