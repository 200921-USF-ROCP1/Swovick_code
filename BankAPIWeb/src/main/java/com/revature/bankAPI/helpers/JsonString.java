package com.revature.bankAPI.helpers;

import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonString {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void printMessage(PrintWriter pw, ObjectMapper mapper, String message) {
		try {
			this.setMessage(message);
			pw.println(mapper.writeValueAsString(this));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
