package com.Model;

public class Register {

	private int Accno;
	private String custname;
	private double accbal;
	private String uname;
	private String pass;
	public Register()
	{
		
	}
	public Register(int accno, String custname, double accbal) {
		this.Accno = accno;
		this.custname = custname;
		this.accbal = accbal;
		this.uname=uname;
		this.pass=pass;
	}
	public int getAccno() {
		return Accno;
	}
	public void setAccno(int accno) {
		Accno = accno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public double getAccbal() {
		return accbal;
	}
	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
