package com.revature.bankAPI.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.Statement;

import com.revature.bankAPI.dao.interfaces.AccountDAO;
import com.revature.bankAPI.models.Account;
import com.revature.bankAPI.models.AccountStatus;
import com.revature.bankAPI.models.AccountType;
import com.revature.bankAPI.models.User;
import com.revature.bankAPI.services.ConnectionService;

public class AccountDAOImpl implements AccountDAO{
	private Connection connection;
	public AccountDAOImpl() {
		connection = ConnectionService.getConnection();
	}
	public int create(Account accnt, User accntUser) {
		int accntId = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Accounts "
					+ "(balance, status_ID, type_id, user_Id) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, accnt.getBalance());
			AccountStatus accntStatus=accnt.getStatus();
			ps.setInt(2, accntStatus.getStatusId());
			AccountType accntType=accnt.getType();
			ps.setInt(3,  accntType.getTypeId());
			ps.setInt(4, accntUser.getUserId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			accntId = rs.getInt(1);
			/*ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			accnt.setAccountId(rs.getInt(1));*/
			
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
				AccountStatusDAOImpl statusImpl = new AccountStatusDAOImpl();
				accnt.setStatus(statusImpl.get(statusId));
				int typeId = rs.getInt("type_id");
				AccountTypeDAOImpl typeImpl = new AccountTypeDAOImpl();
				accnt.setType(typeImpl.get(typeId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accnt;
	}
	public void update(Account accnt, User accntUsr) {
		try {
			PreparedStatement ps =connection.prepareStatement("UPDATE accounts SET "
					+ "balance = ?, status_id = ?, type_id = ?, user_id = ? "
					+ "WHERE account_id = ?;");
			ps.setDouble(1, accnt.getBalance());
			AccountStatus accntStatus = accnt.getStatus();
			ps.setInt(2, accntStatus.getStatusId());
			AccountType accntType = accnt.getType();
			ps.setInt(3, accntType.getTypeId());
			ps.setInt(4, accntUsr.getUserId());
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
}
