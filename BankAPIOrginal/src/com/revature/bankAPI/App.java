package com.revature.bankAPI;

public class App {
	public static void main(String[] args) {
		User first = new User(1, "jcena", "Jjjmmmsss", "John", "Cena", "jcena@gmail.com");
		System.out.println("UserID is: " + first.getId());//Expected : UserID is: 1
		System.out.println("Username is: " + first.getUserName());//Expected : Username is: jcena
		System.out.println("Password is: " + first.getPassword());//Expected : Username is: Jjjmmmsss
		System.out.println("First name is: " + first.getFirstName());//Expected : First name is: John
		System.out.println("Last name is: " + first.getLastName());//Expected : Last name is: Cena
		System.out.println("Email is: " + first.getEmail());//Expected : Email is: jcena@gmail.com
		System.out.println("Email is: " + first.getEmail());//Expected : Email is: jcena@gmail.com
		Employee second = new Employee(2, "jsmith", "Jjjmmmsss", "Joe", "Smith", "jsmith@gmail.com");
		Role secondRole = second.getRole();
		System.out.println(secondRole.getRole());
	}
}
