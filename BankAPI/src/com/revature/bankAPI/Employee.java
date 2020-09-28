package com.revature.bankAPI;

public class Employee extends User {

	public Employee(int userId, String username, String password, String firstName, String lastName, String email) {
		super(userId, username, password, firstName, lastName, email);
		this.role = new Role(2, "Employee");
		// TODO Auto-generated constructor stub
	}
	/*private void setRole() {
		this.role = new Role(2, "Employee");
	}*/

}
