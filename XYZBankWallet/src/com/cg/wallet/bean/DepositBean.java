package com.cg.wallet.bean;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
public class DepositBean implements Serializable{
 
	private BigInteger phoneNum;
	private double balance;

	private LocalDateTime tDate;
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
	private String tType;
	
	public BigInteger getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(BigInteger phoneNum) {
		this.phoneNum = phoneNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
