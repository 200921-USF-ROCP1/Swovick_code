package com.revature.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Apartment;
import com.revature.models.Resident;
import com.revature.services.ConnectionService;

public class ResidentDAOImpl implements ResidentDAO{
	
	Connection connection;
	
	public ResidentDAOImpl() {
		this.connection = ConnectionService.getConnection();
	}
	
	
	public void createResident(Resident resident) {
		try {
			/*Statement stmt = connection.createStatement();
			//use update since insert in DML with update
			stmt.executeUpdate("INSERT INTO residents (first_name, last_name, apartment_id) VALUES ('" 
					+ resident.getFirstName() + "', '" + resident.getLastName() + "', '" 
					+ resident.getApartment().getId()+ "');");*/
			
			//We may want to check that the Apartment exists in the Apartment table
			/*
			 * 1. We check if the apartment exists. If it doesnt, we add it (this would normally be done via apartment dao)
			 * 2. If we insert that apartment, grab its key
			 * 3. Finally, insert Resident object
			 */
			if(resident.getApartment()!=null) {
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM apartments WHERE id = ?");
				ps.setInt(1, resident.getApartment().getId());
				
				ResultSet rs = ps.executeQuery();
				if(!rs.next()) {
					// If there's no rows in the ResultSet, we have to create the apartment, typically us the following:
					// apartmentDao.createApartment(resident.getApartment());
					
					PreparedStatement apartmentStatement = connection.prepareStatement("INSERT INTO apartments "
							+ "(building_letter, room_number, monthly_rent) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
					apartmentStatement.setString(1,  resident.getApartment().getBuildingLetter());
					apartmentStatement.setInt(2, resident.getApartment().getRoomNumber());
					apartmentStatement.setDouble(3, resident.getApartment().getMonthlyRent());
					
					// Get the generated keys ResultSet
					ResultSet keys = apartmentStatement.getGeneratedKeys();
					keys.next();
					resident.getApartment().setId(keys.getInt(1));
				}
			}
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO residents (first_name, last_name, apartment_id) "
					+ "VALUES (?, ?, ?)");
			ps.setString(1, resident.getFirstName());
			ps.setString(2, resident.getLastName());
			ps.setInt(3, resident.getApartment().getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Resident getResident(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM residents WHERE id = ?");
			ps.setInt(1, id);
			
			//use execute query because DQL command
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Resident resident =  new Resident();
				resident.setId(rs.getInt("id"));
				resident.setFirstName(rs.getString("first_name"));
				resident.setLastName(rs.getString("last_name"));
				//resident.setApartmentID(rs.getInt("apartment_id"));
				
				// We need to get the Apartment from the database
				// Normally this would go in its own DAO in a getApartment() method
				//Then I would call apartmentDao.getApartment()
				PreparedStatement apartmentStatement = connection.prepareStatement("SELECT * FROM apartments WHERE id = ?");
				apartmentStatement.setInt(1, resident.getApartment().getId());
				
				//apartment result set
				ResultSet apartmentRs = apartmentStatement.executeQuery();
				if (apartmentRs.next()) {
					Apartment apartment = new Apartment();
					apartment.setId(apartmentRs.getInt("id"));
					apartment.setBuildingLetter("building_letter");
					apartment.setRoomNumber(apartmentRs.getInt("room_number"));
					apartment.setMonthlyRent(apartmentRs.getDouble("monthly_rent"));
					
					resident.setApartment(apartment);
				}
				
				return resident;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateResident(Resident resident) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE residents"
				+ "SET first_name = ?, last_name = ?, apartment_id = ?"
				+ "WHERE id =?;");
			
			//Because we have 4 ?s we need 4 sets
			ps.setString(1, resident.getFirstName());
			ps.setString(2, resident.getLastName());
			ps.setInt(3, resident.getApartment().getId());
			ps.setInt(4, resident.getId());
			
			//executeUpdate because it is a DML command
			ps.executeUpdate();
		}
		catch (Exception e) {
			
		}
		
	}

	public void deleteResident(Resident resident) {
		try {
			PreparedStatement ps =connection.prepareStatement("DELETE FROM residents WHERE id = ?;");
			ps.setInt(1, resident.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Resident> getAllResidents() {
		List<Resident> residents = new ArrayList<Resident>();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM residents "
					+ "LEFT JOIN apartments ON residents.apartment_id=apartments.id;");
			ResultSet rs =ps.executeQuery();
			while (rs.next()) {
				Resident resident = new Resident();
				resident.setId(rs.getInt("id"));
				resident.setFirstName(rs.getString("first_name"));
				resident.setLastName(rs.getString("last_name"));
				//resident.setApartmentID(rs.getInt("apartment_id"));
				//typically should just use the apartment DAO
				Apartment apartment = new Apartment();
				apartment.setId(rs.getInt("apartments.id"));
				apartment.setBuildingLetter("building_letter");
				apartment.setRoomNumber(rs.getInt("room_number"));
				apartment.setMonthlyRent(rs.getDouble("monthly_rent"));
				
				resident.setApartment(apartment);
				
				residents.add(resident);
			}
			
			return residents;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
