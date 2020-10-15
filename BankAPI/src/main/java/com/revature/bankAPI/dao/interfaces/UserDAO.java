package com.revature.bankAPI.dao.interfaces;

import com.revature.bankAPI.models.User;

public interface UserDAO {
	public int create(User usr);
	
	public User get(int id);
	
	public void update(User usr);
	
	public void delete(User usr);
}
