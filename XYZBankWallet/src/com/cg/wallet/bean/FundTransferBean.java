package com.cg.wallet.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class FundTransferBean implements Serializable {
	private BigInteger sourceNum;
	private BigInteger targetNum;
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

	private double amount;
	
	public BigInteger getSourceNum() {
		return sourceNum;
	}
	public void setSourceNum(BigInteger sourceNum) {
		this.sourceNum = sourceNum;
	}
	public BigInteger getTargetNum() {
		return targetNum;
	}
	public void setTargetNum(BigInteger targetNum) {
		this.targetNum = targetNum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
