package com.tarif.day039.dsa.sorting2.quicksortandcomparatorproblems;

import java.util.Arrays;

public class LargestNumber {
	public String largestNumber(int[] A) {
		String[] nums = new String[A.length];
		boolean allZeros = true;
		for(int i=0; i<A.length; i++) {
			if(A[i]>0) {
				allZeros = false;
			}
			nums[i] = ""+A[i];
		}
		if(allZeros) {
			return "0";
		}
		Arrays.sort(nums, (String a, String b)->{
			String x = a.concat(b);
			String y = b.concat(a);
			return y.compareTo(x);
		}); 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<A.length; i++) {
			sb.append(nums[i]);
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] a = {3, 30, 34, 5, 9};
		System.out.println(ln.largestNumber(a));
	}

}
