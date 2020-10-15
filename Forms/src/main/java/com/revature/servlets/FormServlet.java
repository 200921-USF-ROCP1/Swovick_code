package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormModel  model = new FormModel();
		model.username=request.getParameter("username");
		model.password=request.getParameter("password");
		model.food=request.getParameter("food");
		model.languages=request.getParameterValues("language");
		PrintWriter pw = response.getWriter();
		pw.println("Model Values: <br>"
				+ "Username: " +model.username
				+"<br>Password:" +model.password
				+"<br> Favorite food: " + model.food
				+"<br>SpokenLangauges: ");
		for (int i=0;i<model.languages.length; i++) {
			pw.println("<br>    "+ model.languages[i]);
		}
	}
	class FormModel {
		public String username;
		public String password;
		public String food;
		public String[] languages;
	}

}
