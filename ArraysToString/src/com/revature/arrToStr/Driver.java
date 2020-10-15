package com.revature.arrToStr;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	public static void main(String[] args) {
		Integer[] test = { 1, 2, 3 };
		System.out.println(Arrays.toString(test));
		System.out.println(Arrays.deepToString(test));
		Integer[][] test2= {{1,2,3},{4,5,6}};
		System.out.println(Arrays.toString(test2));
		System.out.println(Arrays.deepToString(test2));
		String[] test3 = { "Hello", "there", "world" };
		String[][] test4 = {{ "Hello", "there", "world!" }, {"How", "are", "you", "doing?"}};
		System.out.println(Arrays.toString(test3));
		System.out.println(Arrays.deepToString(test3));
		System.out.println(Arrays.toString(test4));
		System.out.println(Arrays.deepToString(test4));
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("Hello");
		lst.add("there");
		lst.add("world!");
		System.out.println(lst.toString());
		ArrayList<ArrayList<String>> nestedLst = new ArrayList<ArrayList<String>>();
	}
	
}
