package com.tarif.day028.dsa.math1.modulararithmetic.gcd;

import java.util.ArrayList;

//	Problem Description
//	Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
//	
//	Since the answer may be large, return the answer modulo (109 + 7).
//	
//	Note: Ensure to handle integer overflow when performing the calculations.
//	
//	
//	Problem Constraints
//	1 <= length of the array <= 100000
//	1 <= A[i] <= 109
//	1 <= B <= 106
//	
//	
//	
//	Input Format
//	The first argument given is the integer array A.
//	The second argument given is the integer B.
//	
//	
//	
//	Output Format
//	Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = [1, 2, 3, 4, 5]
//	 B = 2
//	Input 2:
//	
//	 A = [5, 17, 100, 11]
//	 B = 28
//	
//	
//	Example Output
//	Output 1:
//	
//	 4
//	Output 2:
//	
//	 1
//	
//	
//	Example Explanation
//	Explanation 1:
//	 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
//	 So total 4 pairs.
//	Explanation 2:
//	 There is only one pair which is divisible by 28 is (17, 11)
//	
//	
//	
//	Expected Output
//	Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases


public class PairSumDivisibleByM {
	private static final long MOD = 1000000007;
	
	public static void main(String[] args) {
		PairSumDivisibleByM psd = new PairSumDivisibleByM();
		int[] arr = {1,2,3,4,5};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			A.add(arr[i]);
		}
		//A.add(5);
		int ans = psd.solve(A, 2);
		System.out.println(ans);
	}
	//NOTE- Module and Divide when applied together they might give wrong output, avoid using them together
    public int solve(ArrayList<Integer> A, int B) {
		long[] f = new long[B];
        for(int i=0; i<A.size(); i++) {
        	int ele = A.get(i)%B;
        	f[ele]++;
        }
        
        long ans = (f[0] * (f[0]-1))/2;
        ans = ans %MOD;
        for(int i=1; i<=(B-1)/2; i++) {
        	ans = (ans + (f[i] * f[B-i])%MOD)%MOD;
        }
        if(B%2==0) {
        	long temp = (f[B/2]*(f[B/2]-1))/2;
            temp = temp%MOD;
            ans = (ans+ temp)%MOD;
        }
        return (int)ans;
    }

}
