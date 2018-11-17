package com.cg.wallet.bean;

import java.io.Serializable;
import java.math.BigInteger;

public class BalanceBean implements Serializable
{
	private static double balance;
	private BigInteger phoneNum;
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
	

}
