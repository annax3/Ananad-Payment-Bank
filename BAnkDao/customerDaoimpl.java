package com.BAnkDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Bank.utility.DBUtil;
import com.BankException.CustomerException;
import com.BankModel.Customer;

public class customerDaoimpl implements CustomerDao{

	@Override
	public String customerRegistration(Customer customer) {
		// TODO Auto-generated method stub
        String message="Please try Again";
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into customers(accountType,firstName,lastName,gender,mobileNo,email,userName,password,openingBalance) values(?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1,customer.getAccountType());
			ps.setString(2,customer.getFirstName());
			ps.setString(3,customer.getLastName());
			ps.setString(4,customer.getGender());
			ps.setString(5,customer.getMobileNo());
			ps.setString(6,customer.getEmail());
			ps.setString(7,customer.getUsername());
			ps.setString(8,customer.getPassword());
			ps.setDouble(9, customer.getAccountBalance());
			
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="Bank account registration successfully";
			}
			else {
				message="Failed to registration try again";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String fundTransefer(Customer cuss, int accNo, double amt) {
		// TODO Auto-generated method stub
String message="Error occure";
		
		
		if(cuss.getAccountBalance()<amt || amt<0) {
			message="Insuficent balance";
			return message;
		}
		
		double avlBalance=cuss.getAccountBalance()-amt;
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update customers set openingBalance="+avlBalance+ "where accountNumber=?");
			ps.setInt(1,cuss.getAccountNumber());
			int x=ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement("insert into transactions(txdAccount,txdAmount,txtDateTime,accId) values(?,?,?,?)");
			ps2.setInt(1, accNo);
			ps2.setDouble(2, amt);
			ps2.setDate(3,getCurrentDate());
			ps2.setInt(4,cuss.getAccountNumber());
			int y=ps2.executeUpdate();
			if(x>0 && y>0) {
				message="transactions successful";
			}
			else {
				message="transactions Fail";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	private java.sql.Date getCurrentDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> viewTransactions(Customer cus) throws CustomerException {
		// TODO Auto-generated method stub
List<String> li=new ArrayList<String>();
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from transactions where accId=?");
			ps.setInt(1, cus.getAccountNumber());
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int txdid=rs.getInt("txdId");
				int txdAcc=rs.getInt("txdAccount");
				int txdAmt=rs.getInt("txdAmount");
				Date da=rs.getDate("txtDateTime");
				int txdAccId=rs.getInt("accId");
				
				String txd="Transfer of "+txdAmt+" rupees from account number "+txdAcc+" on "+da+" and transaction id is "+txdid;
				li.add(txd);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(li.size()==0) {
			throw new CustomerException("No transaction yet");
		}
		else {
			return li;
		}
	}

	@Override
	public List<String> view_Last_5_Transactions(Customer cus) throws CustomerException {
		// TODO Auto-generated method stub
		List<String> li=null;
		li=new ArrayList<String>();
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from transactions where accId="+cus.getAccountNumber()+" Order by txtDateTime desc limit 5");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int txdid=rs.getInt("txdId");
				int txdAcc=rs.getInt("txdAccount");
				int txdAmt=rs.getInt("txdAmount");
				Date da=rs.getDate("txtDateTime");
				int txdAccId=rs.getInt("accId");
				
				String txd="Transfer of "+txdAmt+" rupees from account number "+txdAcc+" on "+da+" and transaction id is "+txdid;
				li.add(txd);
			}
			
				
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(li.size()==0) {
			throw new CustomerException("No transaction yet");
		}
		else if(li.size()>0 && li.size()<5){
			throw new CustomerException("5 transaction is not done yet");
		}
		else {
			return li;
		}
	}

	@Override
	public List<String> viewAccountStatements(Customer customer, int year) throws CustomerException {
		// TODO Auto-generated method stub
List<String> li=new ArrayList<String>();
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from transactions INNER JOIN customers ON accId=accountNumber AND accId="+customer.getAccountNumber()+" AND txtDateTime>'"+year+"-01-01' AND txtDateTime<'"+year+"-12-31'");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int txdid=rs.getInt("txdId");
				int txdAcc=rs.getInt("txdAccount");
				int txdAmt=rs.getInt("txdAmount");
				Date da=rs.getDate("txtDateTime");
				int txdAccId=rs.getInt("accId");
				
				String txd="Transfer of "+txdAmt+" rupees from account number "+txdAcc+" on "+da+" and transaction id is "+txdid;
				li.add(txd);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(li.size()==0) {
			throw new CustomerException("No transaction yet");
		}
		else {
			return li;
		}
	}

	@Override
	public Customer provideUserObject(String username) throws CustomerException {
		// TODO Auto-generated method stub
        Customer cus = new Customer(username, username, username, username, username, username, username, username, null, 0);
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from customers where userName=?");
			ps.setString(1, username);
			
			ResultSet rs= ps.executeQuery();
			
			
			if(rs.next()) {
				int accNo=rs.getInt("accountNumber");
				String accType=rs.getString("accountType");
				String fName=rs.getString("firstName");
				String lName=rs.getString("lastName");
				String gender=rs.getString("gender");
				String mobNo=rs.getString("mobileNo");
				String email=rs.getString("email");
				String userName=rs.getString("userName");
				String pass=rs.getString("password");
				double Bal=rs.getDouble("openingBalance");
				
				cus.setAccountNumber(accNo);
				cus.setAccountType(accType);
				cus.setFirstName(fName);
				cus.setLastName(lName);
				cus.setGender(gender);
				cus.setMobileNo(mobNo);
				cus.setEmail(email);
				cus.setUsername(userName);
				cus.setPassword(pass);
				cus.setAccountBalance(Bal);
			}else {
				throw new CustomerException("Invalid Username");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return cus;
	}

	@Override
	public String getUserName(int accId, int aadhar, int otp) {
		// TODO Auto-generated method stub
String userName="User not found";
		
		if(aadhar!=123456789 || otp!=12345) {
			return "Invalid aadhar or otp";
		}
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from customers where accountNumber=?");
			ps.setInt(1, accId);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				userName="Your user name is "+rs.getString("userName");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return userName;
	}

	@Override
	public String getUserPassword(int accId1, int aadhar1, int otp1) {
		// TODO Auto-generated method stub
String userName="User not found";
		
		if(aadhar1!=123456789 || otp1!=12345) {
			return "Invalid aadhar or otp";
		}
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from customers where accountNumber=?");
			ps.setInt(1, accId1);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				userName="Your password is "+rs.getString("password");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return userName;
	}

}
