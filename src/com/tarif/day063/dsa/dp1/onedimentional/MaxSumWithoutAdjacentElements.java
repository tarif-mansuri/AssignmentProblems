package com.tarif.day063.dsa.dp1.onedimentional;

public class MaxSumWithoutAdjacentElements {
	public int adjacent(int[][] A) {
		int[] arr = new int[A[0].length];
		for(int i=0; i<A[0].length; i++) {
			int x = A[0][i];
			int y = A[1][i];
			if(x>y) {
				arr[i] = x;
			}else {
				arr[i] = y;
			}
		}
		if(arr.length==1) {
			return arr[0];
		}
		int[] dp = new int[A[0].length];
		dp[0] = arr[0];
		dp[1] = arr[1]>arr[0] ? arr[1]:arr[0];
		for(int i=2; i<A[0].length; i++) {
			int a = dp[i-1];
			int b = arr[i] + dp[i-2];
			dp[i] = a>b?a:b;
		}
		return dp[A[0].length-1];
    }
	
	public static void main(String[] args) {
		MaxSumWithoutAdjacentElements obj = new MaxSumWithoutAdjacentElements();
		int[][] A = {{1},{2}};
		System.out.println(obj.adjacent(A));
	}
}
