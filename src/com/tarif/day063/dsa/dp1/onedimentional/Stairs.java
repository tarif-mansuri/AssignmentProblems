package com.tarif.day063.dsa.dp1.onedimentional;

public class Stairs {
	public int climbStairs(int A) {
		if(A==1 || A==2) {
			return A;
		}
		int a = 1;
		int b = 2;
		int ans=0;
		for(int i=3; i<=A; i++) {
			ans = a+b;
			a = b;
			b=ans;
		}
		return ans;
    }
	public static void main(String[] args) {
		Stairs stairs = new Stairs();
		int[] A = {1,2,3,4,5,6};
		for(int i=0; i<A.length; i++) {
			System.out.print(stairs.climbStairs(A[i])+" ");
		}
		//stairs.climbStairs(0);
		}
}
