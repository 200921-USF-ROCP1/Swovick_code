package com.revature.bankAPI;

public class Role {
	 private int roleId; // primary key
	 private String role; // not null, unique
	 public Role(int roleId, String role) {
		 this.roleId = roleId;
		 this.role = role;
	 }
	 public String getRole() {
		 return this.role;
	 }
	 public int getRoleId() {
		 return this.roleId;
	 }
}
