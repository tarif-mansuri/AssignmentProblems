package com.tarif.day067.dsa.dp4.applicationsofknapsack;

public class CoinSumInfinite {
	
	public int coinchange2(int[] A, int B) {
		int[] dp = new int[B+1];
		dp[0] = 1;
		for(int i=0; i<A.length; i++) {
			for(int j = 1; j<=B;j++) {
				if(A[i]<=j) {
					dp[j] += dp[j-A[i]];
				}
			}
			
		}
		return dp[B];
    }
	
	public static void main(String[] args) {
		CoinSumInfinite obj = new CoinSumInfinite();
		int[] A = {10};
		System.out.println(obj.coinchange2(A, 10));
	}

}
