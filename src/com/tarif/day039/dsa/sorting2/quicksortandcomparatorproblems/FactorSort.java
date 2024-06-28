package com.tarif.day039.dsa.sorting2.quicksortandcomparatorproblems;

import java.util.Arrays;


//	You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.
//	
//	Note: You cannot use any extra space
//	
//	
//	Problem Constraints
//	1 <= N <= 104
//	1 <= A[i] <= 104
//	
//	
//	Input Format
//	First argument A is an array of integers.
//	
//	
//	Output Format
//	Return an array of integers.
//	
//	
//	Example Input
//	Input 1:
//	A = [6, 8, 9]
//	Input 2:
//	A = [2, 4, 7]
//	
//	
//	Example Output
//	Output 1:
//	[9, 6, 8]
//	Output 2:
//	[2, 7, 4]
//	
//	
//	Example Explanation
//	For Input 1:
//	The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
//	For Input 2:
//	The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.

public class FactorSort {
	private static final int LIMIT = 10001;
	private static int[] factorCountOf = new int[LIMIT];
	private static int[] spfOf = new int[LIMIT];
	static {
		
		//populate spf
		for(int i=1; i<LIMIT; i++) {
			spfOf[i] = i;
		}
		for(int i=2; i*i<LIMIT; i++) {
			for(int j=i*i; j<LIMIT; j +=i) {
				if(spfOf[j] == j && j%i==0) {
					spfOf[j] = i;
				}
			}
		}
		
		//populate factors
		for(int i = 2; i<LIMIT; i++) {
			int n = i;
			int ans = 1;
			while(n>1) {
				int spf = spfOf[n];
				int count =0;
				while(n%spf ==0) {
					count++;
					n = n/spf;
				}
				ans = ans*(count+1);
			}
			factorCountOf[i] = ans;
		}
	}
	public int[] solve(int[] A) {
		Integer[] arr = new Integer[A.length];
		for(int i=0; i<A.length; i++) {
			arr[i] = A[i];
		}
		Arrays.sort(arr,(Integer x, Integer y)->{
            if(factorCountOf[x]-factorCountOf[y]<0){
                return -1;
            }else if(factorCountOf[x]-factorCountOf[y]>0){
                return 1;
            }else{
                return 0;
            }
        });
		for(int i=0; i<A.length; i++) {
			A[i] = arr[i];
		}
		return A;
    }
	public static void main(String[] args) {
		int[] A = {36,13,13,26,37,28,27,43,7};
		FactorSort fs = new FactorSort();
		fs.solve(A);
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}

}
