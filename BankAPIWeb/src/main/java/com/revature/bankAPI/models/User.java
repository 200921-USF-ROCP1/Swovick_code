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
	// ArrayList<Account> accounts = new ArrayList<Account>();

	public User() {
	}

	public User(String username, String password, String firstName, String lastName, String email, int roleId,
			String Role) {
		setUsername(username);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setRole(new Role(roleId, Role));
	}

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

	/*public void addAccount(Account accnt) {
		accounts.add(accnt);
	}

	public void setAccount(Account accnt) {
		for (int i = 0; i < accounts.size(); i++) {
			Account currAccnt = accounts.get(i);
			if (currAccnt.getAccountId() == accnt.getAccountId()) {
				accounts.set(i, accnt);
				break;
			}
		}
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void deleteAccount(Account accnt) {
		accounts.remove(accnt);
	}

	public void deleteAccounts() {
		accounts.clear();
	}

	public Account getAccount(int id) {
		Account finalAccnt = null;
		for (int i = 0; i < accounts.size(); i++) {
			Account currAccnt = accounts.get(i);
			if (currAccnt.getAccountId() == id) {
				finalAccnt = currAccnt;
				break;
			}
		}
		return finalAccnt;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}*/

	public boolean equals(User otherUsr) {
		boolean result = false;
		String otherUsrName = otherUsr.username;
		String otherPassword = otherUsr.password;
		if (otherUsrName.equals(this.username) && otherPassword.equals(this.password)) {
			result = true;
		}
		return result;
	}
}
