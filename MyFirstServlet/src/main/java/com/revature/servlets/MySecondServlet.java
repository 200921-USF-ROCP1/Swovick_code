package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySecondServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			//write directly to response's body by doing this
			PrintWriter pw = response.getWriter();
			pw.println("<html> <form> <input type=\"text\"> </form> </html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
