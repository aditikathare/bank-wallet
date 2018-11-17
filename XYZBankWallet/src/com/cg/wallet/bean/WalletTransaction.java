package com.cg.wallet.bean;


import java.math.BigInteger;
import java.time.LocalDateTime;

public class WalletTransaction {

    public BigInteger getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(BigInteger phoneNum) {
        this.phoneNum = phoneNum;
    }
    private BigInteger phoneNum; 
    private LocalDateTime tDate;
    private String tType;
    private LocalDateTime fDate;
    private double amount;
    private double balance;
    
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public LocalDateTime gettDate() {
        return tDate;
    }
    public void settDate(LocalDateTime date) {
        this.tDate = date;
    }
    public String gettType() {
        return tType;
    }
    public void settType(String tType) {
        this.tType = tType;
    }
   
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
	public LocalDateTime getfDate() {
		return fDate;
	}
	public void setfDate(LocalDateTime fDate) {
		this.fDate = fDate;
	}
}
