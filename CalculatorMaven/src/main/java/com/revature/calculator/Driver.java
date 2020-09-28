package com.revature.calculator;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.util.Scanner;

public class Driver {
	/*
	 * Using your Calculator implementation,
	 * add exception handling to it and complete
	 * the method calculate() below.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator!");
		System.out.println("Enter stop to finish using the Calculator.");
		System.out.println("Enter your command below:");
		boolean keepLooping = true;
		// The calculate method is run in an infinite loop, 
		// i.e. until the program ends
		Scanner scan = new Scanner(System.in);
		CalcImpl calc = new CalcImpl();
		while (keepLooping) {
			keepLooping = calculate(scan, calc);
		}
	}
	
	/*
	 * Calculate should:
	 * 1. Take input via the Scanner class
	 * 2. Parse the input (this is a part of the Calculator interface)
	 * 3. If it is valid input, output the result
	 * 4. If it is invalid, output an error
	 * 
	 * Because it is in an infinite loop, you only need 
	 * to do those four steps.
	 */
	public static boolean calculate(Scanner scan, CalcImpl calc) {
		String input=scan.nextLine();
		if (input.equals("stop")){
			return false;
		}
		try{
			int result = calc.parse(input);
			System.out.println(result);
			System.out.println("Enter a new command below or enter stop to finish:");
		}
		catch(Exception e) {
			e.printStackTrace();
			//scan.close();
			return false;
		}
		return true;
		/*finally {
			scan.close();
		}*/
		//scan.close();
		//return true;
	}
}
