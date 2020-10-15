package com.revature.bankAPI.services;

import com.revature.bankAPI.dao.implementations.UserDAOImpl;
import com.revature.bankAPI.dao.interfaces.UserDAO;
import com.revature.bankAPI.models.User;

public class LoginService {
	public User logIn(User loggingIn) {
		String loginUsername = loggingIn.getUsername();
		UserDAO userDao = new UserDAOImpl();
		User userFromTable = userDao.get(loginUsername);
		if(userFromTable!=null && loggingIn.equals(userFromTable)) {
			return userFromTable;
		}
		return null;
	}
}
