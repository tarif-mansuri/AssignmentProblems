package com.tarif.day063.dsa.dp1.onedimentional;

public class MinimumNumberOfSquares {
	public int countMinSquares(int A) {
        if(A<=2){
            return A;
        }
        int[] dp = new int[A+1];
        
        for(int i=0; i<dp.length; i++) {
        	dp[i] = i;
        	for(int x = 1; x*x<=i; x++) {
        		dp[i] = Math.min(dp[i], dp[i-x*x]+1);
        	}
        }
        return dp[A];
    }
	
	public static void main(String[] args) {
		MinimumNumberOfSquares obj = new MinimumNumberOfSquares();
		System.out.println(obj.countMinSquares(10));
	}
}
