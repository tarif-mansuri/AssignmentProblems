package com.tarif.day008.intermediate.dsa.array.carryfarwardanssubarrays;

//			Problem Description
//			You are given an array A of N integers.
//			Return a 2D array consisting of all the subarrays of the array
//			
//			Note : The order of the subarrays in the resulting 2D array does not matter.
//			
//			
//			Problem Constraints
//			1 <= N <= 100
//			1 <= A[i] <= 105
//			
//			
//			Input Format
//			First argument A is an array of integers.
//			
//			
//			Output Format
//			Return a 2D array of integers in any order.
//			
//			
//			Example Input
//			Input 1:
//			A = [1, 2, 3]
//			Input 2:
//			A = [5, 2, 1, 4]
//			
//			
//			Example Output
//			Output 1:
//			[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
//			Output 2:
//			[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
//			
//			
//			Example Explanation
//			For Input 1:
//			All the subarrays of the array are returned. There are a total of 6 subarrays.
//			For Input 2:
//			All the subarrays of the array are returned. There are a total of 10 subarrays.

public class GenerateAllSubArrays {
	
	public int[][] solve(int[] A) {
        int n = A.length;
        int[][] subArrays = new int[(n*(n+1))/2][];
        int subInd = 0;
        for(int L=0; L<A.length; L++){
            for(int R=L; R<A.length; R++){
                int ind = 0;
                int[] row = new int[R-L+1];
                for(int i=L; i<=R; i++){
                    row[ind++] = A[i];
                }
                subArrays[subInd++] = row;
            }
        }
        return subArrays;
    }

}
