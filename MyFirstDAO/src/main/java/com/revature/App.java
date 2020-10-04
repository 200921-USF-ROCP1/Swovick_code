package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;

import com.revature.dao.implementations.ResidentDAOImpl;
import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Resident;
import com.revature.services.ConnectionService;

public class App {
	public static void main(String[] args) {
		
		try {
			//Might need this:
			//Class.forName("org.postresql.Driver");
			//The Connection objects represents our authenticated connection to our database
			//Its where Statement and PreparedStatement objects come from 
			
			
			ResidentDAO residentDAO = new ResidentDAOImpl();
			Resident res = new Resident();
			res.setFirstName("Ressy");
			res.setLastName("Ressison");
			//res.setApartment(1);
			
			residentDAO.createResident(res);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//We should close our connection at the end.
				//connection.close
				//Could also be in finally block, would need to check if connection is null
				//And surround close with another try catch block.
		finally {
			ConnectionService.closeConnection();
		}
	}
}
