package com.glitter.model;

public class Deposit {
	private double deposit;
	private double withdraw;
	private double currbalnce;
	private double accountno;
	@Override
	public String toString() {
		return "Deposit [deposit=" + deposit + ", withdraw=" + withdraw + ", currbalance=" + currbalnce
				+ ", accountno=" + accountno + "]";
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public double getCurrbalance() {
		return currbalnce;
	}
	public void setCurrbalance(double currbalance) {
		this.currbalnce = currbalance;
	}
	public double getAccountno() {
		return accountno;
	}
	public void setAccountno(double accountno) {
		this.accountno = accountno;
	}
	
	
	
	
	
	
}