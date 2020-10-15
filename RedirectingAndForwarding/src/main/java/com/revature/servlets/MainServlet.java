package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().println("Hello, servlet world?");
			ServletContext context = getServletContext();
			response.getWriter().println(context.getInitParameter("MyAwesomeVariable"));
			
			ServletConfig config = getServletConfig();
			response.getWriter().println(config.getInitParameter("MyPersonalValue"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
