package com.revature.bankAPI.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankAPI.dao.interfaces.AccountDAO;
import com.revature.bankAPI.dao.interfaces.GenericBankAPIreadDAO;
import com.revature.bankAPI.dao.interfaces.UserDAO;
import com.revature.bankAPI.models.Account;
import com.revature.bankAPI.models.AccountStatus;
import com.revature.bankAPI.models.AccountType;
import com.revature.bankAPI.models.User;
import com.revature.bankAPI.services.ConnectionService;

public class AccountDAOImpl implements AccountDAO{
	private Connection connection;
	private GenericBankAPIreadDAO<AccountStatus> statusDao;
	private GenericBankAPIreadDAO<AccountType> typeDao;
	private UserDAO userDao;
	public AccountDAOImpl() {
		connection = ConnectionService.getConnection();
		statusDao = new AccountStatusDAOImpl();
		typeDao = new AccountTypeDAOImpl();
		userDao = new UserDAOImpl();
	}
	public int create(Account accnt) {
		int accntId = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Accounts "
					+ "(balance, status_ID, type_id, user_Id) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, accnt.getBalance());
			AccountStatus accntStatus=accnt.getStatus();
			ps.setInt(2, accntStatus.getStatusId());
			AccountType accntType=accnt.getType();
			ps.setInt(3,  accntType.getTypeId());
			User accntUser = accnt.getUser();
			ps.setInt(4, accntUser.getUserId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			accntId = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accntId;
		
	}
	public Account get(int id) {
		Account accnt = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Accounts "
					+ "WHERE account_id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				accnt = new Account();
				accnt.setAccountId(rs.getInt("account_id"));
				accnt.setBalance(rs.getDouble("balance"));
				int statusId = rs.getInt("status_id");
				accnt.setStatus(statusDao.get(statusId));
				int typeId = rs.getInt("type_id");
				accnt.setType(typeDao.get(typeId));
				int userId = rs.getInt("user_id");
				accnt.setUser(userDao.get(userId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accnt;
	}
	public void update(Account accnt) {
		try {
			PreparedStatement ps =connection.prepareStatement("UPDATE accounts SET "
					+ "balance = ?, status_id = ?, type_id = ?, user_id = ? "
					+ "WHERE account_id = ?;");
			ps.setDouble(1, accnt.getBalance());
			AccountStatus accntStatus = accnt.getStatus();
			ps.setInt(2, accntStatus.getStatusId());
			AccountType accntType = accnt.getType();
			ps.setInt(3, accntType.getTypeId());
			User accntUser = accnt.getUser();
			ps.setInt(4, accntUser.getUserId());
			ps.setInt(5, accnt.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(Account accnt) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM accounts WHERE account_id =?;");
			ps.setInt(1, accnt.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Account> getAccounts(AccountStatus status) {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Accounts "
					+ "WHERE status_id = ?;");
			ps.setInt(1, status.getStatusId());
			ResultSet rs = ps.executeQuery();
			ArrayList<Account> accnts = new ArrayList<Account>();
			while(rs.next()) {
				Account accnt = new Account();
				accnt.setAccountId(rs.getInt("account_id"));
				accnt.setBalance(rs.getDouble("balance"));
				accnt.setStatus(status);
				int typeId = rs.getInt("type_id");
				accnt.setType(typeDao.get(typeId));
				int userId = rs.getInt("user_id");
				accnt.setUser(userDao.get(userId));
				accnts.add(accnt);
			}
			return accnts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Account> getAccounts(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Accounts "
					+ "WHERE user_id = ?;");
			ps.setInt(1, user.getUserId());
			ResultSet rs = ps.executeQuery();
			ArrayList<Account> accnts = new ArrayList<Account>();
			while(rs.next()) {
				Account accnt = new Account();
				accnt.setAccountId(rs.getInt("account_id"));
				accnt.setBalance(rs.getDouble("balance"));
				int statusId = rs.getInt("status_id");
				accnt.setStatus(statusDao.get(statusId));    
				int typeId = rs.getInt("type_id");
				accnt.setType(typeDao.get(typeId));
				accnt.setUser(user);
				accnts.add(accnt);
			}
			return accnts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Account> getAllAccounts() {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Accounts;");
			ResultSet rs = ps.executeQuery();
			ArrayList<Account> accnts = new ArrayList<Account>();
			while(rs.next()) {
				Account accnt = new Account();
				accnt.setAccountId(rs.getInt("account_id"));
				accnt.setBalance(rs.getDouble("balance"));
				int statusId = rs.getInt("status_id");
				accnt.setStatus(statusDao.get(statusId));    
				int typeId = rs.getInt("type_id");
				accnt.setType(typeDao.get(typeId));
				int userId = rs.getInt("user_id");
				accnt.setUser(userDao.get(userId));
				accnts.add(accnt);
			}
			return accnts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
