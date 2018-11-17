package com.cg.wallet.testcases;

import static org.junit.Assert.assertFalse;
import java.math.BigInteger;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.wallet.bean.Customer;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletCreateAccountTest {

private	static IWalletService service = null;

	@BeforeClass
	public static void createInstance() 
	{
		service = new WalletServiceImpl();
	}

	@Test
	public  void test() throws WalletException //Positive testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("Vinitha");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result = service.createAccount(customer);
		assertTrue(result);
	}
	
	@Test (expected = WalletException.class)
	public  void testFirstNameNull() throws WalletException //First name not null testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result =service.createAccount(customer);
		assertFalse(result);
	}
	
	@Test (expected = WalletException.class)
	public void testFirstNameForOnlyChar() throws WalletException //First name only characters testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("Vin@#");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result = service.createAccount(customer);
		assertFalse(result);
	}
	
	@Test (expected = WalletException.class)
	public void testFirstNameForlength() throws WalletException //First name only characters testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("vi");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result = service.createAccount(customer);
		assertFalse(result);
	}
	
	// Testcases for lastname

	@Test (expected =  WalletException.class)
	public void testLastNameNull() throws WalletException //Last name not null testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("Vinitha");
		customer.setLastName("");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result = service.createAccount(customer);
		assertFalse(result);
	}
	
	@Test (expected = WalletException.class)
	public void testLastNameForOnlyChar() throws WalletException //Last name only characters testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Narv#$eni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result =service.createAccount(customer);
		assertFalse(result);
	}
	
	@Test (expected = WalletException.class)
	public void testLastNameForlength() throws WalletException //Last name only characters (>3) testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Na");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result = service.createAccount(customer);
		assertFalse(result);
	}
	
	//Test cases for phone number
	
	@Test (expected = WalletException.class)
	public void testPhoneNumberForlength() throws WalletException //phone number should be 10 digits testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("97036127"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result = service.createAccount(customer);
		assertFalse(result);
	}
	/*@Test (expected =  WalletException.class)
	public void testPhoneNumberForNull() throws WalletException //phone number should be 10 digits testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(null);
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result = service.createAccount(customer);
		assertFalse(result);
	}
	*/
	
	
	@Test (expected = NumberFormatException.class)
	public void testPhoneNumberForChar() throws WalletException //Phone Number only characters testcase
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("97036ab123"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result =service.createAccount(customer);
		assertFalse(result);
	}
	
	
	@Test (expected = WalletException.class)
	public void testEmailIDForNull() throws WalletException //EmailID only null
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("");
		customer.setPermanantAccNum("BVBPK9214B");
		boolean result =service.createAccount(customer);
		assertFalse(result);
	}

	@Test (expected = WalletException.class)
	public void testPanForSpecialCharacters() throws WalletException //Pan for special characters
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVDA%&1ERF");
		boolean result = service.createAccount(customer);
		assertFalse(result);
	}
	
	@Test(expected =WalletException.class)
	public void testPanForNull() throws WalletException //Pan for null
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("");
		boolean result = service.createAccount(customer);
		assertFalse(result);
	}
	
	
	
	@Test (expected = WalletException.class)
	public void testPanForLength() throws WalletException //Pan for length
	{	
		Customer customer = new Customer();
		customer.setFirstName("vinitha");
		customer.setLastName("Narvaneni");
		customer.setPhoneNum(new BigInteger("9703612617"));
		customer.setEmailID("vinitha.narvaneni@capgemini.com");
		customer.setPermanantAccNum("BVGH567");
		boolean result =service.createAccount(customer);
		assertFalse(result);
	}
	
	
	
}
