package com.glitter.model;

public class User {
	private int accountno;
	private String name;
	private String surname;
	private String mobile;
	private String DOB;
	private double amount;
	private String email;
	private String password;
	
	
	@Override
	public String toString() {
		return "User [accountno=" + accountno + ", name=" + name + ", surname=" + surname + ", mobile=" + mobile
				+ ", DOB=" + DOB + ", amount=" + amount + ", email=" + email + ", password=" + password + "]";
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}