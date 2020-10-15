package com.revature.bankAPI.models;

public class Account {
	private int accountId; 
	private double balance;
	private AccountStatus status;
	private AccountType type;
	private User user;
	public Account() {}
	public Account(double balance, int StatusId, String status, int TypeId, String type) {
		setBalance(balance);
		setStatus(new AccountStatus(StatusId, status));
		setType(new AccountType(TypeId, type));
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
}
