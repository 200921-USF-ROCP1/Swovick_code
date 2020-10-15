package com.revature;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		String[] array = {"first", "second", "third"};
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("first");
		arrayList.add("second");
		arrayList.add("third");
		printArray(array);
		printList(arrayList);
	}
	public static void printList(ArrayList<String> arrayList){
		for(String element : arrayList) {
			System.out.println(element);
		}
	}
	public static void printArray(String[] array){
		for(String element : array) {
			System.out.println(element);
		}
	}
}
