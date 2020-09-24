package com.revature.week1Test;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String inp=sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(inp);
        int result=0;
        char[] vowelList={'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(int i=0; i<inp.length();i++){
            if(charInList(sb.charAt(i), vowelList)){
                result++;
            }
        }
        System.out.println(result);
        
        //String input=sc.nextLine();
	}
	public static boolean charInList(char c, char[] lst){
        for (int i=0; i<lst.length; i++){
            if (c==lst[i])
                return true;
        }
        return false;
    }
}
