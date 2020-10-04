package com.revature.peter;

public class Peter {
	//Data types are all 2^x
	
	//primitive types or value types, direct bit representation, small
	boolean bool; // 1 bit (true/false)
	byte b; // 8 bits, 2^3
	char c; // character, 16 bits, because ASCII in 16 bits
	short s; //16 bits integer, 2^4
	public int i; // 32 bits integer, 2^5
	float f; // 32 bits, standard decimal number
	long l; //64 bits integer, 2^6
	double d;// 64 bits double precision floating point
	
	// Reference types, referencing something in the heap
	//new allocates to heap which is in ram, str reference to data in the heap
	String str = new String("Hi Im new"); //char array
	Object o = new Object();
	//char[] li= {'I',' ','a','m'}; // "I am"
	//str ="hey";
	
	//Access Modifiers:
	// public
	// default
	// protected 
	// private
	
	//public methods and variables can be accessed from anywhere
	public void myMethod( ) {
		//instance method
		str.charAt(0); //'H'
		//static method
		String.valueOf(5); // "5"
	}
	
	// No access modifier = default access modifier:
	// Anything in the package can access it, package private
	void myDefaultMethod() {}
	
	// Protected means it can be accessed from inside the class
	// and any subclasses (child classes)
	protected void myProtectedMethod( ) {}
	
	// Private methods and variables cannot be seen outside
	//Only seen from inside the class
	private void myPrivateMethod() {
		
	}
	
	// Classes can only be public and default from the list above.
	// declared inside of a class, classes can be private
	
	private class PrivateClass {}
	//One instance of this class for all instances of the class it is in
	static class StaticClass {}
	
	// Constructors, no return type, return object
	// new keyword runs constructor
	// No params constructor
	public Peter() {
		System.out.println("Inside Peter constructor");
	}
	//Parameterized constructor
	public Peter(int i, char c, boolean bool) {
		this.i = i; //this.i refers to this object's i
		this.c = c;
		this.bool = bool;
	}
	
	// Java favors the most specific scope!
	//Class scope : belongs to whole class
	//Object/instance scope: belongs to specific instance
	//Method scope: belongs to specific method
	//Block scope: belongs to specific block in functions
	//i in method will overshadow class's i
	public void scopes(int i) {
		//use "this" to get to class variables
		this.i = i;
	}
	
	// Control statements
	public void control(boolean yes, int val){
		if (yes) {
			//Do something if yes is true
		} else if (val==2) {
			//Do something if val is 2
		} else {
			
		}
		//For-loops iteratre some n number of times
		// Format is: (declaration; statement that must be true to keep doing; what must be done after each iteration
		for (int i = 0; i<val; i++) {
			//Break immediately exits the loop
			break;
		}
		//++i precrement, increment value then resolve  statement
		//i++ post-crement: resolve statement, then increment the value
		for ( ; (val++) < 5; ) {} //Compare val and 5, then increment val
		for ( ; (++val) <5; ) {} //Increment val, and then compare val and 5
		for ( ; yes ;) {
			//basically a while loop
			if (val==1) {
				//skips the rest of the current iteration and goes to the next.
				continue;
			}
		}
		while (yes) {
			// Do something repeatedly while yes is true
			//Usually not good for infinite loop
		}
		do {
			// Run once, and THEN run for as long as yes is true
		} while (yes);
		
		switch (val) {
		case 0:
			// Do something if val is 0
			break; //run code, and get out of block, gets out of loop
		case 1:
			// Do something if val is 1
			break;
		case 2:
			//Do something if val is 2
			break;
		default:
			// If no other cases match, do this
			break;
		}
		
	}
}
