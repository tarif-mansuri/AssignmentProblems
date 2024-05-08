package com.tarif.day019.dsa.array2twodimensional;


//	Problem Description
//	Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
//	
//	
//	
//	Problem Constraints
//	1 <= A <= 1000
//	
//	
//	
//	Input Format
//	First and only argument is integer A
//	
//	
//	Output Format
//	Return a 2-D matrix which consists of the elements added in spiral order.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	1
//	Input 2:
//	
//	2
//	Input 3:
//	
//	5
//	
//	
//	Example Output
//	Output 1:
//	
//	[ [1] ]
//	Output 2:
//	
//	[ [1, 2], 
//	  [4, 3] ]
//	Output 2:
//	
//	[ [1,   2,  3,  4, 5], 
//	  [16, 17, 18, 19, 6], 
//	  [15, 24, 25, 20, 7], 
//	  [14, 23, 22, 21, 8], 
//	  [13, 12, 11, 10, 9] ]
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	Only 1 is to be arranged.
//	Explanation 2:
//	
//	1 --> 2
//	      |
//	      |
//	4<--- 3


public class SpiralMatrix2 {
	
	public int[][] generateMatrix(int A) {
        int[][] M = new int[A][A];
        int row = A;
		int col = A;
		int i=0, j=0;
		
		int count = 1;
        int value=1;
		while(count<=A/2) {
			i=count-1;
			j=count-1;
			for(; j<col-count; j++) {
				M[i][j] = value++;
			}
			
			for(; i<row-count; i++) {
				M[i][j] = value++;
			}
			
			for(; j>=0+count; j--) {
				M[i][j] = value++;
			}
			
			for(; i>= 0+count; i--) {
				M[i][j] = value++;
			}
			count++;
		}
		if(A%2!=0) {
			M[A/2][A/2] = A*A;
		}
        return M;
    }

}
