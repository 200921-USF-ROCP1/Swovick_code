
import java.util.*; 
import java.lang.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static ArrayList<Integer> qualified(int N, int A[]) {
        int result=-404;
        ArrayList<Integer> marks = new ArrayList<Integer>();
        //write your Logic here:
        for (int i=0; i<A.length; i++){
            boolean qualify = true;
            for (int j=0; j<i; j++){
                if(A[i]<A[j]){
                    qualify = false;
                    break;
                }
            }
            if(qualify){
                marks.add(i);
            }
            
        }
        
        return marks;
    }
    public static void main(String[] args) {
        // INPUT [uncomment & modify if required]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int A [] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        // OUTPUT [uncomment & modify if required]
        ArrayList<Integer> marks = qualified(N,A);
        for (int i=0; i<marks.size(); i++){
            System.out.print(marks.get(i)+" ");
        }
        sc.close();
    }
}