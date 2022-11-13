package com.BAnkDao;
import java.util.List;

import com.BankException.CustomerException;
import com.BankModel.Customer;

public interface CustomerDao {
public String customerRegistration(Customer customer);
	
	public String fundTransefer(Customer cuss,int accNo,double amt);
	
	public List<String> viewTransactions(Customer cus) throws CustomerException;
	
	public List<String> view_Last_5_Transactions(Customer cus) throws CustomerException;
	
	public List<String> viewAccountStatements(Customer customer,int year) throws CustomerException;
	
	public Customer provideUserObject(String username) throws CustomerException;

	public String getUserName(int accId, int aadhar, int otp);

	public String getUserPassword(int accId1, int aadhar1, int otp1);
	
	
}
