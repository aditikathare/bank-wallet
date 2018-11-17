package com.cg.wallet.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.Customer;
import com.cg.wallet.bean.WalletTransaction;
import com.cg.wallet.exception.WalletException;


public interface IWalletDAO {

	public boolean createAccount(Customer customer) throws WalletException;
	public double showBalance(BigInteger phoneNum) throws WalletException;
	public boolean deposit(BigInteger phoneNum, double balance) throws WalletException ;
	public boolean withDraw(BigInteger phoneNum, double balance) throws WalletException;
	public boolean fundTransfer(BigInteger sourceNum,BigInteger targetNum, double balance) throws WalletException;
	public ArrayList<WalletTransaction> printTransaction (LocalDateTime fDate,LocalDateTime tDate,String type,BigInteger phoneNum);
	
	
	
}
