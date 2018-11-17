package com.cg.wallet.bean;

import java.io.Serializable;
import java.math.BigInteger;

public class Customer implements Serializable{

	private String firstName;
	private String lastName;
	private BigInteger phoneNum;
	private String location;
	private String emailID;
	private String permanantAccNum;
	

	private String printTransaction;

	public String getPrintTransaction() {
		return printTransaction;
	}

	public void setPrintTransaction(String printTransaction) {
		this.printTransaction = printTransaction;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public BigInteger getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(BigInteger phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPermanantAccNum() {
		return permanantAccNum;
	}

	public void setPermanantAccNum(String permanantAccNum) {
		this.permanantAccNum = permanantAccNum;
	}


}
