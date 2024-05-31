package com.tarif.day042.dsa.searching3.binarysearchonanswers;

import java.util.Arrays;

public class AggresiveCows {
	public int solve(int[] A, int B) {
        Arrays.sort(A);
        int l = Integer.MAX_VALUE;
        for(int i=0; i<A.length-1; i++) {
        	if(A[i+1]-A[i]<l) {
        		l = A[i+1]-A[i];
        	}
        }
        int r = A[A.length-1]-A[0];
        int ans = 0;
        while(l<=r) {
        	int mid = l+(r-l)/2;
        	if(isPossible(A, mid, B)) {
        		ans = mid;
        		l=mid+1;
        	}else {
        		r = mid-1;
        	}
        }
        return ans;
	}

	private boolean isPossible(int[] A, int givenDis, int b) {
		int cow = 1;
		int cowOne = 0;
		//int dis = givenDis;
		for(int i=1; i<A.length; i++) {
			if(A[i]-A[cowOne]>=givenDis) {
				cowOne = i;
				cow++;
			}
		}
		if(cow>=b) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		AggresiveCows ac = new AggresiveCows();
		System.out.println(ac.solve(A, 3));
	}

}
