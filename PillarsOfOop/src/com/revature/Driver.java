package com.revature;

public class Driver {
	public static void main(String[] args) {
		Inheritance in= new ChildOfInheritance("Peter", 1);
		in.printSelf(); //run's child method even though Inheritance object, this is upcasting
		Inheritance in2 = new Inheritance("Bob", 1);
		ChildOfInheritance ch = new ChildOfInheritance("Paul", 1);
		
		Inheritance parentRef = new ChildOfInheritance("Jimmy", 1);
		ChildOfInheritance childRef = (ChildOfInheritance)parentRef;
		
		doTheThing(ch);
		doTheThing(in2);
		doMath(1, 2, new AbstrationImpl());
	}
	public static void doTheThing(Inheritance in) {
		in.printSelf();
	}
	public static int doMath(int a, int b, Abstraction abstraction) {
		return abstraction.add(a, b)/ abstraction.subtract(a,b);
	}
}
