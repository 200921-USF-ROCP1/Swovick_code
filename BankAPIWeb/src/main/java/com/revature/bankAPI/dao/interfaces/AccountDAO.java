package com.revature.bankAPI.dao.interfaces;


import java.util.List;

import com.revature.bankAPI.models.Account;
import com.revature.bankAPI.models.AccountStatus;
import com.revature.bankAPI.models.User;

public interface AccountDAO {
	
	public int create(Account accnt);
	
	public Account get(int id);
	
	public List<Account> getAccounts(AccountStatus status);
	
	public List<Account> getAccounts(User user);
	
	public void update(Account accnt);
	
	public void delete(Account accnt);
	
	public List<Account> getAllAccounts();
}
