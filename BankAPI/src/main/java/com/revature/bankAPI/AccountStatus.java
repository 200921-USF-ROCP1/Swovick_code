package com.revature.bankAPI;

public class AccountStatus extends IsAdmin {
	 private int statusID; // primary key
	 private String status; // not null, unique
	 public AccountStatus(int statusID, String status) {
		 this.statusID = statusID;
		 this.status = status;
		 //this.role = role;
	 }
	 public int getStatusID() {
		 return this.statusID;
	 }
	 public String getStatus() {
		 return this.status;
	 }
	 public void setStatusID(User possibleAdmin, int statusID) {
		 if(isAdmin(possibleAdmin)) {
			 this.statusID = statusID;
		 }
	 }
	 public void setStatus(User possibleAdmin, String status) {
		 if(isAdmin(possibleAdmin)) {
			 this.status = status;
		 }
	 }
	 /*private boolean isAdmin(User admin) {
		 Role adminRole = admin.getRole();
		 String aRole = adminRole.getRole();
		 if(aRole.equals("Admin")) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }*/
}
