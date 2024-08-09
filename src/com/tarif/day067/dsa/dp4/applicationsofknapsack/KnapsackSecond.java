package com.tarif.day067.dsa.dp4.applicationsofknapsack;

import java.util.ArrayList;

public class KnapsackSecond {
	
	//Below is the classical solution of 0-1 knapsack but what if given Capacity is too bigger
	//here the constrains are
	//1 <= N <= 500
	//1 <= C, B[i] <= 100
	//1 <= A[i] <= 50
	
	public int solve(int[] A, int[] B, int C) {
		//A--> value
		//B--> weights
		//C--> Capacity
		int[][] dp = new int[A.length+1][C+1];
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<=C; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}else if(j>=B[i]) {
					dp[i][j] = Math.max(dp[i-1][j], A[i]+dp[i-1][j-B[i]]);
				}else {
					dp[i][j] = dp[i-1][j-1];
				}
			}
		}
		return dp[A.length-1][C];
    }
	
	public static void main(String[] args) {
		KnapsackSecond obj = new KnapsackSecond();
		int[] A = {6, 10, 12};
		int[] B = {10, 20, 30};
		int C = 50;
		System.out.println(obj.solve1D(A, B, C));
	}
	
	//here the constrains are bigger
	//1 <= N <= 500
	//1 <= C, B[i] <= 10^6
	//1 <= A[i] <= 50
	
	//Instead of maintaining a 2D DP array, you can reduce it to a 1D array by iterating over the items
	//and updating the array from the back to avoid overwriting the results of the current iteration.
	
	public int solve1D(int[] A, int[] B, int C) {
		//A--> value
		//B--> weights
		//C--> Capacity
		int[] dp = new int [C+1];
		for(int i=0; i<A.length; i++) {
			for(int j=C; j>=0; j--) {
				if(j>=B[i]) {
					dp[j] = Math.max(dp[j], A[i]+dp[j-B[i]]);
				}
			}
		}
		return dp[C];
    }
}
