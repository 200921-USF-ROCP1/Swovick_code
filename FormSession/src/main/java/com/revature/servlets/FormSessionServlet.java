package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.FormModel;


/**
 * Servlet implementation class FormSessionServlet
 */
public class FormSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		FormModel model = (FormModel) session.getAttribute("FormModel");
		PrintWriter pw = response.getWriter();
		if(model!=null) {
			pw.println("Username: " + model.getUsername() + " password: " + model.getPassword() + " Favorite Food: " + model.getFood());
			printAll(model.getLanguages(), pw);
		}
		else {
			pw.println("No form has been submitted");
		}
	}
	public void printAll(String[] list, PrintWriter pw) {
		for (int i=0;i<list.length;i++) {
			pw.println(" Language: " + list[i]);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormModel  model = new FormModel();
		model.setUsername(request.getParameter("username"));
		model.setPassword(request.getParameter("password"));
		model.setFood(request.getParameter("food"));
		model.setLanguages(request.getParameterValues("language"));
		HttpSession session = request.getSession();
		session.setAttribute("FormModel", model);
		response.setStatus(201);
	}

}
