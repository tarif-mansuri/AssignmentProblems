package com.tarif.day022.dsa.bitmanipulation2;


//	Problem Description
//	Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
//	
//	Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.
//	
//	
//	
//	Problem Constraints
//	1 <= N <= 105
//	
//	1 <= A[i] <= N+2
//	
//	The elements of array A are distinct
//	
//	
//	
//	Input Format
//	Only argument A is an array of integers
//	
//	
//	
//	Output Format
//	Return a sorted array of size 2 denoting the missing elements.
//	
//	
//	
//	Example Input
//	Input 1:
//	A = [3, 2, 4]
//	Input 2:
//	A = [5, 1, 3, 6]
//	
//	
//	Example Output
//	Output 1:
//	[1, 5]
//	Output 2:
//	[2, 4]
//	
//	
//	Example Explanation
//	For Input 1:
//	The missing numbers are 1 and 5.
//	For Input 2:
//	The missing numbers are 2 and 4.

public class FindTwoMissingNumbers {
	
	public int[] solve(int[] A) {
        int ans = 0;
        int n = A.length;
        for(int i=0; i<n; i++){
            ans ^= A[i];
        }
        for(int i=1; i<=n+2; i++){
            ans ^=i;
        }
        int bit = 0;
        for(int i=0; i<32; i++){
            if((ans & (1<<i)) > 0){
                bit =i;
            }
        }
        int ans1 = 0;
        int ans2 = 0;
        for(int i=0; i<n; i++){
            if ((A[i] & (1<<bit)) >0){
                ans1 ^= A[i];
            }else{
                ans2 ^= A[i];
            }
        }

        for(int i=1; i<=n+2; i++){
            if ((i & (1<<bit)) >0){
                ans1 ^= i;
            }else{
                ans2 ^= i;
            }
        }

        int[] res = new int[2];
        if(ans1<ans2){
            res[0] = ans1;
            res[1] = ans2;
        }else{
            res[1] = ans1;
            res[0] = ans2;
        }
        return res;
    }

}
