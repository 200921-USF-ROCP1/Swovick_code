package com.revature.bankAPI;

public class AccountType extends IsAdmin{
	 private int typeID; // primary key
	 private String type; // not null, unique
	 public AccountType(int typeID, String type) {
		 this.typeID = typeID;
		 this.type = type;
	 }
	 public String getType() {
			return this.type;
	 }
	 public int getTypeID() {
		 return this.typeID;
	 }
	 public void setTypeID (User possibleAdmin, int typeID) {
		 if(isAdmin(possibleAdmin)) {
			 this.typeID = typeID;
		 }
	 }
	 public void setType (User possibleAdmin, String type) {
		 if(isAdmin(possibleAdmin)) {
			 this.type = type;
		 }
	 }
	
}

