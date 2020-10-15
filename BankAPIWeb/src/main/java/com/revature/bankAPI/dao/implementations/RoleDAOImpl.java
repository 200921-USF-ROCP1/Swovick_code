package com.revature.bankAPI.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankAPI.dao.interfaces.GenericBankAPIreadDAO;
import com.revature.bankAPI.models.Role;
import com.revature.bankAPI.services.ConnectionService;

public class RoleDAOImpl implements GenericBankAPIreadDAO<Role>{
	private Connection connection;
	public RoleDAOImpl() {
		connection = ConnectionService.getConnection();
	}
	public Role get(int id) {
		Role usrRole = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM roles WHERE role_id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				usrRole = new Role();
				usrRole.setRoleId(id);
				usrRole.setRole(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usrRole;
	}
}