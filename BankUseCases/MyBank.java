package com.BankUseCases;

import com.BAnkDao.AccountantDaoimpl;

import java.util.List;
import java.util.Scanner;

import com.BAnkDao.CustomerDao;
import com.BAnkDao.customerDaoimpl;
import com.BankModel.Customer;

public class MyBank {
	public static void main(String[] args) {
		System.out.println("----------------------------------------");
		System.out.println("**  Welcome To Online Banking System  **");
		System.out.println("----------------------------------------");
		System.out.println("1.Admin Login");
		System.out.println("2.Customer Login");
		System.out.println("3.New Customer ? Register here");
		System.out.println("4.Forget Id / Password");
		System.out.println("5.Exit");
		
		CustomerDao dao=new customerDaoimpl();
		AccountantDaoimpl adminDao=new AccountantDaoimpl();
		
		
		
		try {
			Scanner sc=new Scanner(System.in);
			int choice =sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter User Name");
				String lauser=sc.next();
				System.out.println("Enter Password");
				String lapass=sc.next();
				
				if(lauser.equals("Anand") && lapass.equals("12345")) {
					System.out.println("");
					System.out.println("***********Login successfull***********");
					System.out.println("");
					
					System.out.println("1.View customer details with account number");
					System.out.println("2.Update customer details");
					System.out.println("3.Close customer account");
					System.out.println("4.View all customer of bank");
					System.out.println("5.Exit");
					
					System.out.println("");
					System.out.println("*******************************************");
					System.out.println("");
					
					try {
						int choiceOption =sc.nextInt();
						switch(choiceOption) {
						
						case 1:
							System.out.println("Enter customer account no");
							int accountNumber=sc.nextInt();
							Customer customer=adminDao.customerDetails(accountNumber);
							

							System.out.println("***********************");
							System.out.println(customer.getFirstName());
							System.out.println(customer.getLastName());
							System.out.println(customer.getGender());
							System.out.println(customer.getMobileNo());
							System.out.println(customer.getEmail());
							System.out.println(customer.getUsername());
							System.out.println(customer.getAccountType());
							System.out.println(customer.getAccountBalance());
							
							break;
							
						case 2:
							
							System.out.println("");
							System.out.println("1.First Name change");
							System.out.println("2.Last Name change");
							System.out.println("3.Mobile Number change");
							System.out.println("4.Email Id change");
							System.out.println("5.User Name change");
							System.out.println("6.Password change");
							System.out.println("7.Exit");
							
							System.out.println("");
							
							try {
								
								int updateChoice =sc.nextInt();
								
								
								switch(updateChoice) {
								
								case 1:
									System.out.println("Enter customer account number ");
									int acc1=sc.nextInt();
									System.out.println("Enter customer new first name");
									String fname=sc.next();
									String message1=adminDao.updateCustomerFirstName(acc1, fname);
									System.out.println("");
									System.out.println(message1);
									break;
								case 2:
									System.out.println("Enter customer account number ");
									int acc2=sc.nextInt();
									System.out.println("Enter customer new last name");
									String lname=sc.next();
									String message2=adminDao.updateCustomerLastName(acc2, lname);
									System.out.println("");
									System.out.println(message2);
									break;
								case 3:
									System.out.println("Enter customer account number ");
									int acc3=sc.nextInt();
									System.out.println("Enter customer new mobile number");
									String mobile=sc.next();
									String message3=adminDao.updateCustomerMobileNo(acc3, mobile);
									System.out.println("");
									System.out.println(message3);
									break;	
								case 4:
									System.out.println("Enter customer account number ");
									int acc4=sc.nextInt();
									System.out.println("Enter customer new email id");
									String email=sc.next();
									String message4=adminDao.updateCustomerEmail(acc4, email);
									System.out.println("");
									System.out.println(message4);
									break;	
								case 5:
									System.out.println("Enter customer account number ");
									int acc5=sc.nextInt();
									System.out.println("Enter customer new username");
									String username=sc.next();
									String message5=adminDao.updateCustomerUserName(acc5, username);
									System.out.println("");
									System.out.println(message5);
									break;	
								case 6:
									System.out.println("Enter customer account number ");
									int acc6=sc.nextInt();
									System.out.println("Enter customer new password");
									String pass=sc.next();
									String message6=adminDao.updateCustomerPassword(acc6, pass);
									System.out.println("");
									System.out.println(message6);
									break;	
								case 7:
									System.out.println("Thank you and Visit Again");
									break;	
								default:
									System.out.println("Invalid input");
									break;
								}
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;
							
						case 3:
							System.out.println("");
							System.out.println("Enter customer account number to delete account ");
							int acc=sc.nextInt();
							String message=adminDao.closeCustomerAccount(acc);
							System.out.println(message);
							break;
						case 4:
							List<Customer> li=adminDao.allCustomerView();
							li.forEach(cus->{
								System.out.println(cus.getFirstName());
								System.out.println(cus.getLastName());
								System.out.println(cus.getGender());
								System.out.println(cus.getMobileNo());
								System.out.println(cus.getEmail());
								System.out.println(cus.getUsername());
								System.out.println(cus.getAccountNumber());
								System.out.println(cus.getAccountType());
								System.out.println(cus.getAccountBalance());
								System.out.println("*************************");
							});
							break;
						case 5:
							System.out.println("Thank you and Visit Again");
							break;
						default:
							System.out.println("Invalid input");
							break;
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
						
				}
				else {
					System.out.println("Invaid user or password");
				}
				
				break;
			case 2:
				try {
					System.out.println("Enter User Name");
					String luser=sc.next();
					System.out.println("Enter Password");
					String lpass=sc.next();
					
					Customer currentUser= dao.provideUserObject(luser);
					
					if(currentUser.getUsername().equals(luser) && currentUser.getPassword().equals(lpass)) {
						System.out.println("");
						
						System.out.println("***********Login successfull***********");
						System.out.println("1.Check balance");
						System.out.println("2.View last 5 Transactions");
						System.out.println("3.View all Transactions");
						System.out.println("4.View financial account statements online");
						System.out.println("5.Account-to-Account transfer");
						System.out.println("6.Exit");
						
						System.out.println("");
						System.out.println("*******************************************");
						System.out.println("");
						
						try {
							
							int choiceCus =sc.nextInt();
							switch(choiceCus) {
							case 1:
								System.out.println("Your current balance is "+currentUser.getAccountBalance());
								break;
							case 2: 
								List<String> li=dao.view_Last_5_Transactions(currentUser);
								li.forEach(str->System.out.println(str));
								break;
							case 3:
								List<String> liAll =dao.viewTransactions(currentUser);
								liAll.forEach(str->System.out.println(str));
								break;
							case 4:
								System.out.println("Enter financial year to get statement ");
								int year=sc.nextInt();
								List<String> liFin=dao.viewAccountStatements(currentUser,year);
								liFin.forEach(str->System.out.println(str));
								break;
							case 5:
								System.out.println("Enter account no to transfer");
								int TransferAcc=sc.nextInt();
								System.out.println("Enter Amount");
								double amount=sc.nextDouble();
								String message=dao.fundTransefer(currentUser,TransferAcc,amount);
								System.out.println(message);
								break;
							case 6:
								System.out.println("Thank you and Visit Again");
								break;
							default :
								System.out.println("Invalid input");
								break;
							}
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					else {
						System.out.println("Invaid user or password");
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		
				break;
		    case 3:
		    	try {
		    		System.out.println("Enter your first name ");
			    	String fname=sc.next();
			    	System.out.println("Enter your last name ");
			    	String lname=sc.next();
			    	System.out.println("Enter your gender ");
			    	String gender=sc.next();
			    	System.out.println("Enter your mobile no ");
			    	String mobile=sc.next();
			    	System.out.println("Enter your email ");
			    	String email=sc.next();
			    	System.out.println("Enter your username ");
			    	String user=sc.next();
			    	System.out.println("Enter password ");
			    	String pass=sc.next();
			    	System.out.println("Enter opening balance ");
			    	int balance=sc.nextInt();
			    	System.out.println("Enter Account type ");
			    	String acc=sc.next();
			    	
			    	Customer customer=new Customer(fname, lname, gender, mobile,email,user, pass, balance,acc);
			    	String message=dao.customerRegistration(customer);
			    	System.out.println(message);
					
				} catch (Exception e) {
					System.out.println("Invalid input");
				}
		    	
		    	break;
	        case 4:
	        	System.out.println("1.Forget Id ?");
	        	System.out.println("2.Forget password");
	        	System.out.println("3.Exit");
	        	try {
					
	        		int choiceReset=sc.nextInt();
	        		switch (choiceReset) {
	        		case 1:
	        			System.out.println("Enter your account number");
	        			int accId=sc.nextInt();
	        			System.out.println("Enter your aadhar number");
	        			int aadhar=sc.nextInt();
	        			System.out.println("Enter otp received on your registered mobile number");
	        			int otp=sc.nextInt();
	        			String username= dao.getUserName(accId,aadhar,otp);
	        			System.out.println(username);
	        			break;
	        		case 2:
	        			System.out.println("Enter your account number");
	        			int accId1=sc.nextInt();
	        			System.out.println("Enter your aadhar number");
	        			int aadhar1=sc.nextInt();
	        			System.out.println("Enter otp received on your registered mobile number");
	        			int otp1=sc.nextInt();
	        			String passString1= dao.getUserPassword(accId1,aadhar1,otp1);
	        			System.out.println(passString1);
	        			break;
	        		case 3:
	        			System.out.println("Thank you and Visit Again");
	        			break;
	        		default:
	        			System.out.println("Invalid input");
	        			break;
					}
	        		
	        		
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
	        	break;
            case 5:
            	System.out.println("Thank you and Visit Again");
            	break;
            default :
            	System.out.println("Invalid input");
            	break; 
            }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
