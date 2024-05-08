package com.tarif.day020.dsa.array3interviewproblems;


//	Problem Description
//	Given an unsorted integer array, A of size N. Find the first missing positive integer.
//	
//	Note: Your algorithm should run in O(n) time and use constant space.
//	
//	
//	
//	Problem Constraints
//	1 <= N <= 1000000
//	
//	-109 <= A[i] <= 109
//	
//	
//	
//	Input Format
//	First argument is an integer array A.
//	
//	
//	
//	Output Format
//	Return an integer denoting the first missing positive integer.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	[1, 2, 0]
//	Input 2:
//	
//	[3, 4, -1, 1]
//	Input 3:
//	
//	[-8, -7, -6]
//	
//	
//	Example Output
//	Output 1:
//	
//	3
//	Output 2:
//	
//	2
//	Output 3:
//	
//	1
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	A = [1, 2, 0]
//	First positive integer missing from the array is 3.
//	Explanation 2:
//	
//	A = [3, 4, -1, 1]
//	First positive integer missing from the array is 2.
//	Explanation 3:
//	
//	A = [-8, -7, -6]
//	First positive integer missing from the array is 1.

public class FirstMissingInteger {
	
	public int firstMissingPositive(int[] A) {
        int i=0;
        while(i<A.length){
            if(A[i]<=0 || A[i]-1==i || A[i]>=A.length){
                i++;
            }else{
                if(A[A[i]-1] == A[i]){
                    A[i] = -A[i];
                }else{
                    int ind = A[i];
                    int value = A[ind-1];
                    A[ind-1] = ind;
                    A[i] = value;
                }
                
            }
        }
        for(i=0; i<A.length; i++){
            if(A[i]-1 != i){
                return i+1;
            }
        }
        return A.length+1;
    }

}
