package com.revature.bankAPI.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.bankAPI.dao.implementations.AccountDAOImpl;
import com.revature.bankAPI.dao.implementations.UserDAOImpl;
import com.revature.bankAPI.dao.interfaces.AccountDAO;
import com.revature.bankAPI.dao.interfaces.UserDAO;
import com.revature.bankAPI.models.Account;
//import com.revature.bankAPI.models.Role;
import com.revature.bankAPI.models.User;
import com.revature.bankAPI.services.ConnectionService;

public class UserAccntDAOTesting {
	User admin;
	User employee;
	User general;
	UserDAO usrDao= new UserDAOImpl();
	@Test
	public void testUsers() {
		admin = new User("pswv", "password", "Peter", "Swovick", "pswv@gmail.com", 3, "Admin");
		int adminId = usrDao.create(admin);
		admin.setUserId(adminId);
		User adminFromTable = usrDao.get(adminId);
		getUserEquals(admin, adminFromTable);
		employee = new User("pswov", "p@ssword", "Peter", "Swovich", "pswov@gmail.com", 2, "Employee");
		employee.setUserId(adminId);
		usrDao.update(employee);
		User employeeFromTable = usrDao.get(adminId);
		getUserEquals(employee, employeeFromTable);
		User premium = new User("jsmith", "Password", "Joe", "Smith", "jsmith@yahoo.com", 4, "Premium");
		int premiumId = usrDao.create(premium);
		premium.setUserId(premiumId);
		User premiumFromTable = usrDao.get(premiumId);
		getUserEquals(premium, premiumFromTable);
		general = new User("jjsmith", "Pastword", "Joey", "Smithy", "jjsmith@yahoo.com", 1, "Standard");
		general.setUserId(premiumId);
		usrDao.update(general);
		User generalFromTable = usrDao.get(premiumId);
		//usrDao.delete(premium);
		//usrDao.delete(employee);
		getUserEquals(general, generalFromTable);
		testAccount1();
		testAccount2();
	}
	public void getUserEquals(User usr1, User usr2) {
		Assertions.assertEquals(usr1.getUserId(), usr2.getUserId());
		Assertions.assertEquals(usr1.getUsername(), usr2.getUsername());
		Assertions.assertEquals(usr1.getFirstName(), usr2.getFirstName());
		Assertions.assertEquals(usr1.getLastName(), usr2.getLastName());
		Assertions.assertEquals(usr1.getEmail(), usr2.getEmail());
		Assertions.assertEquals(usr1.getRole().getRoleId(), usr2.getRole().getRoleId());
		Assertions.assertEquals(usr1.getRole().getRole(), usr2.getRole().getRole());
	}
	public void testAccount1() {
		Account empAccnt = new Account(50.00, 1, "Pending", 1, "Checking");
		AccountDAO accountDao = new AccountDAOImpl();
		int empAccntId=accountDao.create(empAccnt, employee);
		empAccnt.setAccountId(empAccntId);
		employee.addAccount(empAccnt);
		Account empAccntTable = accountDao.get(empAccntId);
		getAccountEquals(empAccnt, empAccntTable);
		getAccountEquals(employee.getAccount(empAccntId), empAccntTable);
		Account changeEmpAccnt = new Account(20.00, 2, "Open", 2, "Savings");
		changeEmpAccnt.setAccountId(empAccntId);
		accountDao.update(changeEmpAccnt, employee);
		employee.setAccount(changeEmpAccnt);
		Account changEmpAccntTable = accountDao.get(empAccntId);
		getAccountEquals(changeEmpAccnt, changEmpAccntTable);
		getAccountEquals(employee.getAccount(empAccntId), changEmpAccntTable);
		Account empAccnt2 = new Account(40.00, 2, "Open", 1, "Checking");
		int empAccntId2=accountDao.create(empAccnt2, employee);
		empAccnt2.setAccountId(empAccntId2);
		employee.addAccount(empAccnt2);
		Account empAccntTable2 = accountDao.get(empAccntId2);
		getAccountEquals(empAccnt2, empAccntTable2);
		getAccountEquals(employee.getAccount(empAccntId2), empAccntTable2);
		Account changeEmpAccnt2 = new Account(30.00, 1, "Pending", 2, "Savings");
		changeEmpAccnt2.setAccountId(empAccntId2);
		accountDao.update(changeEmpAccnt2, employee);
		employee.setAccount(changeEmpAccnt2);
		Account changEmpAccntTable2 = accountDao.get(empAccntId2);
		getAccountEquals(changeEmpAccnt2, changEmpAccntTable2);
		getAccountEquals(employee.getAccount(empAccntId2), changEmpAccntTable2);
	}
	public void testAccount2() {
		Account genAccnt = new Account(50.00, 3, "Closed", 1, "Checking");
		AccountDAO accountDao = new AccountDAOImpl();
		int genAccntId=accountDao.create(genAccnt, general);
		genAccnt.setAccountId(genAccntId);
		general.addAccount(genAccnt);
		Account empAccntTable = accountDao.get(genAccntId);
		getAccountEquals(genAccnt, empAccntTable);
		getAccountEquals(general.getAccount(genAccntId), empAccntTable);
		Account changeGenAccnt = new Account(20.00, 4, "Denied", 2, "Savings");
		changeGenAccnt.setAccountId(genAccntId);
		accountDao.update(changeGenAccnt, general);
		general.setAccount(changeGenAccnt);
		Account changEmpAccntTable = accountDao.get(genAccntId);
		getAccountEquals(changeGenAccnt, changEmpAccntTable);
		getAccountEquals(general.getAccount(genAccntId), changEmpAccntTable);
		Account genAccnt2 = new Account(40.00, 4, "Denied", 1, "Checking");
		int genAccntId2=accountDao.create(genAccnt2, general);
		genAccnt2.setAccountId(genAccntId2);
		general.addAccount(genAccnt2);
		Account genAccntTable2 = accountDao.get(genAccntId2);
		getAccountEquals(genAccnt2, genAccntTable2);
		getAccountEquals(general.getAccount(genAccntId2), genAccntTable2);
		Account changeGenAccnt2 = new Account(30.00, 3, "Closed", 2, "Savings");
		changeGenAccnt2.setAccountId(genAccntId2);
		accountDao.update(changeGenAccnt2, general);
		general.setAccount(changeGenAccnt2);
		Account changGenAccntTable2 = accountDao.get(genAccntId2);
		getAccountEquals(changeGenAccnt2, changGenAccntTable2);
		getAccountEquals(general.getAccount(genAccntId2), changGenAccntTable2);
	}
	public void getAccountEquals(Account accnt1, Account accnt2) {
		Assertions.assertEquals(accnt1.getBalance(), accnt2.getBalance());
		Assertions.assertEquals(accnt1.getStatus().getStatusId(), accnt2.getStatus().getStatusId());
		Assertions.assertEquals(accnt1.getStatus().getStatus(), accnt2.getStatus().getStatus());
		Assertions.assertEquals(accnt1.getType().getTypeId(), accnt2.getType().getTypeId());
		Assertions.assertEquals(accnt1.getType().getType(), accnt2.getType().getType());
	}
	@AfterAll
	public static void closeConnection() {
		ConnectionService.closeConnection();
	}
}
