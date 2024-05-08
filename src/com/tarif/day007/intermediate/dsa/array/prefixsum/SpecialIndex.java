package com.tarif.day007.intermediate.dsa.array.prefixsum;


//			Problem Description
//			Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
//			
//			
//			
//			Problem Constraints
//			1 <= N <= 105
//			-105 <= A[i] <= 105
//			Sum of all elements of A <= 109
//			
//			
//			Input Format
//			First argument contains an array A of integers of size N
//			
//			
//			Output Format
//			Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
//			
//			
//			
//			Example Input
//			Input 1:
//			A = [2, 1, 6, 4]
//			Input 2:
//			
//			A = [1, 1, 1]
//			
//			
//			Example Output
//			Output 1:
//			1
//			Output 2:
//			
//			3
//			
//			
//			Example Explanation
//			Explanation 1:
//			Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
//			Therefore, the required output is 1. 
//			Explanation 2:
//			
//			Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
//			Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
//			Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
//			Therefore, the required output is 3.

public class SpecialIndex {
	
	public int solve(int[] A) {
        int[] evePref = new int[A.length];
        int[] oddPref = new int[A.length];

        //calculate evePref
        evePref[0] = A[0];
        for(int i=1; i<A.length;i++){
            if(i%2!=0){
                evePref[i] = evePref[i-1];
            }else{
                evePref[i] = evePref[i-1]+A[i];
            }
        }

         //calculate oddPref
        oddPref[0] = 0;
        for(int i=1; i<A.length;i++){
            if(i%2 == 0){
                oddPref[i] = oddPref[i-1];
            }else{
                oddPref[i] = oddPref[i-1]+A[i];
            }
        }

        int c =0;
        for(int i=0; i<A.length; i++){
            int evenSum = 0;
            if(i>0){
                evenSum += evePref[i-1];
            }
            evenSum += oddPref[A.length-1] - oddPref[i];

            int oddSum = 0;
            if(i>0){
                oddSum += oddPref[i-1];
            }
            oddSum += evePref[A.length-1] - evePref[i];

            if(evenSum == oddSum){
                c++;
            }
        }
        return c;
    }

}
