package com.revature.bankAPI;

import java.util.ArrayList;

//import java.util.Scanner;

public class User {
	private int userID; // primary key
	private String username; // not null, unique
	private String password; // not null
	private String firstName; // not null
	private String lastName; // not null
	private String email; // not null
	protected Role role;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public User(int userID, String username, String password, String firstName, String lastName, String email) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = new Role(1, "User");
		
		//accounts.add(e)
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name:");
		this.firstName*/
	}
	public void makeAccount(int accountID, double balance, String status, String type) {
		if(thisUser(userID)) {
			Account accnt = new Account(accountID, balance, status, type);
			accounts.add(accnt);
		}
	}
	public Account getAccount(int accountID) {
		Account accnt=null;
		if(thisUser(userID)) {
			for (int i=0;i<accounts.size();i++) {
				Account tempAccnt=accounts.get(i);
				if(tempAccnt.getAccountID()==accountID) {
					accnt = tempAccnt;
					break;
				}
			}
		}
		return accnt;
	}
	public void setUserName(String username, int userId) {
		if(thisUser(userId)) {
			this.username=username;
		}
	}
	public void setPassword(String password, int userId) {
		if(thisUser(userId)) {
			this.password=password;
		}
	}
	public void setFirstName(String firstName, int userId) {
		if(thisUser(userId)) {
			this.firstName=firstName;
		}
	}
	public void setLastName(String lastName, int userId) {
		if(thisUser(userId)) {
			this.lastName=lastName;
		}
	}
	public void setEmail(String email, int userId) {
		if(thisUser(userId)) {
			this.email=email;
		}
	}
	private boolean thisUser(int userId) {
		if(this.userID ==  userId) {
			return true;
		}
		else {
			return false;
		}
	}
	//test methods for User class
	int getId(){
		return this.userID;
	}
	Role getRole() {
		return this.role;
	}
	String getUserName(){
		return this.username;
	}
	String getPassword(){
		return this.password;
	}
	String getFirstName(){
		return this.firstName;
	}
	String getLastName(){
		return this.lastName;
	}
	String getEmail(){
		return this.email;
	}
}
