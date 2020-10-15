package com.revature.bankAPI.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bankAPI.helpers.JsonString;
import com.revature.bankAPI.helpers.StringUtils;
import com.revature.bankAPI.models.User;
import com.revature.bankAPI.services.AdminServices;
import com.revature.bankAPI.services.EmployeeServices;
import com.revature.bankAPI.services.UserServices;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
    private EmployeeServices empServices;
    private AdminServices adminServices;
    private UserServices userServices;
    private JsonString jsonStr;
    public UserServlet() {
    	//super();
    	empServices = new EmployeeServices();
    	adminServices = new AdminServices();
    	userServices = new UserServices();
    	jsonStr = new JsonString();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String[] parts = path.split("/");
		HttpSession session = request.getSession();
		User currUser = (User) session.getAttribute("CurrUser");
		//JsonString jsonStr = new JsonString();
		//empServices = new EmployeeServices(currUser);
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		if(currUser!=null) {
			if(parts.length==3) {
				if(adminServices.isAdmin(currUser) || empServices.isEmployee(currUser)) {
					List<User> allUsers = empServices.getUsers();
					pw.println(mapper.writeValueAsString(allUsers));
					response.setStatus(200);
				}
				else {
					response.setStatus(401);
					jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
					//response.sendError(401, "The requested action is not permitted");
				}
			}
			else if (parts.length==4) {
				if(StringUtils.isInteger(parts[3])) {
					int user_id = Integer.parseInt(parts[3]);
					if(adminServices.isAdmin(currUser) || empServices.isEmployee(currUser) 
							|| userServices.isCurrUser(currUser, user_id)) {
						User userToGet= empServices.getUser(user_id);
						pw.println(mapper.writeValueAsString(userToGet));
						response.setStatus(200);
					}
					else {
						response.setStatus(401);
						jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
						//response.sendError(401, "The requested action is not permitted.");
					}
				}
				else {
					response.setStatus(400);
					jsonStr.printMessage(pw, mapper, "User id entered was not a number");
					//response.sendError(400, "User id entered was not a number.");
				}
			}
			else {
				//response.setStatus(404);
				response.sendError(404);
			}
		}
		else {
			response.setStatus(400);
			jsonStr.printMessage(pw, mapper, "There was no user logged into the session");
			//response.sendError(400, "There was no user logged into the session.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String[] parts = path.split("/");
		HttpSession session = request.getSession();
		User currUser = (User) session.getAttribute("CurrUser");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		if(currUser!=null) {
			if(parts.length==3) {
				//pw.println("Before mapper");
				User updatedUser = mapper.readValue(request.getReader(), User.class);
				if(adminServices.getUser(updatedUser.getUserId())!=null) {
					if(adminServices.isAdmin(currUser)) {
						adminServices.updateUser(updatedUser);
						response.setStatus(200);
						pw.println(mapper.writeValueAsString(updatedUser));
					}
					else if (userServices.isCurrUser(currUser, updatedUser.getUserId())) {
						User stndrdUpdatedUser = userServices.updateUser(updatedUser, currUser);
						response.setStatus(200);
						pw.println(mapper.writeValueAsString(stndrdUpdatedUser));
					}
					else {
						response.setStatus(401);
						jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
						//response.sendError(401, "The requested action is not permitted.");
					}
				}
				else {
					response.setStatus(400);
					jsonStr.printMessage(pw, mapper, "The user entered does not exist");
				}
			}
			else {
				//response.setStatus(404);
				response.sendError(404);
			}
		}
		else {
			response.setStatus(400);
			jsonStr.printMessage(pw, mapper, "There was no user logged into the session");
			//response.sendError(400, "There was no user logged into the session.");
		}
	}
}
