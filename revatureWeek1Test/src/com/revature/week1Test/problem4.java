package com.revature.week1Test;

import java.util.ArrayList;
import java.util.Scanner;

public class problem4 {
	public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        /*int sampleInput;
        int result = -404;
        sampleInput = sc.nextInt();*/
        System.out.println(2**5);  
        //write your Logic here
        ArrayList<Integer> lst = new ArrayList<Integer>();
        while(true){
            int element=sc.nextInt();
            if(element==-1){
                break;
            }
            else if (isOdd(element)){
                lst.add(element);
            }
        }
        
        //OUTPUT [uncomment & modify if required]
        for (int i=0;i<lst.size();i++){
            System.out.println(lst.get(i));
        }
        //System.out.println(result);
    
    }
    public static boolean isOdd(int num){
        if (num%2==0){
            return false;
        }
        else{
            return true;
        }
    }
}
