package com.revature.bankAPI.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = (String) request.getAttribute("javax.servlet.error.message");
	    //String[] parts = uri.split("/");
	    PrintWriter pw = response.getWriter();
	    pw.println(message);
	    /*int errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	    switch(errorCode) {
	    case 401:
	    	pw.println("Invalid Credentials");
	    	break;
	    case 400:
		    switch(parts[1]) {
		    	case "register":
		    		
		    		break;
		    	case "login":
		    		
		    		break;
		    }
		break;
	    }*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
