package com.BankModel;

public class Accountant {
	private String Accname;	
	private String Accgender;
	private int AccPassword;
	private String AccUserName;
	
	
	public Accountant(String accname, String accgender, int accPassword, String accUserName) {
		super();
		Accname = accname;
		Accgender = accgender;
		AccPassword = accPassword;
		AccUserName = accUserName;
	}


	/**
	 * @return the accname
	 */
	public String getAccname() {
		return Accname;
	}


	/**
	 * @param accname the accname to set
	 */
	public void setAccname(String accname) {
		Accname = accname;
	}


	/**
	 * @return the accgender
	 */
	public String getAccgender() {
		return Accgender;
	}


	/**
	 * @param accgender the accgender to set
	 */
	public void setAccgender(String accgender) {
		Accgender = accgender;
	}


	/**
	 * @return the accPassword
	 */
	public int getAccPassword() {
		return AccPassword;
	}


	/**
	 * @param accPassword the accPassword to set
	 */
	public void setAccPassword(int accPassword) {
		AccPassword = accPassword;
	}


	/**
	 * @return the accUserName
	 */
	public String getAccUserName() {
		return AccUserName;
	}


	/**
	 * @param accUserName the accUserName to set
	 */
	public void setAccUserName(String accUserName) {
		AccUserName = accUserName;
	}


	@Override
	public String toString() {
		return "Accountant [Accname=" + Accname + ", Accgender=" + Accgender + ", AccPassword=" + AccPassword
				+ ", AccUserName=" + AccUserName + "]";
	}
	
	
	
}
