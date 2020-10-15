package com.revature.bankAPI;

public class Employee extends User {
	
	public Employee(int userId, String username, String password, String firstName, String lastName, String email) {
		super(userId, username, password, firstName, lastName, email);
		this.role = new Role(2, "Employee");
		// TODO Auto-generated constructor stub
	}
	public int getUserID(User usr) {
		return usr.getId();
	}
	public String getUserName(User usr) {
		return usr.getUserName();
	}
	public String getPassword(User usr) {
		return usr.getPassword();
	}
	public String getFirstName(User usr) {
		return usr.getFirstName();
	}
	public String getLastName(User usr) {
		return usr.getLastName();
	}
	public String getEmail(User usr) {
		return usr.getEmail();
	}
	private Account getAccount(User usr, int accntID) {
		return usr.getAccount(accntID);
	}
	public double getBalance(User usr, int accntID) {
		Account accnt = getAccount(usr, accntID);
		return accnt.getBalance();
	}
	/*public int getAccountID(User usr, int accntID) {
		Account accnt = getAccount(usr, accntID);
		return accnt.getAccountID();
	}*/
	public String getStatus(User usr, int accntID) {
		Account accnt = getAccount(usr, accntID);
		AccountStatus status = accnt.getAccountStatus();
		return status.getStatus();
	}
	public int getStatusID(User usr, int accntID) {
		Account accnt = getAccount(usr, accntID);
		AccountStatus status = accnt.getAccountStatus();
		return status.getStatusID();
	}
	public String getType(User usr, int accntID) {
		Account accnt = getAccount(usr, accntID);
		AccountType type = accnt.getAccountType();
		return type.getType();
	}
	public int getTypeID(User usr, int accntID) {
		Account accnt = getAccount(usr, accntID);
		AccountType type = accnt.getAccountType();
		return type.getTypeID();
	}
	/*private void setRole() {
		this.role = new Role(2, "Employee");
	}*/

}
