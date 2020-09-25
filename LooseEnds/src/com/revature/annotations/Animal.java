package com.revature.annotations;

public class Animal {
	int eyeballs = 0;
	
	public void printEyeballs() {
		System.out.print("Im a basic animal");
	}
	class Bird extends Animal{
		//Annotations keywords proceded by an @
		//and they can go over classes, methods, variables, depending
		//on the annotation
		//@Override adds metadata to say the method is overriding
		@Override
		public void printEyeballs() {
			System.out.println("Probably 2");
		}
		//@Deprecated says it should not be used. Marks it as being phasing out.
		@Deprecated
		public void printEyes() {
			System.out.println("Probably 2");
		}
	}
	@MyAnnotation(AString = "AString")
	class UsesBird {
		//SuppressWarnings Suppress warnings stops compiler warnings
		//that are given by the IDE.
		@SuppressWarnings("deprecation")
		public void useBird() {
			Bird b = new Bird();
			b.printEyes();
		}
	}
}
//You can make your own annotations if you have the gumption
@interface MyAnnotation {
	String AString() default "A default value";
}