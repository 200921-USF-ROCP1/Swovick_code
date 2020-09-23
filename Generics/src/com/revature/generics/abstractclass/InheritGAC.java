package com.revature.generics.abstractclass;

// We can implement generic, abstract class by giving a type in extends clause.
// Generics only takes reference types, have to use a wrapper class for int.
// boxing turn primitive into wrapper, unboxing turn wrapper into primitive.
public class InheritGAC extends GenericAbstractClass<Integer>{
	public Integer add(Integer a, Integer b) {
		return a + b;
	}
}
