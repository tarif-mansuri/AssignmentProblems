package com.tarif.day065.dsa.dp2.twodimentional;

public class NDigitNumbers {
	//This Solution was given by TA
	public int dp[][] = new int[1001][10001];
	static int MOD = 1000000007;
	int rec(int dig, int sum) {

		if (sum < 0) {
			return 0;
		}
		if (dig == 0 && sum == 0) {
			return 1;
		}
		if (dig == 0)

			return 0;

		if (dp[dig][sum] != -1)

			return dp[dig][sum];

		int ans = 0;

		for (int i = 0; i < 10; i++) {

			ans += rec(dig - 1, sum - i);

			ans %= MOD;

		}

		return dp[dig][sum] = ans;

	}

	public int solve(int A, int B) {

		int ans = 0;

		for (int i = 0; i < A + 1; i++) {
			for (int j = 0; j < B + 1; j++)
			{
				dp[i][j] = -1;
			}
		}

		for (int i = 1; i < 10; i++) {
			ans += rec(A - 1, B - i);
			ans %= MOD;
		}

		return ans;

	}
	
	public static void main(String[] args) {
		NDigitNumbers obj = new NDigitNumbers();
		System.out.println(obj.solve(2, 10));
	}
}
