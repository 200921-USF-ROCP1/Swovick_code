package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet{
	
	// Serializable mean can convert to and from String
	
	// HttpServletRequest and HttpServletResponse represent
	// the HTTP request and response messages, including
	// all of the data and metadata we talked about
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 
			response.getWriter().println("Hello, servlet world!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
