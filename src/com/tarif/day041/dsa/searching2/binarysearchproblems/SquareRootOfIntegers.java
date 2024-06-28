package com.tarif.day041.dsa.searching2.binarysearchproblems;

//	Problem Description
//	Given an integer A. Compute and return the square root of A.
//	If A is not a perfect square, return floor(sqrt(A)).
//	
//	NOTE: 
//	   The value of A*A can cross the range of Integer.
//	   Do not use the sqrt function from the standard library. 
//	   Users are expected to solve this in O(log(A)) time.
//	
//	
//	Problem Constraints
//	0 <= A <= 109
//	
//	
//	Input Format
//	The first and only argument given is the integer A.
//	
//	
//	Output Format
//	Return floor(sqrt(A))
//	
//	
//	Example Input
//	Input 1:
//	
//	 11
//	Input 2:
//	
//	 9
//	
//	
//	Example Output
//	Output 1:
//	
//	 3
//	Output 2:
//	
//	 3
//	
//	
//	Example Explanation
//	Explanation 1:
//	When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
//	Explanatino 2:
//	When A = 9 which is a perfect square of 3, so we return 3.


public class SquareRootOfIntegers {
	
	public int sqrt(int A) {
        int l=0;
        int h =A;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(mid == (int)Math.sqrt(A)){
                return mid;
            }
            if(mid < (int)Math.sqrt(A)){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return 0;
    }

}
