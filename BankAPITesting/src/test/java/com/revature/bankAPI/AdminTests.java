package com.revature.bankAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdminTests {
	Admin admin = new Admin(3, "pswovick", "P@stw0rd", "Peter", "Swovick", "pswovick@gmail.com");;
	@Test
	public void testEmployeeVars() {
		Assertions.assertEquals(3, admin.getId());
		Assertions.assertEquals("pswovick", admin.getUserName());
		Assertions.assertEquals("P@stw0rd", admin.getPassword());
		Assertions.assertEquals("Peter", admin.getFirstName());
		Assertions.assertEquals("Swovick", admin.getLastName());
		Assertions.assertEquals("pswovick@gmail.com", admin.getEmail());
		Role employeeRole = admin.getRole();
		Assertions.assertEquals("Admin", employeeRole.getRole());
		Assertions.assertEquals(3, employeeRole.getRoleId());
	}
	@Test
	public void testUserData() {
		User usr = new User(1, "jcena", "Password", "John", "Cena", "jcena@gmail.com");
		Assertions.assertEquals("jcena", admin.getUserName(usr));
		Assertions.assertEquals("Password", admin.getPassword(usr));
		Assertions.assertEquals("John", admin.getFirstName(usr));
		Assertions.assertEquals("Cena", admin.getLastName(usr));
		Assertions.assertEquals("jcena@gmail.com", admin.getEmail(usr));
		usr.makeAccount(2, 26.00, "Open", "Checking");
		Assertions.assertEquals(26.00, admin.getBalance(usr, 2));
		Assertions.assertEquals("Open", admin.getStatus(usr, 2));
		Assertions.assertEquals("Checking", admin.getType(usr, 2));
	}
	@Test
	public void modifyUserData() {
		User usr = new User(1, "jcena", "Password", "John", "Cena", "jcena@gmail.com");
		User usr2 = new User(2, "asavage", "Apassword", "Adam", "Savage", "asavage@gmail.com");
		admin.setUserName(usr, "jjcena");
		Assertions.assertEquals("jjcena", admin.getUserName(usr));
		admin.setPassword(usr, "password");
		Assertions.assertEquals("password", admin.getPassword(usr));
		admin.setFirstName(usr, "Johnny");
		Assertions.assertEquals("Johnny", admin.getFirstName(usr));
		admin.setLastName(usr, "Cenan");
		Assertions.assertEquals("Cenan", admin.getLastName(usr));
		admin.setEmail(usr, "jjcena@gmail.com");
		Assertions.assertEquals("jjcena@gmail.com", admin.getEmail(usr));
		usr.makeAccount(2, 26.00, "Pending", "Savings");
		Assertions.assertEquals(1, admin.getStatusID(usr, 2));
		Assertions.assertEquals("Pending", admin.getStatus(usr, 2));
		Assertions.assertEquals("Savings", admin.getType(usr, 2));
		Assertions.assertEquals(2, admin.getTypeID(usr, 2));
		admin.setStatusID(usr, 2, 2);
		Assertions.assertEquals(2, admin.getStatusID(usr, 2));
		Assertions.assertEquals(26.00, admin.getBalance(usr, 2));
		admin.setStatus(usr, 2, "Open");
		Assertions.assertEquals("Open", admin.getStatus(usr, 2));
		admin.setTypeID(usr, 2, 1);
		Assertions.assertEquals(1, admin.getTypeID(usr, 2));
		admin.setType(usr, 2, "Checking");
		Assertions.assertEquals("Checking", admin.getType(usr, 2));
	}
}
