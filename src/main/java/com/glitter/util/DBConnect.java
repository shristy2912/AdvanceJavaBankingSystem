package com.glitter.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystemdb","root","shristy1234");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}