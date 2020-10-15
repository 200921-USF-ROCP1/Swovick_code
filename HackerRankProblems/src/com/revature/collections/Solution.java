package com.revature.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
    //ArrayList<ArrayList<Integer>> twoDArrayList = make2DArrayList(scan);
    int numOfRows = scan.nextInt();
    //scan.nextLine();
    ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<numOfRows; i++){
        int numOfColumns = scan.nextInt();
        ArrayList<Integer> currRow = new ArrayList();
        for (int j=0; j<numOfColumns; j++){
            int currElement = scan.nextInt();
            currRow.add(currElement);
        }
        twoDArrayList.add(currRow);
        scan.nextLine();
    }
    System.out.println(twoDArrayList.isEmpty());
    int numOfQueries = scan.nextInt();
    scan.nextLine();
    for (int j=0;j<numOfQueries; j++){
        int x = scan.nextInt();
        int y = scan.nextInt();
        if(x<twoDArrayList.size()){
            ArrayList<Integer> currRow = twoDArrayList.get(x);
            if(y<currRow.size()){
                System.out.println(currRow.get(y));
            } else{
                System.out.println("ERROR!");
            }
        } else{
            System.out.println("ERROR!");
        }
    }
    
}
}
