package com.revature.week1Test;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = (String) sc.nextLine();
		//System.out.println(inp);
		String test= "test String";
		test.split(" ");
        String[] lst = inp.split(" ");
        int earlyIdx=0;
        int lateIdx=lst.length-1;
        /*for (int i=0; i<lst.length;i++) {
        	System.out.println(lst[i]);
        }*/
        while(earlyIdx<lateIdx){
            String temp = lst[earlyIdx];
            lst[earlyIdx]=lst[lateIdx];
            lst[lateIdx]=temp;
            earlyIdx++;
            lateIdx--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<lst.length; i++){
            sb.append(lst[i]);
            sb.append(" ");
        }
        String result=sb.toString();
        System.out.println(result);
        //int lateIdx=lst.length-1;
        System.out.println("World");
	}
}
