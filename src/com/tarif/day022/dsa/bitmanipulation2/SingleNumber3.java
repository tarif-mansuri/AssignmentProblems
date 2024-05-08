package com.tarif.day022.dsa.bitmanipulation2;


//	Problem Description
//	Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
//	Find the two integers that appear only once.
//	
//	Note: Return the two numbers in ascending order.
//	
//	
//	Problem Constraints
//	2 <= |A| <= 100000
//	1 <= A[i] <= 109
//	
//	
//	
//	Input Format
//	The first argument is an array of integers of size N.
//	
//	
//	
//	Output Format
//	Return an array of two integers that appear only once.
//	
//	
//	
//	Example Input
//	Input 1:
//	A = [1, 2, 3, 1, 2, 4]
//	Input 2:
//	
//	A = [1, 2]
//	
//	
//	Example Output
//	Output 1:
//	[3, 4]
//	Output 2:
//	
//	[1, 2]
//	
//	
//	Example Explanation
//	Explanation 1:
//	3 and 4 appear only once.
//	Explanation 2:
//	
//	1 and 2 appear only once.

public class SingleNumber3 {
	
	public int[] solve(int[] A) {
        int xOr = 0;
        for(int i=0; i<A.length; i++){
            xOr ^=A[i];
        }
        int ithSetBit = -10;
        for(int i=0; i<32;i++){
            if((xOr & (1<<i))>0){
                ithSetBit = i;
                break;
            }
        }
        int n1 = 0;
        int n2 = 0;
        for(int i=0; i<A.length; i++){
            if((A[i]&(1<<ithSetBit))>0){
                n1 ^=A[i];
            }else{
                n2 ^=A[i];
            }
        }

        int[] res = new int[2];
        if(n1<n2){
            res[0] = n1;
            res[1] = n2;
        }else{
            res[1] = n1;
            res[0] = n2;
        }
        return res;
    }

}
