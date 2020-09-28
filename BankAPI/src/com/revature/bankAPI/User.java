package com.revature.bankAPI;

//import java.util.Scanner;

public class User {
	private int userId; // primary key
	private String username; // not null, unique
	private String password; // not null
	private String firstName; // not null
	private String lastName; // not null
	private String email; // not null
	protected Role role;
	public User(int userId, String username, String password, String firstName, String lastName, String email) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = new Role(1, "User");
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name:");
		this.firstName*/
	}
	public void setUsrName(String username, int userId) {
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
		if(this.userId ==  userId) {
			return true;
		}
		else {
			return false;
		}
	}
	//test methods for User class
	int getId(){
		return this.userId;
	}
	Role getRole() {
		return this.role;
	}
	String getUsrName(){
		return this.username;
	}
	String getPasswrd(){
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
