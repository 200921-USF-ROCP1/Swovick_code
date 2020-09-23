package com.revature.calculator.generic;

public interface CalculatorGen<T> {
	// Basic operations
	public T add(T a, T b);
	
	public T subtract(T a, T b);
	
	public T multiply(T a, T b);
	
	public T divide(T a, T b);
	
	// Advanced operations
	
	// Return x to the power e
	public T exponent(T x, T e);
	// Return fib(i)
	public T fibonacci(T i);
	
	// Parse a String into parameters and an operation
	// eg, given "5 + 2", return add(5, 2)
	// Look into String.parse()
	public T parse(String s);
}
