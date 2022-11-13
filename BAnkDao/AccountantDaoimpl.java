package com.BAnkDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.Bank.utility.DBUtil;
import com.BankException.CustomerException;
import com.BankModel.Customer;

public class AccountantDaoimpl implements AccountantDao{

	@Override
	public Customer customerDetails(int accNo) throws CustomerException {
		// TODO Auto-generated method stub
        Customer customer=new Customer(null, null, null, null, null, null, null, null, null, accNo);
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from customers where accountNumber=?");
			ps.setInt(1, accNo);
			
			ResultSet rs= ps.executeQuery();
			
			
			if(rs.next()) {
				String accType=rs.getString("accountType");
				String fName=rs.getString("firstName");
				String lName=rs.getString("lastName");
				String gender=rs.getString("gender");
				String mobNo=rs.getString("mobileNo");
				String email=rs.getString("email");
				String userName=rs.getString("userName");
				String pass=rs.getString("password");
				double Bal=rs.getDouble("openingBalance");
				
				customer.setAccountNumber(accNo);
				customer.setAccountType(accType);
				customer.setFirstName(fName);
				customer.setLastName(lName);
				customer.setGender(gender);
				customer.setMobileNo(mobNo);
				customer.setEmail(email);
				customer.setUsername(userName);
				customer.setPassword(pass);
				customer.setAccountBalance(Bal);
			}
			else {
				throw new CustomerException("Customer not found with account number "+accNo);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return customer;
	}

	@Override
	public String updateCustomerFirstName(int acc, String fname) throws CustomerException {
		// TODO Auto-generated method stub
		String message="Not updated";
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update customers set firstName="+"'"+fname+"'"+" where accountNumber=?");
			ps.setInt(1,acc);
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="First name updated successfully";
			}
			else {
				throw new CustomerException("Failed to update first name due Invalid input");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String updateCustomerLastName(int acc, String lname) throws CustomerException {
		// TODO Auto-generated method stub
		String message="Not updated";
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update customers set lastName="+"'"+lname+"'"+"where accountNumber=?");
			ps.setInt(1,acc);
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Last name updated successfully";
			}
			else {
				throw new CustomerException("Failed to update last name due Invalid input");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		

		return message;
	}

	@Override
	public String updateCustomerMobileNo(int acc, String mobile) throws CustomerException {
		// TODO Auto-generated method stub
		String message="Not updated";
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update customers set mobileNo="+"'"+mobile+"'"+"where accountNumber=?");
			ps.setInt(1,acc);
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Mobile number updated successfully";
			}
			else {
				throw new CustomerException("Failed to update mobile number due Invalid input");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String updateCustomerEmail(int acc, String email) throws CustomerException {
		// TODO Auto-generated method stub
		String message="Not updated";
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update customers set email="+"'"+email+"'"+"where accountNumber=?");
			ps.setInt(1,acc);
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Email updated successfully";
			}
			else {
				throw new CustomerException("Failed to update email id due Invalid input");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return message;
	}

	@Override
	public String updateCustomerUserName(int acc, String username) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCustomerPassword(int acc, String password) throws CustomerException {
		// TODO Auto-generated method stub
		String message="Not updated";
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update customers set userName="+"'"+username+"'"+"where accountNumber=?");
			ps.setInt(1,acc);
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Username updated successfully";
			}
			else {
				throw new CustomerException("Failed to update username due Invalid input");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String closeCustomerAccount(int accNo) throws CustomerException {
		// TODO Auto-generated method stub
		String message="Not deleted";
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("delete from customers where accountNumber=?");
			ps.setInt(1,accNo);
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Customer account deleted successfully";
			}
			else {
				throw new CustomerException("Invalid account number");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public List<Customer> allCustomerView() throws CustomerException {
		// TODO Auto-generated method stub
List<Customer> cusList=new ArrayList<Customer>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from customers");
	
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
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
				
				Customer cus = new Customer();
				
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

				cusList.add(cus);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(cusList.size()==0) {
			throw new CustomerException("No customer found");
		}else
		return cusList;
	}

	
}
