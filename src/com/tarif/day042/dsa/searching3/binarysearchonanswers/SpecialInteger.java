package com.tarif.day042.dsa.searching3.binarysearchonanswers;

public class SpecialInteger {
	public int solve(int[] A, int B) {
		int l=1;
		int r = A.length;
		int ans = 0;
		while(l<=r) {
			int mid = l+(r-l)/2;
			if(isPossible(A, B, mid)) {
				ans = mid;
				l=mid+1;
			}else {
				r=mid-1;
			}
		}
		
		return ans;
    }

	private boolean isPossible(int[] A, int B, int mid) {
		
		long sum=0;
		for(int i=0; i<mid;i++) {
			sum+=(long)A[i];
		}
		if(sum>B) {
			return false;
		}
		for(int i=mid; i<A.length; i++) {
			sum = sum +A[i]-A[i-mid];
			if(sum>B) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		SpecialInteger ai = new SpecialInteger();
		System.out.println(ai.solve(A, 10));
	}

}
