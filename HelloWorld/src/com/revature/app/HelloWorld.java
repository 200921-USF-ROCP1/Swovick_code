package com.revature.app;

import com.revature.peter.Peter; //Can have * if want everything from package.

public class HelloWorld {
	//public - can be accessed from any other context
	//static - it belongs to a class rather than an object
	//void -  return type, void means method returns nothing.
	//String[] args, A parameter arguments to the method, args is arguments 
	//given if run in the terminal, an array of strings
	public static void main(String[] args) {
		Peter p;
		System.out.println("Hello World!");
	}
}
