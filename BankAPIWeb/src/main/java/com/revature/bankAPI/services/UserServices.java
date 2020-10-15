package com.revature.bankAPI.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankAPI.dao.implementations.UserDAOImpl;
import com.revature.bankAPI.dao.interfaces.UserDAO;
import com.revature.bankAPI.models.Role;
import com.revature.bankAPI.models.User;

public class UserServices {
	private UserDAO userDao;
	public UserServices() {
		userDao = new UserDAOImpl();
	}
	public boolean isCurrUser(User user, int user_id) {
		boolean result = false;
		if(user.getUserId()==user_id) {
			result = true;
		}
		return result;
	}
	public User updateUser(User user, User currUser) {
		Role currRole = currUser.getRole();
		user.setRole(currRole);
		userDao.update(user);
		return user;
	}
	/*public User getUser(User currUser, int id) {
		if(isCurrUser(currUser, id)) {
			return userDao.get(id);
		}
		else {
			return null;
		}
	}*/
	public List<User> getUsers(){
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
