package com.revature.finallyize;

//final class cannot be extended
public final class WhatIsFinal {
	//final variables cannot be changed after initialization
	final int b = 5; 
	
	// final methods cannot be overridden
	public final void doStuff() {
		
	}
	public void doFinally() {
		try {
			
		}
		catch(Exception e) {
			
		}
		finally {
			//This block always runs
			//even if the method has returned
		}
	}
	//finalize method, destructor,
	//runs right before the object is destroyed by the garbage collector
	@Override
	public void finalize() {
		//I will run once, upon my death
		
		//Just for logic that pertains to the program
		//low-level stuff left to JVM
		
		//This does not destroy the object at the end
		
		//Release resources here that exist for the
		//life of the method
	}
}
