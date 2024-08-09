package com.tarif.day067.dsa.dp4.applicationsofknapsack;

public class CuttingARod {
	 public int solve(int[] A) {
		 int n = A.length;
		 int[] dp = new int[n+1];
		 dp[0] = 0;
		 for(int i=1; i<=n; i++) {
			 dp[i] = dp[i-1];
			 for(int j=1; j<=i; j++) {
				 dp[i] = Math.max(dp[i], A[j-1]+dp[i-j]);
			 }	 
	    }
		 return dp[n];
	 }
	 
	 public static void main(String[] args) {
		 CuttingARod obj = new CuttingARod();
		 int[] A = {1, 5, 2, 5, 6};
		 System.out.println(obj.solve(A));
	 }
}
