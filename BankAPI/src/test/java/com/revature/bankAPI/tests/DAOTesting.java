package com.revature.bankAPI.tests;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.bankAPI.dao.implementations.RoleDAOImpl;
import com.revature.bankAPI.dao.interfaces.GenericBankAPIreadDAO;
import com.revature.bankAPI.models.Role;
import com.revature.bankAPI.services.ConnectionService;

public class DAOTesting {
	
	@Test
	public void testRoleDAO() {
		GenericBankAPIreadDAO<Role> roleDao = new RoleDAOImpl();
		Connection connect = ConnectionService.getConnection();
		//Role stdRole = roleDao.get(1); 
		//Assertions.assertEquals(stdRole.getRole(), "Standard");
		
	}
}
