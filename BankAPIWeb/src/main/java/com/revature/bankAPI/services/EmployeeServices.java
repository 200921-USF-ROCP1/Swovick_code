package com.revature.bankAPI.services;

import java.util.List;

import com.revature.bankAPI.dao.implementations.UserDAOImpl;
import com.revature.bankAPI.dao.interfaces.UserDAO;
import com.revature.bankAPI.models.Role;
import com.revature.bankAPI.models.User;

public class EmployeeServices extends UserServices{
	private UserDAO userDao;
	public EmployeeServices() {
		userDao = new UserDAOImpl();
	}
	/*public EmployeeServices(User usr) {
		userDao = new UserDAOImpl();
		Role usrRole = usr.getRole();
		if(usrRole.getRole().equals("Employee")) {
			isEmployee=true;
		}
		else {
			isEmployee=false;
		}
	}*/
	/*public boolean isAdmin() {
		return isEmployee;
	}*/
	public List<User> getUsers(){
		//userDao = new UserDAOImpl();
		return userDao.getAll();
	}
	public User getUser(int id) {
		return userDao.get(id);
	}
	public boolean isEmployee(User usr) {
		Role usrRole = usr.getRole();
		boolean isEmployee;
		if(usrRole.getRole().equals("Employee")) {
			isEmployee=true;
		}
		else {
			isEmployee=false;
		}
		return isEmployee;
	}
}
