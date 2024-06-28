package com.tarif.day042.dsa.searching3.binarysearchonanswers;


//	Problem Description
//	Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
//	
//	
//	
//	Problem Constraints
//	1 <= |A| <= 100000
//	1 <= A[i] <= 10^9
//	
//	1 <= B <= 10^9
//	
//	
//	
//	Input Format
//	The first argument given is the integer array A.
//	
//	The second argument given is integer B.
//	
//	
//	
//	Output Format
//	Return the maximum value of K (sub array length).
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	A = [1, 2, 3, 4, 5]
//	B = 10
//	Input 2:
//	
//	A = [5, 17, 100, 11]
//	B = 130
//	
//	
//	Example Output
//	Output 1:
//	
//	 2
//	Output 2:
//	
//	 3
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
//	For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
//	For K = 3, There is a subarray [3, 4, 5] which has a sum > B
//	For K = 2, There were no subarray which has a sum > B.
//	Constraints are satisfied for maximal value of 2.
//	Explanation 2:
//	
//	For K = 4, There are subarrays [5, 17, 100, 11] which has a sum > B
//	For K = 3, There were no subarray which has a sum > B.
//	Constraints are satisfied for maximal value of 3.

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
