package com.revature.calculator;

public class CalcImpl implements Calculator{

	//@Override
	public int add(int a, int b) {
		return a+b;
	}

	//@Override
	public int subtract(int a, int b) {
		return a-b;
	}

	//@Override
	public int multiply(int a, int b) {
		return a*b;
	}

	//@Override
	public int divide(int a, int b) {
		return a/b; //Integer Division?
	}

	//@Override
	public int exponent(int x, int e) {
		int raised=1;
		for (int i=0; i<e; i++) {
			raised *=x;
		}
		return raised;
	}

	public int fibonacci(int i) {
		if(i==0||i==1) {
			return i;
		}
		else {
			return fibonacci(i-1)+ fibonacci(i-2);
		}
		
	}

	//given 5+2, return add(5,2)
	public int parse(String s) throws Exception {
		// TODO Auto-generated method stub
		String[] test=s.split(" ");
		if(Character.isDigit(test[0].charAt(0))) {
			int firstNum = Integer.parseInt(test[0]);
			int secondNum = Integer.parseInt(test[2]);
				if (s.contains("+")) {
					return add(firstNum, secondNum);
				}
				else if(s.contains("-")) {
					return subtract(firstNum, secondNum);
				}
				else if(s.contains("*")) {
					return multiply(firstNum, secondNum);
				}
				else if(s.contains("/")) {
					return divide(firstNum, secondNum);
				}
				else if(s.contains("^")||s.contains("**")) {
					return exponent(firstNum, secondNum);
				}	
		}
		else {
			if(s.contains("fib")) {
				return fibonacci(Integer.parseInt(test[1]));
			}
			else {
				Integer.parseInt(test[0]);
			}
		}
		//String test[] = s.split(" ");
		//printList(test);
		return 0;
	}
	public void printList(String[] list) {
		for (int i=0;i< list.length; i++) {
			System.out.println(list[i]);
		}
	}
	/*public int[] getInts(String s) {
		int[] list= {};
		for (int i=0; i<s.length();i++) {
			try {
				int 
			}
		}
	}*/

}
