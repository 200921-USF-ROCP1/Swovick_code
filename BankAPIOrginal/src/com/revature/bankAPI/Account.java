package com.revature.bankAPI;

public class Account {
	private int accountID;
	private double balance;
	private AccountStatus status;
	private AccountType type;
	//private boolean canWithdraw;
	public Account(int accountID, double balance, String status, String type) {
		this.accountID = accountID;
		this.balance = balance;
		this.status = newStatus(status);
		this.type = newType(type);
	}
	private AccountStatus newStatus(String status) {
		AccountStatus sta=null;
		switch(status){
			case "Pending":
				sta = new AccountStatus(1, status);
				break;
			case "Open":
				sta = new AccountStatus(2, status);
				break;
			case "Closed":
				sta = new AccountStatus(3, status);
				break;
			case "Denied":
				sta = new AccountStatus(4, status);
				break;
		}
		return sta;
	}
	private AccountType newType(String type) {
		AccountType typ=null;
		switch(type){
			case "Checking":
				typ = new AccountType(1, type);
				break;
			case "Savings":
				typ = new AccountType(2, type);
				break;
		}
		return typ;
	}
	public int getAccountID() {
		return this.accountID;
	}
	public Double getBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}
	public AccountType getAccountType() {
		return this.type;
	}
	public AccountStatus getAccountStatus() {
		return this.status;
	}
	public void withdrawal(double withdrawal) throws Exception{
		if(this.balance - withdrawal>0) {
			this.balance -=withdrawal;
		}
		else {
			throw new Exception("Withdrawal is greater than current balance.");
		}
	}
	public void deposit(double deposit) {
		this.balance += deposit;
	}
	public void transfer(double amnt, Account otherAccnt, String whoPay) {
		switch(whoPay) {
			case "this":
				try {
					this.withdrawal(amnt);
					otherAccnt.deposit(amnt);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "other":
				try {
					otherAccnt.withdrawal(amnt);
					this.deposit(amnt);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;
		}
			
	}
	/*public boolean getCanWithdraw() {
		return canWithdraw;
	}*/
	/*public boolean thisAccount(int accntID) {
		if (this.accountID == accntID) {
			return true;
		}
		else {
			return false;
		}
	}*/
}
