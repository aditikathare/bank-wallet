package com.cg.wallet.testcases;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;



import com.cg.wallet.bean.WithDrawBean;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletWithdrawTest {
	private	static IWalletService service = null;

	@BeforeClass
	public static void createInstance() 
	{
		service = new WalletServiceImpl();
	}
	
	@Test(expected = WalletException.class)
	public  void testForLength() throws WalletException //Positive testcase
	{	
	
	    WithDrawBean wbean = new WithDrawBean();
		wbean.setPhoneNum(new BigInteger("628166067"));
		wbean.setBalance(2000.00);
		boolean result=service.withDraw(wbean.getPhoneNum(), wbean.getBalance());
		assertFalse(result);
		
		
		
	}
	@Test(expected = NumberFormatException.class)
	public  void testForCharacters() throws WalletException //Positive testcase
	{	
	
	    WithDrawBean wbean = new WithDrawBean();
		wbean.setPhoneNum(new BigInteger("628166a067"));
		wbean.setBalance(2000.00);
		boolean result=service.withDraw(wbean.getPhoneNum(), wbean.getBalance());
		assertFalse(result);
		
		
		
	}
	@Test
	public  void test() throws WalletException //Positive testcase
	{	
	
	    WithDrawBean wbean = new WithDrawBean();
		wbean.setPhoneNum(new BigInteger("8281660697"));
		wbean.setBalance(2000.00);
		boolean result=service.withDraw(wbean.getPhoneNum(), wbean.getBalance());
		assertTrue(result);
		
		
		
	}
	
}
