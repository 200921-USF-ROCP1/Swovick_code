package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	      // Set response content type so it will always render to HTML
	      response.setContentType("text/html");
	      
	      // Do error stuff here!
	      PrintWriter pw = response.getWriter();
	      String message = (String) request.getAttribute("javax.servlet.error.message");
	      int errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	      if(errorCode==404) {
	    	  response.getWriter().println("The page you are looking for is not available.");
	      }
	      else if(errorCode==500) {
	    	  response.getWriter().println(message);
	      }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}