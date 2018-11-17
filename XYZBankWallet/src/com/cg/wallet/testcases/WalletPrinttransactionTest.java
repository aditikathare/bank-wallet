//package com.cg.wallet.testcases;
//
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import java.math.BigInteger;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.cg.wallet.bean.WalletTransaction;
//import com.cg.wallet.exception.WalletException;
//import com.cg.wallet.service.IWalletService;
//import com.cg.wallet.service.WalletServiceImpl;
//
//public class WalletPrinttransactionTest {
//
//               
//
//               private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
//               static IWalletService service =null;
//              
//               @BeforeClass
//               public static void createInstance()
//               {
//               service=new WalletServiceImpl();
//                               
//               }
//               
//               
//               @Test(expected=NullPointerException.class)
//               public void testValidatePhoneForNull() throws WalletException {
//                               WalletTransaction transaction = new WalletTransaction();
//                               transaction.setPhoneNum(null);
//                               boolean result=service.validatePhoneNum(transaction);
//                               assertFalse(result);
//               }
//               
//               @Test
//               public void testValidatePhone() throws WalletException {
//                   WalletTransaction transaction = new WalletTransaction();
//                               transaction.setPhoneNum(new BigInteger("9878356676"));
//                               boolean result=service.validatePhoneNum(transaction);
//                               assertTrue(result);
//               }
//               
//               
//               @Test(expected=NumberFormatException.class)
//               public void testValidatePhoneForNumbers() throws WalletException{
//                   WalletTransaction transaction = new WalletTransaction();
//                   transaction.setPhoneNum(new BigInteger("98ruthr4"));
//                               
//                               boolean result=service.validatePhoneNum(transaction);
//                               assertFalse(result);
//               }
//               
//               @Test
//               public void testValidateDate() throws WalletException
//               {
//                               
//            	   WalletTransaction transaction = new WalletTransaction();
//                             
//                               transaction.setPhoneNum(new BigInteger("9657445637"));
//                               transaction.settDate(LocalDateTime.of(2018, 10, 5, 10, 45));
//                               transaction.setfDate(LocalDateTime.of(2018, 12, 5, 10, 45));
//                               boolean result=service.printTransaction(transaction.getfDate(), transaction.gettDate(), "Deposit", transaction.getPhoneNum());
//                               assertTrue(result);
//                               
//               }
//               
//               
//               @Test(expected=NullPointerException.class)
//               public void testValidateDateForNull() throws WalletException
//               {
//                               
//            	   WalletTransaction transaction = nSew WalletTransaction();
//            	   transaction.setPhoneNum(new BigInteger("9657445637"));
//            	   transaction.settDate(null);
//                               boolean result=service.printTransaction(fDate, tDate, type, phoneNum);
//                               assertFalse(result);
//                               
//               }
//               
//               
//           
//               
//               
//               
//               
//               
//
//}
