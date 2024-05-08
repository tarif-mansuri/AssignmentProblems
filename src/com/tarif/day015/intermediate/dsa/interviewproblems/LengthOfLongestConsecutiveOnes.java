package com.tarif.day015.intermediate.dsa.interviewproblems;


//	Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
//	
//	
//	Input Format
//	
//	The only argument given is string A.
//	Output Format
//	
//	Return the length of the longest consecutive 1’s that can be achieved.
//	Constraints
//	
//	1 <= length of string <= 1000000
//	A contains only characters 0 and 1.
//	For Example
//	
//	Input 1:
//	    A = "111000"
//	Output 1:
//	    3
//	
//	Input 2:
//	    A = "111011101"
//	Output 2:
//	    7

public class LengthOfLongestConsecutiveOnes {
	
	public int solve(String A) {
        int c =0;
		for(int i = 0; i<A.length(); i++) {
			if(A.charAt(i) == '1') {
				c++;
			}
		}
		if(c == A.length()) {
			return c;
		}
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == '0') {
            	int j = i-1;
                int l = 0;
                while(j>=0) {
                	if(A.charAt(j) == '1') {
                		l++;
                		j--;
                	}else {
                		break;
                	}
                }
                int r = 0;
                j=i+1;
                while(j<A.length()) {
                	if(A.charAt(j)=='1') {
                		r++;
                		j++;
                	}else {
                		break;
                	}
                }
                if(l+r+1>max) {
                	max = l+r+1;
                }
            }
        }
        if(max<c) {
        	return max;
        }else {
        	return c;
        }
    }

}
