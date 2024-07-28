package com.tarif.day066.dsa.dp3.knapsack;

public class ZeroOneKnapsack {
	
	
	static int H = 0;
	public int solve(int[] A, int[] B, int C) {
		H=0;
		solveUtil(A, B, C, 0, 0);
		return H;
    }
	
	public void solveUtil(int[] v, int[] w, int W, int ind, int h){
		if(ind>=v.length) {
			return;
		}
		if(W>=w[ind]) {
			//h = h+v[ind];
			if(h+v[ind]>H) {
				H=h+v[ind];
			}
			solveUtil(v, w, W-w[ind], ind+1, h+v[ind]);
		}
		solveUtil(v, w, W, ind+1, h);	
	}
	
	public static void main(String[] args) {
		ZeroOneKnapsack obj = new ZeroOneKnapsack();
		int[] A = {60, 100, 120};
		int[] B = {10, 20, 30};
		System.out.println(obj.solveIterative(A, B, 50));
	}
	
	public int solveIterative(int[] v, int[] w, int W) {
		
		int[][] dp = new int[v.length][W];
		for(int i=0; i<v.length; i++) {
			for(int j=0; j<W; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}else if(j>=w[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] +v[i]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[v.length-1][W-1];
	}
}
