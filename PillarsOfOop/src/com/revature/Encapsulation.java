package com.revature;
/*
 * We use Encapsulation to protect data from misuse
 * via getters and setters.
 */


public class Encapsulation {
	private int i, j, k;
	private String name;
	//getters get values of private variables
	public int getI() {
		return i;
	}
	//Getters and setters can be public, but can also be 
	//default or protected depending on need.
	protected void setI(int i) {
		this.i=i;
	}
	public String getName() {
		return name;
	}
	//setters set a private variable to a new value.
	public void setName(String name) {
		this.name=name;
	}
}
