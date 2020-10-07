package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			//String queryParams = request.getQueryString();
			//String url = "http://localhost:8080/RedirectingAndForwarding/main";
			response.sendRedirect("http://localhost:8080/RedirectingAndForwarding/main");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
