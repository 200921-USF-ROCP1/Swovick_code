package com.revature.bankAPI.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.bankAPI.dao.interfaces.UserDAO;
import com.revature.bankAPI.models.Account;
import com.revature.bankAPI.models.Role;
import com.revature.bankAPI.models.User;
import com.revature.bankAPI.services.ConnectionService;

public class UserDAOImpl implements UserDAO{
	private Connection connection;
	public UserDAOImpl() {
		connection = ConnectionService.getConnection();
	}
	public void create(User usr) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO users"
					+ "(username,password, first_name, last_name, email, role_id) VALUES"
					+ "(?, ?, ?, ?, ?, ?);");
			ps.setString(1, usr.getUsername());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getFirstName());
			ps.setString(4, usr.getLastName());
			ps.setString(5, usr.getEmail());
			Role usrRole = usr.getRole();
			ps.setInt(6, usrRole.getRoleID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public User get(int id) {
		User usr = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * WHERE user_id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				usr = new User();
				usr.setUsername(rs.getString("username"));
				usr.setPassword(rs.getString("password"));
				usr.setFirstName(rs.getString("first_name"));
				usr.setLastName(rs.getString("last_name"));
				usr.setEmail(rs.getString("email"));
				int roleId = rs.getInt("role_id");
				RoleDAOImpl roleDao = new RoleDAOImpl();
				Role usrRole = roleDao.get(roleId);
				usr.setRole(usrRole);
				ArrayList<Account> usrAccounts = getUserAccounts(usr);
				usr.addAccounts(usrAccounts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return usr;
	}
	public ArrayList<Account> getUserAccounts(User usr) {
		ArrayList<Account> usrAccounts = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM accounts WHERE user_id = ?;");
			ps.setInt(1, usr.getUserId());
			ResultSet rs = ps.executeQuery();
			usrAccounts = new ArrayList<Account>();
			while(rs.next()) {
				int accntId = rs.getInt("account_id");
				AccountDAOImpl accountDao = new AccountDAOImpl();
				Account currAccount = accountDao.get(accntId);
				usrAccounts.add(currAccount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usrAccounts;
		
	}
	public void update(User usr) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE users SET "
					+ "username = ?, password = ?, first_name = ?, last_name = ?, "
					+ "email = ?, role_id = ? WHERE user_id = ?;");
			ps.setString(1, usr.getUsername());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getFirstName());
			ps.setString(4, usr.getLastName());
			ps.setString(5, usr.getEmail());
			Role usrRole = usr.getRole();
			ps.setInt(6, usrRole.getRoleID());
			ps.setInt(7, usr.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void delete(User usr) {
		// TODO Auto-generated method stub
		
	}
}
