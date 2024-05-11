package com.tarif.day036.dsa.hashing2;

import java.util.HashMap;

//	Problem Description
//	Given an array A of N integers.
//	Find the length of the longest subarray in the array which sums to zero.
//	
//	If there is no subarray which sums to zero then return 0.
//	
//	
//	
//	Problem Constraints
//	1 <= N <= 105
//	-109 <= A[i] <= 109
//	
//	
//	Input Format
//	Single argument which is an integer array A.
//	
//	
//	Output Format
//	Return an integer.
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = [1, -2, 1, 2]
//	Input 2:
//	
//	 A = [3, 2, -1]
//	
//	
//	Example Output
//	Output 1:
//	
//	3
//	Output 2:
//	
//	0
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 [1, -2, 1] is the largest subarray which sums up to 0.
//	Explanation 2:
//	
//	 No subarray sums up to 0.


public class LongestSubArrayZeroSum {
	public static void main(String[] args) {
		int[] A = {-1,-2,-3,-4};
		LongestSubArrayZeroSum ls = new LongestSubArrayZeroSum();
		System.out.println(ls.solve(A));
	}
	public int solve(int[] A) {
        long[] ps = new long[A.length];
        ps[0] = A[0];
        for(int i=1; i<A.length; i++){
            ps[i] = ps[i-1] + A[i];
        }
        int l =0;
        HashMap<Long, Integer> map = new HashMap();
        map.put(0L,-1);
        for(int i=0; i<A.length; i++){
           {
                    if(map.containsKey(ps[i])){
                        int temp = i - map.get(ps[i]);
                        if(temp>l){
                            l = temp;
                        }
                    }else{
                        map.put(ps[i], i);
                    }
                }
        }
        return l;
    }

}
