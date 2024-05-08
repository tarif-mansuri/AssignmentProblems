package com.tarif.day012.intermediate.dsa.sortingbasics;

import java.util.Arrays;

//	Problem Description
//	Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
//	
//	
//	
//	Problem Constraints
//	1 <= |A| <= 2*105
//	-108 <= A[i] <= 108
//	
//	
//	Input Format
//	First and only argument is an integer array A.
//	
//	
//	
//	Output Format
//	Return 1 if any such integer p is present else, return -1.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = [3, 2, 1, 3]
//	Input 2:
//	
//	 A = [1, 1, 3, 3]
//	
//	
//	Example Output
//	Output 1:
//	
//	 1
//	Output 2:
//	
//	 -1
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 For integer 2, there are 2 greater elements in the array..
//	Explanation 2:
//	
//	 There exist no integer satisfying the required conditions.

public class NobleInteger {
	
	public int solve(int[] A) {
        Arrays.sort(A);
        if(A[A.length-1] == 0){
            return 1;
        }
        int c = 0;
        for(int i=A.length-2; i>=0; i--){
            if(A[i]!=A[i+1]){
                c = A.length-i-1;
            }
            if(A[i]==c){
                return 1;
            }
        }
        return -1;
    }

}
