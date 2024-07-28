package com.tarif.day065.dsa.dp2.twodimentional;

public class UniqueBinarySearchTree2 {
	public int numTrees(int A) {
		if(A<=2) {
			return A;
		}
		int[] dp = new int[A+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		int ans = 0;
		for(int n=3; n<=A; n++) {
			for(int i=0; i<n; i++) {
				ans +=dp[i]*dp[n-i-1];
			}
			dp[n] = ans;
			ans = 0;
		}
		return dp[A];
    }
	
	public static void main(String[] args) {
		UniqueBinarySearchTree2 obj = new UniqueBinarySearchTree2();
		System.out.println(obj.numTrees(4));
	}
}
