package com.revature.bankAPI.services;

import java.sql.SQLException;

import com.revature.bankAPI.dao.implementations.UserDAOImpl;
import com.revature.bankAPI.dao.interfaces.UserDAO;
import com.revature.bankAPI.models.Role;
import com.revature.bankAPI.models.User;

public class AdminServices extends EmployeeServices{
	//private boolean isAdmin;
	private UserDAO userDao;
	public AdminServices() {
		userDao= new UserDAOImpl();
	}
	//Assumes that code running this confirmed the current user is an Admin.
	public void registerUser(User toRegister) throws SQLException{
		//UserDAO userDao = new UserDAOImpl();
		int userId = userDao.create(toRegister);
		toRegister.setUserId(userId);
	}
	public boolean isAdmin(User usr) {
		boolean isAdmin= false;
		Role usrRole = usr.getRole();
		if(usrRole.getRole().equals("Admin")) {
			isAdmin=true;
		}
		return isAdmin;
	}
	public void updateUser(User user) {
			userDao.update(user);
	}
}
