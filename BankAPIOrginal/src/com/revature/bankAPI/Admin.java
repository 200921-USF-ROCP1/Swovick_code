package com.revature.bankAPI;

public class Admin extends Employee{

	public Admin(int userId, String username, String password, String firstName, String lastName, String email) {
		super(userId, username, password, firstName, lastName, email);
		this.role  = new Role(3, "Admin");
	}
	public void makeAccount(User usr, int accountID, double balance, String status, String type) {
		usr.makeAccount(accountID ,balance, status, type);
	}
	public void setUserName(User usr, String username) {
		usr.setUserName(username, usr.getId());
	}
	public void setPassword(User usr, String password) {
		usr.setPassword(password, usr.getId());
	}
	public void setFirstName(User usr, String firstName) {
		usr.setFirstName(firstName, usr.getId());
	}
	public void setLastName(User usr, String lastName) {
		usr.setLastName(lastName, usr.getId());
	}
	public void setEmail(User usr, String email) {
		usr.setEmail(email, usr.getId());
	}
	public Account getAccount(User usr, int accntID) {
		return usr.getAccount(accntID);
	}
	/*public void withdrawal(User usr, int accntID, double amount) throws Exception{
		Account accnt = getAccount(usr, accntID);
		accnt.withdrawal(amount);
	}*/
	/*public int getAccountID(User usr, int accntID) {
		Account accnt = getAccount(usr, accntID);
		return accnt.getAccountID();
	}*/
	public void setStatusID(User usr, int accntID, int statusID) {
		Account accnt = getAccount(usr, accntID);
		AccountStatus stats = accnt.getAccountStatus();
		stats.setStatusID(this, statusID);
	}
	public void setStatus(User usr, int accntID, String status) {
		Account accnt = getAccount(usr, accntID);
		AccountStatus stats = accnt.getAccountStatus();
		stats.setStatus(this, status);
	}
	public void setTypeID(User usr, int accntID, int typeID) {
		Account accnt = getAccount(usr, accntID);
		AccountType typ = accnt.getAccountType();
		typ.setTypeID(this, typeID);
	}
	public void setType(User usr, int accntID, String type) {
		Account accnt = getAccount(usr, accntID);
		AccountType typ = accnt.getAccountType();
		typ.setType(this, type);
	}
}
