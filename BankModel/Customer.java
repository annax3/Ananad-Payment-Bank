package com.BankModel;

public class Customer {
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNo;
	private String email;
	private String username;
	private String password;
	private String accountType;
	private Double accountBalance;
	private int accountNumber;
	public Customer(String firstName, String lastName, String gender, String mobileNo, String email, String username,
			String password, String accountType, Double accountBalance, int accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountNumber = accountNumber;
	}
	public Customer(String fname, String lname, String gender2, String mobile, String email2, String user, String pass,
			String acc, Double balance) {
		// TODO Auto-generated constructor stub
	}
	public Customer(String fname, String lname, String gender2, String mobile, String email2, String user, String pass,
			int balance, String acc) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", mobileNo="
				+ mobileNo + ", email=" + email + ", username=" + username + ", password=" + password + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + ", accountNumber=" + accountNumber + "]";
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the accountBalance
	 */
	public Double getAccountBalance() {
		return accountBalance;
	}
	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}

















