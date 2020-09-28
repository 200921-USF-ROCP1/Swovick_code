package com.revature.bankAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTests {
	User usr = new User(1, "jcena", "Password", "John", "Cena", "jcena@gmail.com");
	User usr2 = new User(2, "asavage", "Apassword", "Adam", "Savage", "asavage@gmail.com");
	@Test
	public void testUserConstructor() {
		Assertions.assertEquals(1, usr.getId());
		Assertions.assertEquals("jcena", usr.getUserName());
		Assertions.assertEquals("Password", usr.getPassword());
		Assertions.assertEquals("John", usr.getFirstName());
		Assertions.assertEquals("Cena", usr.getLastName());
		Assertions.assertEquals("jcena@gmail.com", usr.getEmail());
		Role userRole = usr.getRole();
		Assertions.assertEquals("User", userRole.getRole());
		Assertions.assertEquals(1, userRole.getRoleId());
	}
	@Test
	public void testUserSetters() {
		usr.setUserName("jjcena", 2);
		Assertions.assertEquals("jcena", usr.getUserName());
		usr.setUserName("jjcena", 1);
		Assertions.assertEquals( "jjcena", usr.getUserName());
		usr.setPassword("password", 2);
		Assertions.assertEquals( "Password", usr.getPassword());
		usr.setPassword("password", 1);
		Assertions.assertEquals("password", usr.getPassword());
		usr.setFirstName("Johnny", 2);
		Assertions.assertEquals("John", usr.getFirstName());
		usr.setFirstName("Johnny", 1);
		Assertions.assertEquals("Johnny",usr.getFirstName());
		usr.setLastName("Cenan", 2);
		Assertions.assertEquals("Cena",usr.getLastName());
		usr.setLastName("Cenan", 1);
		Assertions.assertEquals("Cenan", usr.getLastName());
		usr.setEmail("jcenan@gmail.com", 2);
		Assertions.assertEquals("jcena@gmail.com", usr.getEmail());
		usr.setEmail("jcenan@gmail.com", 1);
		Assertions.assertEquals("jcenan@gmail.com", usr.getEmail());
	}
	@Test
	public void testUser2Constructor() {
		Assertions.assertEquals(usr2.getId(), 2);
		Assertions.assertEquals(usr2.getUserName(), "asavage");
		Assertions.assertEquals(usr2.getPassword(), "Apassword");
		Assertions.assertEquals(usr2.getFirstName(), "Adam");
		Assertions.assertEquals(usr2.getLastName(), "Savage");
		Assertions.assertEquals(usr2.getEmail(), "asavage@gmail.com");
		Role userRole = usr2.getRole();
		Assertions.assertEquals(userRole.getRole(), "User");
		Assertions.assertEquals(userRole.getRoleId(), 1);
	}
	@Test
	public void testUser2Setters() {
		usr2.setUserName("aasavage", 1);
		Assertions.assertEquals("asavage", usr2.getUserName());
		usr2.setUserName("aasavage", 2);
		Assertions.assertEquals("aasavage", usr2.getUserName());
		usr2.setPassword("AnotherPassword", 1);
		Assertions.assertEquals("Apassword", usr2.getPassword());
		usr2.setPassword("AnotherPassword", 2);
		Assertions.assertEquals("AnotherPassword", usr2.getPassword());
		usr2.setFirstName("Adema", 1);
		Assertions.assertEquals("Adam", usr2.getFirstName());
		usr2.setFirstName("Adema", 2);
		Assertions.assertEquals("Adema", usr2.getFirstName());
		usr2.setLastName("Savages", 1);
		Assertions.assertEquals("Savage", usr2.getLastName());
		usr2.setLastName("Savages", 2);
		Assertions.assertEquals("Savages", usr2.getLastName());
		usr2.setEmail("asavages@gmail.com", 1);
		Assertions.assertEquals("asavage@gmail.com", usr2.getEmail());
		usr2.setEmail("asavages@gmail.com", 2);
		Assertions.assertEquals("asavages@gmail.com", usr2.getEmail());
	}
	@Test
	public void testUserAccntsVars() {
		usr.makeAccount(1, 20.00, "Pending", "Checking");
		usr.makeAccount(2, 26.00, "Open", "Savings");
		usr.makeAccount(3, 21.00, "Closed", "Checking");
		usr.makeAccount(4, 22.00, "Denied", "Savings");
		Account accnt1 = usr.getAccount(1);
		Assertions.assertEquals(1, accnt1.getAccountID());
		Assertions.assertEquals(20.00, accnt1.getBalance());
		AccountStatus accnt1Status = accnt1.getAccountStatus();
		Assertions.assertEquals(1, accnt1Status.getStatusID());
		Assertions.assertEquals("Pending", accnt1Status.getStatus());
		AccountType accnt1Type = accnt1.getAccountType();
		Assertions.assertEquals(1, accnt1Type.getTypeID());
		Assertions.assertEquals("Checking", accnt1Type.getType());
		Account accnt2 = usr.getAccount(2);
		Assertions.assertEquals(2, accnt2.getAccountID());
		Assertions.assertEquals(26.00, accnt2.getBalance());
		AccountStatus accnt2Status = accnt2.getAccountStatus();
		Assertions.assertEquals(2, accnt2Status.getStatusID());
		Assertions.assertEquals("Open", accnt2Status.getStatus());
		AccountType accnt2Type = accnt2.getAccountType();
		Assertions.assertEquals(2, accnt2Type.getTypeID());
		Assertions.assertEquals("Savings", accnt2Type.getType());
		Account accnt3 = usr.getAccount(3);
		AccountStatus accnt3Status = accnt3.getAccountStatus();
		Assertions.assertEquals(3, accnt3Status.getStatusID());
		Assertions.assertEquals("Closed", accnt3Status.getStatus());
		Account accnt4 = usr.getAccount(4);
		AccountStatus accnt4Status = accnt4.getAccountStatus();
		Assertions.assertEquals(4, accnt4Status.getStatusID());
		Assertions.assertEquals("Denied", accnt4Status.getStatus());
	}
	@Test
	public void testTransactions() {
		usr.makeAccount(2, 26.00, "Open", "Checking");
		usr.makeAccount(3, 52.00, "Open", "Savings");
		usr2.makeAccount(5, 40.00, "Open", "Checking");
		Account accnt1 = usr.getAccount(2);
		Account accnt2 = usr.getAccount(3);
		Account badAccnt = usr.getAccount(5);
		Account accnt3 = usr2.getAccount(5);
		Assertions.assertEquals(null, badAccnt);
		accnt1.deposit(15.00);
		Assertions.assertEquals(41.00, accnt1.getBalance());
		try {
			accnt1.withdrawal(10);
		} catch (Exception e) {
			System.out.println("Withrdrawal too big for account 1");
		}
		Assertions.assertEquals(31.00, accnt1.getBalance());
		try {
			accnt1.withdrawal(32.00);
		} catch (Exception e) {
			System.out.println("Withrdrawal too big for account 1");
		}
		Assertions.assertEquals(31.00, accnt1.getBalance());
		accnt2.deposit(10);
		Assertions.assertEquals(62.00, accnt2.getBalance());
		try {
			accnt2.withdrawal(5);
		} catch (Exception e) {
			System.out.println("Withrdrawal too big for account 2");
		}
		Assertions.assertEquals(57, accnt2.getBalance());
		try {
			accnt2.withdrawal(73.00);
		} catch (Exception e) {
			System.out.println("Withrdrawal too big for account 2");
		}
		accnt3.deposit(10);
		Assertions.assertEquals(50.00, accnt3.getBalance());
		try {
			accnt3.withdrawal(5);
		} catch (Exception e) {
			System.out.println("Withrdrawal too big for account 3");
		}
		Assertions.assertEquals(45, accnt3.getBalance());
		try {
			accnt3.withdrawal(73.00);
		} catch (Exception e) {
			System.out.println("Withrdrawal too big for account 3");
		}
		accnt1.transfer(10, accnt2, "this"); //accnt1: 21.00 accnt2: 67.00
		Assertions.assertEquals(21, accnt1.getBalance());
		Assertions.assertEquals(67, accnt2.getBalance());
		accnt1.transfer(10, accnt2, "other"); //accnt1: 31.00 accnt2: 57.00
		Assertions.assertEquals(31, accnt1.getBalance());
		Assertions.assertEquals(57, accnt2.getBalance());
		accnt1.transfer(32, accnt2, "this");
		Assertions.assertEquals(31, accnt1.getBalance());
		Assertions.assertEquals(57, accnt2.getBalance());
		accnt1.transfer(58, accnt2, "other");
		Assertions.assertEquals(31, accnt1.getBalance());
		Assertions.assertEquals(57, accnt2.getBalance());
		accnt1.transfer(10, accnt3, "this"); //accnt1: 21.00 accnt3: 55.00
		Assertions.assertEquals(21, accnt1.getBalance());
		Assertions.assertEquals(55, accnt3.getBalance());
		accnt1.transfer(10, accnt3, "other"); //accnt1: 31.00 accnt2: 45.00
		Assertions.assertEquals(31, accnt1.getBalance());
		Assertions.assertEquals(45, accnt3.getBalance());
		accnt1.transfer(32, accnt3, "this");
		Assertions.assertEquals(31, accnt1.getBalance());
		Assertions.assertEquals(45, accnt3.getBalance());
		accnt1.transfer(58, accnt3, "other");
		Assertions.assertEquals(31, accnt1.getBalance());
		Assertions.assertEquals(45, accnt3.getBalance());
	}
	/*public static void main(String[] args) {
		User first = new User(1, "jcena", "Jjjmmmsss", "John", "Cena", "jcena@gmail.com");
		System.out.println("UserID is: " + first.getId());//Expected : UserID is: 1
		System.out.println("Username is: " + first.getUsrName());//Expected : Username is: jcena
		System.out.println("Password is: " + first.getPasswrd());//Expected : Username is: Jjjmmmsss
		System.out.println("First name is: " + first.getFirstName());//Expected : First name is: John
		System.out.println("Last name is: " + first.getLastName());//Expected : Last name is: Cena
		System.out.println("Email is: " + first.getEmail());//Expected : Email is: jcena@gmail.com
		System.out.println("Email is: " + first.getEmail());//Expected : Email is: jcena@gmail.com
		Employee second = new Employee(2, "jsmith", "Jjjmmmsss", "Joe", "Smith", "jsmith@gmail.com");
		Role secondRole = second.getRole();
		System.out.println(secondRole.getRole());
	}*/
}
