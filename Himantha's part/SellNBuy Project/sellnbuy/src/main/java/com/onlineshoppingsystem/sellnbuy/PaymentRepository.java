package com.onlineshoppingsystem.sellnbuy;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PaymentRepository {
	
	Connection con = null;
	
	public PaymentRepository()
	{
		String url = "jdbc:mysql://localhost:3306/sellnbuy";
		String username = "root";
		String password = "1234";
				
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
	}
			
				catch(Exception e){
				System.out.println(e);
				
			}
	}
	
		public List<Payment> getPayments()
	{
			List<Payment> payments = new ArrayList<>();
			String sql = "select * from payment";
			
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);  
				while(rs.next()) {
					Payment p = new Payment();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setCountry(rs.getString(3));
					p.setContactNo(rs.getString(4));
					p.setDate(rs.getString(5));
					p.setCreditCardType(rs.getString(6));
					p.setCreditCardNo(rs.getShort(7));
					p.setSecurityCode(rs.getString(8));
					
					payments.add(p);
				}
			
			}
			catch(Exception e){
				
				System.out.println(e);
			}
			
		return payments;
	}
	
    public Payment getPayment(int id)
    {
    	
    	String sql = "select * from payment where id="+id;
    	Payment p = new Payment();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);  
			if(rs.next()) {
				
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setCountry(rs.getString(3));
				p.setContactNo(rs.getString(4));
				p.setDate(rs.getString(5));
				p.setCreditCardType(rs.getString(6));
				p.setCreditCardNo(rs.getShort(7));
				p.setSecurityCode(rs.getString(8));
				
				
			}
		
		}
		catch(Exception e){
			
			System.out.println(e);
		}
		
    	return p;
    }

	public void create(Payment p1) {
		String sql = "insert into payment values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, p1.getId());
			st.setString(2, p1.getName());
			st.setString(3, p1.getCountry());
			st.setString(4, p1.getContactNo());
			st.setString(5, p1.getDate());
			st.setString(6, p1.getCreditCardType());
			st.setInt(7, p1.getCreditCardNo());
			st.setString(8, p1.getSecurityCode());
			
			st.executeUpdate(); 
			
			
		}
		catch(Exception e){
			
			System.out.println(e);
		}
		
	}
	
	public void update(Payment p1) {
		String sql = "update payment set name=?, country=?, contactNo=?, date=?, creditCardType=?, creditCardNo=?, securityCode=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, p1.getName());
			st.setString(2, p1.getCountry());
			st.setString(3, p1.getContactNo());
			st.setString(4, p1.getDate());
			st.setString(5, p1.getCreditCardType());
			st.setInt(6, p1.getCreditCardNo());
			st.setString(7, p1.getSecurityCode());
			st.setInt(8, p1.getId());
			
			st.executeUpdate(); 
			
			
		}
		catch(Exception e){
			
			System.out.println(e);
		}
		
	}

	public void delete(int id) {

		String sql = "delete from payment where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setInt(1, id);
			
			st.executeUpdate(); 
			
			
		}
		catch(Exception e){
			
			System.out.println(e);
		}
	}
}
