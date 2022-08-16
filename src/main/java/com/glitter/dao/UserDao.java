package com.glitter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.glitter.model.User;
import com.glitter.util.DBConnect;

public class UserDao {
	Connection con = DBConnect.getConnection();
	
	public boolean addUser(String email, String password,double amount,String name,String surname, String mobile, String DOB) {
		String sql = "insert into users(email,password,amount,name,surname,mobile,DOB) values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setDouble(3, amount);
			ps.setString(4, name);
			ps.setString(5, surname);
			ps.setString(6, mobile);
			ps.setString(7, DOB);
			
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<User> getUserList(){
		String sql = "select * from users";
		List<User> ul = new ArrayList<User>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setAccountno(rs.getInt("accountno"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setMobile(rs.getString("mobile"));
				user.setDOB(rs.getString("DOB"));
				user.setAmount(rs.getDouble("amount"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				ul.add(user);
			}
			
			return ul;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public User userLogin(String email,String password) {
		String sql = "select * from users where email=? and password=?";
		User user = new User();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setAccountno(rs.getInt("accountno"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setMobile(rs.getString("mobile"));
				user.setDOB(rs.getString("DOB"));
				user.setAmount(rs.getDouble("amount"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}			
			return user;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateUser(User u) {
		String sql = "update users set name=?, surname=?, mobile=?,DOB=?,amount=?,email=?, password=? where accountno=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getSurname());
			ps.setString(3, u.getMobile());
			ps.setString(4, u.getDOB());
			ps.setDouble(5, u.getAmount());
			ps.setString(6, u.getEmail());
			ps.setString(7, u.getPassword());
			ps.setInt(8, u.getAccountno());
			
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}