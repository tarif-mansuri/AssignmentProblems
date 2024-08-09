package com.tarif.day066.dsa.dp3.knapsack;

public class UnboundedKnapsack {
	public int solve(int A, int[] B, int[] C) {
		int n = B.length;
		int[]dp = new int[A+1];
		//C--> Weight, B--> Values
		dp[0] = 0;
		for(int i=1; i<=A; i++) {
			for(int j=0; j<n; j++) {
				dp[i] = dp[i-1];
				if(C[j]<=i) {
					dp[i] = Math.max(dp[i], B[j]+dp[i-C[j]]);
				}
			}			
		}
		return dp[A];
    }
	
	public static void main(String[] args) {
		int A = 10;
		int[] B = {6,7};
		int[] C = {5,5};
		UnboundedKnapsack obj = new UnboundedKnapsack();
		System.out.println(obj.solve(A, B, C));
	}

}
