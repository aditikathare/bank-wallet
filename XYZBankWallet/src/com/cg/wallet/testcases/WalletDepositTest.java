package com.cg.wallet.testcases;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.wallet.bean.BalanceBean;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletDepositTest {

	static IWalletService service = null;

	@BeforeClass
	public static void createInstance() {
		service = new WalletServiceImpl();
	}

	@Test
	public void test() throws WalletException // Positive testCase
	{
		
		BalanceBean balbean = new BalanceBean();
		balbean.setPhoneNum(new BigInteger("8121198399"));
		balbean.setBalance(5000.00);
		boolean result = service.deposit(balbean.getPhoneNum(), balbean.getBalance());
		assertTrue(result);
	}

	@Test(expected = WalletException.class)
	public void TestForPhoneNumberLength() throws WalletException {
		BalanceBean balbean = new BalanceBean();
		balbean.setPhoneNum(new BigInteger("812113"));
		balbean.setBalance(5000.00);
		boolean result = service.deposit(balbean.getPhoneNum(),  balbean.getBalance());
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void testForChar() throws WalletException {
		BalanceBean balbean = new BalanceBean();
		balbean.setPhoneNum(new BigInteger("81211abc99"));
		balbean.setBalance(5000.00);
		boolean result = service.deposit(balbean.getPhoneNum(),  balbean.getBalance());
		assertFalse(result);
	}
	
}
