package com.cg.wallet.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.wallet.bean.Customer;
import com.cg.wallet.bean.FundTransferBean;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletFundTransferTest {

	private	static IWalletService service = null;

	@BeforeClass
	public static void createInstance() 
	{
		service = new WalletServiceImpl();
	}
	
	@Test(expected = WalletException.class)
	public  void testForLength() throws WalletException 
	{	
	
		FundTransferBean ftbean=new FundTransferBean();
		ftbean.setSourceNum(new BigInteger("8281660697"));
		ftbean.setTargetNum(new BigInteger("94419296"));
		boolean result=service.fundTransfer(ftbean.getSourceNum(), ftbean.getTargetNum(), 2000.00);
		assertFalse(result);
		
		
		
	}
	
	@Test(expected = NumberFormatException.class)
	public  void testForCharacters() throws WalletException 
	{	
	
		FundTransferBean ftbean=new FundTransferBean();
		ftbean.setSourceNum(new BigInteger("8281660697"));
		ftbean.setTargetNum(new BigInteger("9441929er6"));
		boolean result=service.fundTransfer(ftbean.getSourceNum(), ftbean.getTargetNum(), 2000.00);
		assertFalse(result);
		
	}
	@Test
	public  void test() throws WalletException 
	{	
	
		FundTransferBean ftbean=new FundTransferBean();
		ftbean.setSourceNum(new BigInteger("8281660697"));
		ftbean.setTargetNum(new BigInteger("9441929695"));
		boolean result=service.fundTransfer(ftbean.getSourceNum(), ftbean.getTargetNum(), 2000.00);
		assertTrue(result);
		
		
		
	}
	
	
	
}
