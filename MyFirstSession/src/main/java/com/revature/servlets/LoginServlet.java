package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginModel;
import com.revature.models.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			User currUser = (User) session.getAttribute("CurrUser");
			PrintWriter pw = response.getWriter();
			if (currUser != null) {
				pw.println(currUser.getUsername() + " is logged in!");
			} else {
				pw.println("No one is logged in!");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			LoginModel mainUser = new LoginModel();
			mainUser.setUsername("pswov");
			mainUser.setPassword("password");
			ObjectMapper mapper = new ObjectMapper();
			LoginModel currUser = mapper.readValue(request.getReader(), LoginModel.class);
			if (currUser.equals(mainUser)) {
				User sessionUser = new User();
				sessionUser.setUsername(currUser.getUsername());
				session.setAttribute("CurrUser", sessionUser);
				response.setStatus(201);
			} else {
				response.setStatus(400);
				response.getWriter().println("Entered invalid credentials.");
			}
		} catch (Exception e) {

		}
	}

}
