package com.tarif.day022.dsa.bitmanipulation2;

//	Problem Description
//	Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
//	
//	
//	Problem Constraints
//	1 <= len(A) <= 105
//	1 <= A[i] <= 109
//	
//	
//	Input Format
//	The first argument is an integer array A.
//	
//	
//	Output Format
//	Return a single integer that is the maximum A[i] & A[j].
//	
//	
//	Example Input
//	Input 1:-
//	A = [53, 39, 88]
//	Input 2:-
//	A = [38, 44, 84, 12] 
//	
//	
//	Example Output
//	Output 1:-
//	37
//	Output 2:-
//	36
//	
//	
//	Example Explanation
//	Explanation 1:-
//	53 & 39 = 37
//	39 & 88 = 0
//	53 & 88 = 16
//	Maximum among all these pairs is 37
//	Explanation 2:-
//	Maximum bitwise and among all pairs is (38, 44) = 36

public class MaximumAndPair {
	
	public int solve(int[] A) {
        int ans =0;
        for(int i=31; i>=0; i--){
            int c =0;
            for(int j=0; j<A.length; j++){
                if((A[j] & (1<<i))>0){
                    c++;
                }
            }
            if(c>=2){
                ans = ans | (1<<i);
                for(int k=0; k<A.length; k++){
                    if((A[k] & (1<<i)) == 0){
                        A[k] = 0;
                    }
                }
            }

        }
        return ans;
    }

}
