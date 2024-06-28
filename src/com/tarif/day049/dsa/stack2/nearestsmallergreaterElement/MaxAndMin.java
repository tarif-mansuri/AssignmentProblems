package com.tarif.day049.dsa.stack2.nearestsmallergreaterElement;

import java.util.Stack;

public class MaxAndMin {
	public int solve(int[] A) {
		int MOD = 1000000007;
		int[] nearestSmallerLeft = new int[A.length];
		populateNearestSmallerLeft(nearestSmallerLeft,A);
		int[] nearestSmallerRight = new int[A.length];
		populateNearestSmallerRight(nearestSmallerRight,A);
		int[] nearestGreaterLeft = new int[A.length];
		populateNearestGreaterLeft(nearestGreaterLeft,A);
		int[] nearestGreaterRight = new int[A.length];
		populateNearestGreaterRight(nearestGreaterRight,A);
		long ans = 0;
		for(int i=0; i<A.length; i++) {
			long m = i-nearestGreaterLeft[i];
			long n = nearestGreaterRight[i]-i;
			long noOfSubArrAiIsMax = ((m%MOD)*(n%MOD))%MOD;
			m = i-nearestSmallerLeft[i];
			n = nearestSmallerRight[i]-i;
			long noOfSubArrAiIsMin = ((m%MOD)*(n%MOD))%MOD;
			// ans +=A[i]*(noOfSubArrAiIsMax-noOfSubArrAiIsMin)
			ans =(ans%MOD + ((A[i]*(noOfSubArrAiIsMax-noOfSubArrAiIsMin))%MOD)%MOD)%MOD;
		}
		return (int)ans;
    }
	
	public void populateNearestSmallerLeft(int ans[], int[] A) {
		Stack<Integer> s = new Stack<>();
		for(int i=0; i< A.length; i++) {
			while(!s.isEmpty() && A[s.peek()]>=A[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				ans[i] = -1;
			}else {
				ans[i] = s.peek();
			}
			s.push(i);
		}
	}
	public void populateNearestSmallerRight(int[] ans, int[] A) {
		Stack<Integer> s = new Stack<>();
		for(int i=A.length-1; i>=0; i--) {
			while(!s.isEmpty() && A[s.peek()]>=A[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				ans[i] = A.length;
			}else {
				ans[i] = s.peek();
			}
			s.push(i);
		}
		}
	public void populateNearestGreaterLeft(int[] ans, int[] A) {
		Stack<Integer> s = new Stack<>();
		for(int i=0; i< A.length; i++) {
			while(!s.isEmpty() && A[s.peek()]<=A[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				ans[i] = -1;
			}else {
				ans[i] = s.peek();
			}
			s.push(i);
		}
	}
	public void populateNearestGreaterRight(int[] ans, int[] A) {
		Stack<Integer> s = new Stack<>();
		for(int i=A.length-1; i>=0 ; i--) {
			while(!s.isEmpty() && A[s.peek()]<=A[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				ans[i] = A.length;
			}else {
				ans[i] = s.peek();
			}
			s.push(i);
		}
	}
	public static void main(String[] args) {
		MaxAndMin maxMin = new MaxAndMin();
		int[] A = {994390,986616,976849,979707,950477,968402,992171,937674,933065,960863,980981,937319,951236,959547,991052,991799,992213,941294,978103,997198,960759,988476,963517,980366,921767,979757,977912,983761,981869,947454,930202,999086,973538,999798,996446,944001,974217,951595,942688,975075,970973,970130,897109,927660,862233,997130,986068,954098,978175,889682,988973,996036,969675,985751,977724,881538,988613,924230,906475,915565,986952,975702,994316,964011,986848,983699,949076,989673,981788,929094,988310,926471,994763,999736,980762,973560,996622,934475,998365,966255,998697,998700,911868,983245,996382,996992,953142,994104,987303,853837,960626,904203,998063,977596,977868,996012,946345,949255,988138,996298,954933,965036,886976,998628,990878,953725,916744,985233,919661,970903,986066};
		System.out.println(maxMin.solve(A));
	}
	
}
