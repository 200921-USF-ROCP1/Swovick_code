package com.revature.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	@Test
	public void test1() {
		//Set up
		Calculator calc = new CalcImpl();{
		
		int a=3, b=2; //can have multiple declarations on same line if same type.
		int testAnswer=5;
		
		//Execute
		int actualAnswer = calc.add(a, b);
		
		Assertions.assertEquals(testAnswer, actualAnswer);
		
		//Tear Down
		}
	}
}
