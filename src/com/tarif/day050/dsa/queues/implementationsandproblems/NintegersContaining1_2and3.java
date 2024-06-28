package com.tarif.day050.dsa.queues.implementationsandproblems;

public class NintegersContaining1_2and3 {
	public int[] solve(int A) {
		int[] ans = new int[A];
		for (int i = 0; i < 3 && i<A; i++) {
			ans[i] = 1 + i;
		}
		if (A <= 3) {
			return ans;
		}
		int i = 0;
		int j = 3;
		while (j < A) {
			int k = ans[i++];
			if (j < A) {
				ans[j++] = Integer.parseInt(k + "1");
			}
			if (j < A) {
				ans[j++] = Integer.parseInt(k + "2");
			}
			if (j < A) {
				ans[j++] = Integer.parseInt(k + "3");
			}

		}

		return ans;
	}

	public static void main(String[] args) {
		NintegersContaining1_2and3 pn = new NintegersContaining1_2and3();
		int[] ans = pn.solve(1);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
