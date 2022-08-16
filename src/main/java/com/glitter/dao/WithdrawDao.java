package com.glitter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.glitter.model.User;
import com.glitter.model.Withdraw;
import com.glitter.util.DBConnect;

public class WithdrawDao {
	
	Connection con = DBConnect.getConnection();

	public boolean addWithdraw(Withdraw with) {
		
		try {
			PreparedStatement ps = null;;
			
			ps = con.prepareStatement("update users set amount=? where accountno=?");	
			ps.setDouble(1, with.getCurrbalnce());
			ps.setDouble(2, with.getAccountno());
			ps.executeUpdate();
			
			ps = con.prepareStatement("insert into balance(deposit,withdraw,currbalnce,accountno) values(?,?,?,?)");
			ps.setDouble(1, with.getDeposit());
			ps.setDouble(2, with.getWithdraw());
			ps.setDouble(3, with.getCurrbalnce());
			ps.setDouble(4, with.getAccountno());
			
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
	
		
}