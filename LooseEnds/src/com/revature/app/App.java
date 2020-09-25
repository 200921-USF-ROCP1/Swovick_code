package com.revature.app;

/*
 * Annotations, including Override and Deprecated
 * final vs finalize vs finally
 * Var args (or the ...), means 0 or more arguments
 * String[] args mean 1 or more arguments
 */

public class App {
	public static void main(String[] args) {
		String a="Hello", b="there", c="friend!";
		
		String[] arr = {a, b, c};
		printArgs(arr);
		
		//printArr(); need to have argument here
		
		printVarArgs(a, b, c); //can directly pass in with elispses
		printVarArgs();
		printVarArgs(arr);
		
		// Methods like printf use them! Need amount of numbers specified in format.
		System.out.printf("%d %d %d Hello", 1, 2, 3);
	}
	public static void printArgs(String[] strings) {
		for (int i=0; i<strings.length; i++) 
			System.out.println(strings[i]); //works without {} since 1 line
		
	}
	// Var args uses ellipses instead of array symbol
	//to take 0 or more arguments
	public static void printVarArgs(String... strings) {
		for (int i=0; i<strings.length; i++) 
			System.out.println(strings[i]); //works without {} since 1 line
		
	}
	//Other params can be used, varargs must be last parameter
	//only one parameter can be varargs
	public static void nameSomeStrings(String name, String... strings) {
		
	}
}
