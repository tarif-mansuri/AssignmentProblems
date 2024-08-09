package com.tarif.day066.dsa.dp3.knapsack;

public class ZeroOneKnapsack {
	
	
	 public int solve(int[] v, int[] w, int W) {
			
			int[][] dp = new int[v.length+1][W+1];
			for(int i=0; i<=v.length; i++) {
				for(int j=0; j<=W; j++) {
					if(i==0 || j==0) {
						dp[i][j] = 0;
					}else if(j>=w[i-1]) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] +v[i-1]);
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			return dp[v.length][W];
		}
	
	public static void main(String[] args) {
		ZeroOneKnapsack obj = new ZeroOneKnapsack();
		int[] A = {60, 100, 120};
		int[] B = {10, 20, 30};
		System.out.println(obj.solve(A, B, 50));
	}
	
}
