import java.util.ArrayList;

public class ReavtureTest {
	public static void main(String[] args) {
		int [][] arr = new int[3][2];
		arr[0][0] = 1;
		arr[0][1] = 3;
		arr[1][0] = 2;
		arr[1][1] = 7;
		arr[2][0] = 6;
		arr[2][1] = 9;
		print2dArr(arr);
		//System.out.println(arr.length);
		int[] counts= new int[getMax(arr)];
		for (int i=0; i<arr.length; i++) {
			int start=arr[i][0];
			int end=arr[i][1];
			//int[] allSucessors = generateSuccesiveArray(start, end);
			//printArr(allSucessors);
			//System.out.println(allSucessors.length);
			//int minute;
			while (start<=end) {
				counts[start-1]++;
				start++;
			}
		}
		System.out.println(getMax(counts));
	}
	public static int[] generateSuccesiveArray(int start, int end) {
		int[] consec= new int[end-start];
		int tempVar = start;
		for (int i=0;start<=end;tempVar++) {
			consec[i]=tempVar;
		}
		return consec;
	}
	public static void print2dArr(int[][] arr){
		for (int i=0;i<arr.length;i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void printArr(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static int getMax(int[][] arr) {
		int max=-1;
		for (int i=0;i<arr.length;i++) {
			if(arr[i][1]>max) {
				max = arr[i][1];
			}
		}
		return max;
	}
	public static int getMax(int[] cnts) {
		int max=-1;
		for (int i=0;i<cnts.length;i++) {
			if(cnts[i]>max) {
				max = cnts[i];
			}
		}
		return max;
	}
}
