package com.revature.generic.arraylist;

public class ArrayList<T> {
	T[] arr;
	public ArrayList() {
		arr = (T[])(new Object[5]);
	}
	public void add(T t) {
		if (arr[arr.length-1]!=null) {
			resizeArray();
		}
		int i=size();
		arr[i] = t;
	}
	public void resizeArray(){
		T[] newArr = (T[]) new Object[arr.length*2];
		for (int i=0; i<arr.length; i++) {
			newArr[i]=arr[i];
		}
		arr=newArr;
	}
	public T get(int i) {
		return arr[i];
	}
	public int size() {
		int i=0;
		while(arr[i]!=null) {
			i++;
		}
		return i;
	}
	/*
	 * Split should take arr, split into a number of subarrays.
	 * The number is given by numberOfNewArrays.
	 * 
	 *  eg. if [1, 5, 6, 5, 7] and input 3
	 *  so the output would be :
	 *  [
	 *  	[1,5]
	 *  	[6,5]
	 *  	[7, null]
	 *  ]
	 */
	public T[][] split(int numNewArr){
		int k=0;
		int oldSize=size();
		int newSize=oldSize/numNewArr +oldSize%numNewArr;
		T[][] newArr = (T[][]) new Object[numNewArr][newSize];
		for (int i=0; i<numNewArr; i++){
			for (int j=0; j<newSize; j++) {
				if(k<oldSize) {
					newArr[i][j]=arr[k];
					k++;
				}
				else {
					newArr[i][j]=null;
				}
			}
		}
		return newArr;
	}
	
}
