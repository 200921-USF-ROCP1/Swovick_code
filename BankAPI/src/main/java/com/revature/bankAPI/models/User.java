package com.revature.bankAPI.models;

import java.util.ArrayList;

public class User {
	private int userId; 
	private String username; 
	private String password; 
	private String firstName; 
	private String lastName;
	private String email; 
	private Role role;
	private ArrayList<Account> accounts;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void addAccount(Account accnt) {
		accounts.add(accnt);
	}
	public void addAccounts(ArrayList<Account> accounts) {
		this.accounts =accounts;
	}
	public Account getAccount(int id) {
		Account finalAccnt = null;
		for (int i=0; i<accounts.size(); i++) {
			Account currAccnt=accounts.get(i);
			if(currAccnt.getAccountId()==id) {
				finalAccnt=currAccnt;
				break;
			}
		}
		return finalAccnt;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
}
