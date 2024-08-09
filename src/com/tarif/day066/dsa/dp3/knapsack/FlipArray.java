package com.tarif.day066.dsa.dp3.knapsack;

public class FlipArray {
	public int solve(final int[] A) {
		int sum = 0;
		for(int i=0; i<A.length; i++) {
			sum +=A[i];
		}
		sum = sum/2;
		Pair[][] dp = new Pair[A.length+1][sum+1];
		for(int i=0; i<=A.length; i++) {
			for(int j=0; j<=sum; j++) {
				if(i==0 || j==0) {
					dp[i][j] = new Pair(0,0);
					continue;
				}
				if(A[i-1]<=j) {
					if(dp[i-1][j].sum > dp[i-1][j-A[i-1]].sum + A[i-1]) {
						dp[i][j] = dp[i-1][j];
					}else if(dp[i-1][j].sum < dp[i-1][j-A[i-1]].sum + A[i-1]) {
						dp[i][j] = new Pair(dp[i-1][j-A[i-1]].sum + A[i-1],dp[i-1][j-A[i-1]].count+1);
					}else {
						if(dp[i-1][j].count<dp[i-1][j-A[i-1]].count+1) {
							dp[i][j] = dp[i-1][j];
						}else {
							dp[i][j] = new Pair(dp[i-1][j-A[i-1]].sum + A[i-1],dp[i-1][j-A[i-1]].count+1);
						}
					}
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[A.length][sum].count;
    }
	
	public static void main(String[] args) {
		FlipArray obj = new FlipArray();
		int[] A = {3,6,2,7,3};
		System.out.println(obj.solve(A));
	}
}
class Pair{
	int sum;
	int count;
	Pair(int sum, int count) {
		this.sum = sum;
		this.count = count;
	}
}
