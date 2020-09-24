package com.revature.generic.arraylist;

public class Driver {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Hello");
		arr.add("World!");
		arr.add("How");
		arr.add("are");
		arr.add("you");
		arr.add("doing?");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		arr.add("Good!");
		Object[][] test = arr.split(5);
		// String[][] test2= (String[][])test;
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.print("[" + test[i][j] + "],");
			}
			System.out.println();
		}
		/*System.out.println(test.length);
		System.out.println(test[0].length);*/
		System.out.println(getTwoDArrayString(test));
		/*
		 * System.out.println(test.length); System.out.println(test[0].length);
		 */
		System.out.println(getTwoDArrayString(test));
	}
	public static String getTwoDArrayString(Object[][] twoDArray) {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<twoDArray.length; i++) {
			for (int j=0; j< twoDArray[i].length; j++) {
				sb.append(twoDArray[i][j]);
				
				if(j + 1 <twoDArray[i].length) {
					sb.append(", ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
