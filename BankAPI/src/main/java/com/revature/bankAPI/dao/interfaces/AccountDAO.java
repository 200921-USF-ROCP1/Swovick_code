package com.revature.bankAPI.dao.interfaces;


import com.revature.bankAPI.models.Account;
import com.revature.bankAPI.models.User;

public interface AccountDAO {
	
	public int create(Account accnt, User usr);
	
	public Account get(int id);
	
	public void update(Account accnt, User usr);
	
	public void delete(Account accnt);
}
