package com.revature.bankAPI;

public abstract class IsAdmin {
	protected boolean isAdmin(User admin) {
		 Role adminRole = admin.getRole();
		 String aRole = adminRole.getRole();
		 if(aRole.equals("Admin")) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
}
