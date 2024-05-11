package com.tarif.day036.dsa.hashing2;

import java.util.HashMap;

//	Problem Description
//	Given an array of integers A and an integer B.
//	Find the total number of subarrays having sum equals to B.
//	
//	
//	Problem Constraints
//	 1 <= length of the array <= 50000
//	-1000 <= A[i] <= 1000
//	
//	
//	Input Format
//	The first argument given is the integer array A.
//	The second argument given is integer B.
//	
//	
//	Output Format
//	Return the total number of subarrays having sum equals to B.
//	
//	
//	Example Input
//	Input 1:
//	A = [1, 0, 1]
//	B = 1
//	Input 2:
//	A = [0, 0, 0]
//	B = 0
//	
//	
//	Example Output
//	Output 1:
//	4
//	Output 2:
//	6
//	
//	
//	Example Explanation
//	Explanation 1:
//	[1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
//	Explanation 1:
//	All the possible subarrays having sum 0.

public class SubArraySumEqualsK {
	
	public int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int  p=0;
        int ans=0;
        for(int i=0; i<A.length; i++){
            p +=A[i];
            if(map.containsKey(p-B)){
                ans +=map.get(p-B);
            }
            if(map.containsKey(p)){
                map.replace(p, map.get(p)+1);
            }else{
                map.put(p,1);
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		
	}

}
