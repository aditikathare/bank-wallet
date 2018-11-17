package com.cg.wallet.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.Customer;
import com.cg.wallet.bean.WalletTransaction;
import com.cg.wallet.dao.IWalletDAO;
import com.cg.wallet.dao.WalletDAOImpl;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.exception.WalletExceptionMesssage;

public class WalletServiceImpl implements IWalletService {
    Customer customer = new Customer(); 

         IWalletDAO dao = new WalletDAOImpl();

    
    @Override
    public boolean validateData(Customer customer) throws WalletException 
    {
        boolean isValid = false;
        if(((validateFName(customer))&&(validateLName(customer))&&validatePhoneNumber(customer))&&validatePan(customer)&&
                validateEMailID(customer))
                {
                    isValid=true;
                }
        else
        {
            throw new WalletException(WalletExceptionMesssage.ERROR);
        }
        return isValid;
    }
    
    public boolean validateFName(Customer customer) throws WalletException
    {
        boolean isValid=false;
        String fName=customer.getFirstName();
        if((fName.matches("^[A-Za-z]{4,15}$")) && fName != null)
        {
            isValid=true;
        }
        else
        {
            throw new WalletException(WalletExceptionMesssage.FNAME_ERROR);
        }
        
        return isValid;

    }
    

    public boolean validateLName(Customer customer) throws WalletException
    {
    boolean isValid=false;
    String lName=customer.getLastName();
    if(lName.matches("[A-Za-z]{4,15}") && lName!= null)
    {
        isValid=true;
    }
    else
    {
        throw new WalletException(WalletExceptionMesssage.LNAME_ERROR);
    }
    
    return isValid;

    }

    public boolean validatePhoneNumber(Customer customer) throws WalletException
    {
        boolean isValid=false;
        BigInteger pno = customer.getPhoneNum();
        String phoneNumber = pno.toString();
        //BigInteger phoneNumber=customer.getPhoneNum();
        
        if (phoneNumber == null) {
            throw new WalletException("Phone Number is mandatory");

        } else {
            if (phoneNumber.matches("^[7-9][0-9]{9}$")) {
                isValid = true;
            }
            else
            {
                throw new WalletException("Phone number should contain only 10 digits");
            }
        }

        return isValid;

    }
    
    public boolean validateEMailID(Customer customer) throws WalletException 
    {
        boolean isValid=false;
        String EMailID = customer.getEmailID();
        if((EMailID.matches("[A-Za-z0-9_]+[.A-Za-z0-9]+@+[a-z]+\\.com")) && (EMailID != null))
        {
            isValid=true;
        }
        else
        {
            throw new WalletException(WalletExceptionMesssage.EMAIL_ERROR);
        }
        
        return isValid;
    }
    
    
    public boolean validatePan(Customer customer) throws WalletException
    {
        boolean isValid=false;
        String pan=customer.getPermanantAccNum();
        
        if (pan.isEmpty()) {
            
            throw new WalletException("Phone Number is mandatory");

        } else {
            if (pan.matches("[A-Z0-9a-z]{10}")) {
                isValid = true;
            }
            else
            {
                throw new WalletException("PAN number should contain only 10 digits");
            }
        }
        return isValid;
    }
    


    @Override
    public boolean createAccount(Customer customer) throws WalletException 
    {
        validateData(customer);
        return dao.createAccount(customer);
    }

    @Override
    public double showBalance(BigInteger phoneNum) throws WalletException {
        return dao.showBalance(phoneNum);
        
    }

    @Override
    public boolean deposit(BigInteger phoneNum, double balance)  throws WalletException{
    	customer.setPhoneNum(phoneNum);
    	validatePhoneNumber( customer);
        return dao.deposit(phoneNum, balance);
        
    }

    @Override
    public boolean withDraw(BigInteger phoneNum, double balance) throws WalletException {
    	    customer.setPhoneNum(phoneNum);
    	   validatePhoneNumber( customer);
           return dao.withDraw(phoneNum, balance);
        
    }

    @Override
    public boolean fundTransfer(BigInteger sourceNum, BigInteger targetNum, double balance) throws WalletException {
    	
    	 customer.setPhoneNum(targetNum);
  	     validatePhoneNumber( customer);
        return dao.fundTransfer(sourceNum, targetNum, balance);
        
    }
    
    public boolean validatePhoneNum(WalletTransaction transaction) throws WalletException
    {
        boolean isValid=false;
        BigInteger pno = transaction.getPhoneNum();
        String phoneNumber = pno.toString();
        //BigInteger phoneNumber=customer.getPhoneNum();
        
        if (phoneNumber == null) {
            throw new WalletException("Phone Number is mandatory");

        } else {
            if (phoneNumber.matches("^[7-9][0-9]{9}$")) {
                isValid = true;
            }
            else
            {
                throw new WalletException("Phone number should contain only 10 digits");
            }
        }

        return isValid;

    }
    


    
    @Override
    public ArrayList<WalletTransaction> printTransaction(LocalDateTime fDate,
            LocalDateTime tDate,String type,BigInteger phoneNum) {
        
        return dao.printTransaction(fDate, tDate, type,phoneNum);
    }

	


}
