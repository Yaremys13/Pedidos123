package modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import util.Conexion;

public class Tm_Pro_Product implements Serializable {

	private static final long serialVersionUID = 8220437587780114425L;
	
	private int pro_code;
	private String pro_name;
	private float pro_fee;
	
	public Tm_Pro_Product() {
		pro_code = 0;
		pro_name = "";
		pro_fee = 0f;
		
	}

	public int getPro_code() {
		return pro_code;
	}

	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public float getPro_fee() {
		return pro_fee;
	}

	public void setPro_fee(float pro_fee) {
		this.pro_fee = pro_fee;
	}
	
	public Vector<Tm_Pro_Product> findAll()
	{	Vector<Tm_Pro_Product> ret = null;
		Tm_Pro_Product p = null;
		Conexion con = new Conexion();
		
		if (con.getCon() != null)
		{	try {
			PreparedStatement ps = con.getCon().prepareStatement("select * from tm_pro_product");
				ResultSet rs = ps.executeQuery();
				if (rs != null)
				{	ret = new Vector<Tm_Pro_Product>();
					while (rs.next())
					{	p = new Tm_Pro_Product();
						p.setPro_code(rs.getInt("pro_code"));
						p.setPro_name(rs.getString("pro_name"));
						p.setPro_fee(rs.getFloat("pro_fee"));
						ret.add(p);
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
			
		}
		
		
		return ret;
	}
	

}
