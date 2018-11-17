package com.cg.wallet.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.BalanceBean;
import com.cg.wallet.bean.Customer;
import com.cg.wallet.bean.DepositBean;
import com.cg.wallet.bean.FundTransferBean;
import com.cg.wallet.bean.WalletTransaction;
import com.cg.wallet.bean.WithDrawBean;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.exception.WalletExceptionMesssage;

public class WalletDAOImpl implements IWalletDAO {
    private static ArrayList<Customer> custList = new ArrayList<>();
    private static ArrayList<BalanceBean> balanceList = new ArrayList<>();
    private static ArrayList<DepositBean> depositList = new ArrayList<>();
    private static ArrayList<FundTransferBean> ftList = new ArrayList<>();
    private static ArrayList<WithDrawBean> withdrawList = new ArrayList<>();
    private static ArrayList<WalletTransaction> transList = new ArrayList<>();
    Customer customer = new Customer();
    BalanceBean balbean = new BalanceBean();
    DepositBean depositBean = new DepositBean(); 
   WithDrawBean withDraw = new WithDrawBean();
   WalletTransaction walletTrans = new WalletTransaction();
   FundTransferBean ftBean=new FundTransferBean();
    

    @Override
    public boolean createAccount(Customer customer) {
    	
        return custList.add(customer);
       
    }

    @Override
    public double showBalance(BigInteger phoneNum) throws WalletException {
    
        
        double bal=0.0;
        try{
        for (BalanceBean bb : balanceList) {
            
            if(bb.getPhoneNum().equals(phoneNum))
            {
                
                bal= bb.getBalance();
                
            }
        }
        

        return bal;
        }catch(Exception e){
            throw new WalletException("Enter correct phone number");
        }
    }

    @Override
    public boolean deposit(BigInteger phoneNum, double balance) throws WalletException {
        
        boolean isValid = false;
       
       // double balance;
        for (DepositBean dbean : depositList) {
            if (dbean.getPhoneNum() != phoneNum) {
                throw new WalletException(WalletExceptionMesssage.ERROR);
            }else{            
     
            	depositBean.setBalance(balbean.getBalance());

                balance = depositBean.getBalance() + balance;
                if (depositList.set(0, depositBean) != null) {
                    isValid = true;
                }
                depositBean.setBalance(balance);
                System.out.println(depositBean.getBalance());
                LocalDateTime date = LocalDateTime.now();

                balbean.setBalance(balance);
                depositBean.settDate(date);
                depositBean.settType("deposit");
               // depositBean.setReceipentNumber(walletTrans.getPhoneNum());
                depositList.add(depositBean);
            }

        }
        return isValid;
    }


    @Override
    public boolean withDraw(BigInteger phoneNum, double amount) throws WalletException {
        boolean isValid = false;
        WalletTransaction transaction = new WalletTransaction();
        double balance;
        for (WithDrawBean withdrawbean : withdrawList) {
            if (withdrawbean.getBalance() < amount) {
                throw new WalletException(WalletExceptionMesssage.ERROR);
                        
            } else {
                transaction.setBalance(withDraw.getBalance());

                balance = withDraw.getBalance() - amount;
                if (withdrawList.set(0, withDraw) != null) {
                    isValid = true;
                }

                System.out.println(withDraw.getBalance());
                LocalDateTime date = LocalDateTime.now();

                withDraw.setAmount(amount);
                withDraw.settDate(date);
                withDraw.settType("Withdraw");
                
                withdrawList.add(withDraw);
            }

        }
        return isValid;
    }

    @Override
    public boolean fundTransfer(BigInteger sourceNum, BigInteger targetNum,
            double balance) throws WalletException {
            boolean isResult = false;

        try {
            for (FundTransferBean fList : ftList) {
                
            
            if (targetNum == fList.getSourceNum()) {

                boolean isTransfer = withDraw(sourceNum, balance);

                if (isTransfer) {

                    boolean isDeposit = deposit(targetNum, balance);

                    if (isDeposit) {

                        isResult = true;

                    }
                    LocalDateTime date = LocalDateTime.now();

                    ftBean.setAmount(balance);
                    ftBean.settDate(date);
                    ftBean.settType("Withdraw");
                    ftList.add(ftBean);

                }

            }}

            return isResult;
        } catch (Exception e) {
            throw new WalletException();
        }
    }

    @Override
    public ArrayList<WalletTransaction> printTransaction(LocalDateTime fDate,LocalDateTime tDate,String type,BigInteger phoneNum) {
        ArrayList<WalletTransaction> result = new ArrayList<>();
        
        for (WalletTransaction walletTransaction : transList) {
        	if(walletTransaction.getPhoneNum() == phoneNum){
            if (!(walletTransaction.gettDate().isAfter(fDate))
                    && walletTransaction.gettDate().isBefore(LocalDateTime.now()) && walletTransaction.gettType() == type) {
                
               result.add(walletTransaction);
            }
        }}
        return result;
    }
    

    
    
}
