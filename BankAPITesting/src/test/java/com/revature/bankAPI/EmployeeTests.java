package com.revature.bankAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTests {
	Employee employ = new Employee(2, "jsmith", "P@ssw0rd", "Joe", "Smith", "jsmith@gmail.com");;
	@Test
	public void testEmployeeVars() {
		Assertions.assertEquals(2, employ.getId());
		Assertions.assertEquals("jsmith", employ.getUserName());
		Assertions.assertEquals("P@ssw0rd", employ.getPassword());
		Assertions.assertEquals("Joe", employ.getFirstName());
		Assertions.assertEquals("Smith", employ.getLastName());
		Assertions.assertEquals("jsmith@gmail.com", employ.getEmail());
		Role employeeRole = employ.getRole();
		Assertions.assertEquals("Employee", employeeRole.getRole());
		Assertions.assertEquals(2, employeeRole.getRoleId());
	}
	@Test
	public void testUserData() {
		User usr = new User(1, "jcena", "Password", "John", "Cena", "jcena@gmail.com");
		Assertions.assertEquals("jcena", employ.getUserName(usr));
		Assertions.assertEquals("Password", employ.getPassword(usr));
		Assertions.assertEquals("John", employ.getFirstName(usr));
		Assertions.assertEquals("Cena", employ.getLastName(usr));
		Assertions.assertEquals("jcena@gmail.com", employ.getEmail(usr));
		usr.makeAccount(2, 26.00, "Open", "Checking");
		Assertions.assertEquals(26.00, employ.getBalance(usr, 2));
		Assertions.assertEquals("Open", employ.getStatus(usr, 2));
		Assertions.assertEquals("Checking", employ.getType(usr, 2));
	}
}
