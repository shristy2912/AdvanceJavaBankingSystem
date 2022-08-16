package com.glitter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.glitter.model.Deposit;
import com.glitter.model.User;
import com.glitter.util.DBConnect;

public class DepositDao {
	
	Connection con = DBConnect.getConnection();

	public boolean addDeposit(Deposit inc) {
		
		
		try {
			PreparedStatement ps = null;
			
			ps = con.prepareStatement("update users set amount=? where accountno=?");	
			ps.setDouble(1, inc.getCurrbalance());
			ps.setDouble(2, inc.getAccountno());
			ps.executeUpdate();
			
			ps = con.prepareStatement("insert into balance(deposit,withdraw,currbalnce,accountno) values(?,?,?,?)");	
			ps.setDouble(1, inc.getDeposit());
			ps.setDouble(2, inc.getWithdraw());
			ps.setDouble(3, inc.getCurrbalance());
			ps.setDouble(4, inc.getAccountno());
			
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
	
	public List<Deposit> getDepositList(int accountno){
		List<Deposit> incList = new ArrayList<Deposit>();
		
		String sql = "select * from balance where accountno=?";
		
		try {
	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountno);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Deposit inc = new Deposit();
				inc.setDeposit(rs.getDouble("deposit"));
				inc.setWithdraw(rs.getDouble("withdraw"));
				inc.setCurrbalance(rs.getDouble("currbalnce"));
				inc.setAccountno(rs.getInt("accountno"));
				
				incList.add(inc);
			}
			
			return incList;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
		
}