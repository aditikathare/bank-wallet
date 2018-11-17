package com.cg.wallet.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class WithDrawBean implements Serializable {

	private BigInteger phoneNum;
	private double amount;
	private double balance;
	private LocalDateTime tDate;
	private String tType;

	public LocalDateTime gettDate() {
		return tDate;
	}

	public void settDate(LocalDateTime tDate) {
		this.tDate = tDate;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public BigInteger getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(BigInteger phoneNum) {
		this.phoneNum = phoneNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
