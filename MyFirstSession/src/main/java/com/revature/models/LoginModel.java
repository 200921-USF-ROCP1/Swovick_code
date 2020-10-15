package com.revature.models;

public class LoginModel {
	private String username;
	private String password;
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
	public boolean equals(LoginModel usr) {
		boolean result = false;
		if(this.username.equals(usr.username) && this.password.equals(usr.password)) {
			result = true;
		}
		return result;
	}
}
