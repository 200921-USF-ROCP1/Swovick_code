package com.revature.bankAPI.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankAPI.models.User;

public interface UserDAO {
	public int create(User usr) throws SQLException;
	
	public User get(int id);
	
	public User get(String username);
	
	public void update(User usr);
	
	public void delete(User usr);
	
	public List<User> getAll();
}
