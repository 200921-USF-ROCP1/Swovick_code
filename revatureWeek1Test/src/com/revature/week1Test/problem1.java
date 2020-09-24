package com.revature.week1Test;

import java.util.ArrayList;
import java.util.Scanner;

public class problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
        String result;
        String input=sc.nextLine();
        char[] charArr=input.toCharArray();
        ArrayList<Character> uniqueChar = new ArrayList<Character>();
        for (int i=0; i<input.length();i++){
            char currChar=charArr[i];
            if(!uniqueChar.contains(currChar)){
                uniqueChar.add(currChar);
            }
        }
        for (int i=0; i<uniqueChar.size(); i++){
            sb.append(uniqueChar.get(i));
        }
        result=sb.toString();
        //OUTPUT [uncomment & modify if required]
        System.out.println(result);
	}
}
