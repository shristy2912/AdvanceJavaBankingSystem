package com.glitter.model;

public class Withdraw {
	private double deposit;
	private double withdraw;
	private double currbalnce;
	private double accountno;
	@Override
	public String toString() {
		return "Withdraw [deposit=" + deposit + ", withdraw=" + withdraw + ", currbalnce=" + currbalnce + ", accountno="
				+ accountno + "]";
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
	public double getCurrbalnce() {
		return currbalnce;
	}
	public void setCurrbalnce(double currbalnce) {
		this.currbalnce = currbalnce;
	}
	public double getAccountno() {
		return accountno;
	}
	public void setAccountno(double accountno) {
		this.accountno = accountno;
	}
	
	

}