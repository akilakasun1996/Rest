package com.sellnbuy.shipping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class ShippingRepository {
	
	
	Connection con = null;
	
	public ShippingRepository() 
	{
		String url = "jdbc:mysql://localhost:3306/sellnbuy";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		
	}
	
	public List<Shipping> getShippings(){
		
		List<Shipping> shipping = new ArrayList<>();
		String sql = "select * from details";
		
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			Shipping s = new Shipping();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAddress(rs.getString(3));
			s.setTel(rs.getInt(4));
			
			shipping.add(s);
		}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return shipping;
	}
	
	public Shipping getShipping(int id) {
		
		String sql = "select * from details where id="+id;
		Shipping s = new Shipping();
		
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAddress(rs.getString(3));
			s.setTel(rs.getInt(4));
					
		}
		
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return s;
	}

	public void create(Shipping s1) {
		String sql = "insert into details values(?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, s1.getId());
			st.setString(2, s1.getName());
			st.setString(3, s1.getAddress());
			st.setInt(4, s1.getTel());	
			st.executeUpdate();
			
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}
	
	public void update(Shipping s1) {
		String sql = "update details set name=?, address=?, tel=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(4, s1.getId());
			st.setString(1, s1.getName());
			st.setString(2, s1.getAddress());
			st.setInt(3, s1.getTel());	
			st.executeUpdate();
			
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}

	public void delete(int id) {
		
		String sql = "delete from details where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}
	
}
