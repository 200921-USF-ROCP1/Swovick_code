package com.revature.bankAPI.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bankAPI.helpers.JsonString;
import com.revature.bankAPI.helpers.PrintService;
import com.revature.bankAPI.models.User;
import com.revature.bankAPI.services.AdminServices;
import com.revature.bankAPI.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String[] parts = path.split("/");
		PrintWriter pw = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		LoginService loginService = new LoginService();
		HttpSession session = request.getSession();
		JsonString jsonStr = new JsonString();
		//response.setContentType("application/json");
		switch(parts[2]) {
			case "login":
				User thisUsr = mapper.readValue(request.getReader(), User.class);
				User loggedInUsr = loginService.logIn(thisUsr);
				User sessionUser = (User) session.getAttribute("CurrUser");
				if(sessionUser!=null) {
					response.setStatus(400);
					jsonStr.printMessage(pw, mapper,"There is a user already logged in");
					//jsonStr.setMessage("There is a user already logged in");
					//pw.println(mapper.writeValueAsString(jsonStr));
					//response.sendError(400, "There is a user already logged in.");
				}
				else if(loggedInUsr!=null) {
					session.setAttribute("CurrUser", loggedInUsr);
					response.setStatus(200);
					pw.println(mapper.writeValueAsString(loggedInUsr));
				}
				else {
					response.setStatus(400);
					jsonStr.printMessage(pw, mapper, "Invalid Credentials");
					/*jsonStr.setMessage("Invalid Credentials");
					pw.println(mapper.writeValueAsString(jsonStr));*/
					//response.sendError(400, "Invalid Credentials");
				}
				break;
			case "logout":
				//User postUsr = mapper.readValue(request.getReader(), User.class);
				User currUser = (User) session.getAttribute("CurrUser");
				if(currUser!=null) {
					session.removeAttribute("CurrUser");
					response.setStatus(200);
					String message = "You have sucessfully logged out " + currUser.getUsername();
					jsonStr.printMessage(pw, mapper, message);
					/*jsonStr.setMessage("You have sucessfully logged out " + currUser.getUsername());
					pw.println(mapper.writeValueAsString(jsonStr));*/
				}
				else {
					response.setStatus(400);
					jsonStr.printMessage(pw, mapper, "There was no user logged into the session");
					/*jsonStr.setMessage("There was no user logged into the session");
					pw.println(mapper.writeValueAsString(jsonStr));*/
					//response.sendError(400, "There was no user logged into the session");
				}
				break;
			//Make sure there is an admin in the Users table before registering other users!
			case "register":
				User currUsr = (User) session.getAttribute("CurrUser");
				AdminServices adminServices = new AdminServices();
				if(adminServices.isAdmin(currUsr)){
					User registerUser = mapper.readValue(request.getReader(), User.class);
					try {
						adminServices.registerUser(registerUser);
						//pw.println(registerUser.getUserId());
						response.setStatus(201);
						pw.println(mapper.writeValueAsString(registerUser));
					} catch (SQLException e) {
						response.setStatus(400);
						jsonStr.printMessage(pw, mapper, "Invalid Fields");
						//response.sendError(400, "Invalid Fields");
					}
				}
				else {
					response.setStatus(401);
					jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
					//response.sendError(401, "The requested action is not permitted");
				}
				break;
			default:
				response.sendError(404);
				break;
		}
	}
}
