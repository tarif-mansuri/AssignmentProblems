package com.tarif.day062.dsa.greedy;

public class DistributeCandies {
	public int candy(int[] A) {
		int[] c = new int[A.length];
		for(int i=0; i<c.length; i++) {
			c[i]=1;
		}
		for(int i=1; i<c.length; i++) {
			if(A[i]>A[i-1]) {
				c[i] = c[i-1]+1;
			}
		}
		int sum=c[c.length-1];
		for(int i=c.length-2; i>=0; i--) {
			if(A[i]>A[i+1]) {
				c[i] = Math.max(c[i+1]+1, c[i]);
			}
			sum+=c[i];
		}
		return sum;
    }
	public static void main(String[] args) {
		DistributeCandies obj = new DistributeCandies();
		int[] A = {1, 5, 2, 1};
		int c = obj.candy(A);
		System.out.println(c);
	}
}
