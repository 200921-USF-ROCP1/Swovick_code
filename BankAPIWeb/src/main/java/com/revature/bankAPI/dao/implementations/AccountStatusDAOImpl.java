package com.revature.bankAPI.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankAPI.dao.interfaces.GenericBankAPIreadDAO;
import com.revature.bankAPI.models.AccountStatus;
import com.revature.bankAPI.services.ConnectionService;

public class AccountStatusDAOImpl implements GenericBankAPIreadDAO<AccountStatus>{
	private Connection connection;
	public AccountStatusDAOImpl() {
		connection = ConnectionService.getConnection();
	}
	public AccountStatus get(int id) {
		// TODO Auto-generated method stub
		AccountStatus accntStatus = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM account_statuses WHERE status_id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				accntStatus = new AccountStatus();
				accntStatus.setStatusId(id);
				accntStatus.setStatus(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accntStatus;
	}
}
