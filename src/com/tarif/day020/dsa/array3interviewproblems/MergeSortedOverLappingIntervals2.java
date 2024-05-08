package com.tarif.day020.dsa.array3interviewproblems;

//	Problem Description
//	You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`. The intervals are sorted based on their start values.
//	
//	Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.
//	
//	
//	Problem Constraints
//	1 <= len(A) <= 100000.
//	1 <= A[i][0] <= A[i][1] <= 100000
//	
//	A is sorted based on the start value (A[i][0])
//	
//	
//	
//	Input Format
//	First argument is a list of intervals in 2-Dimentional Array.
//	
//	
//	
//	Output Format
//	Return the sorted list of intervals after merging all the overlapping intervals.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	[ [1, 3], [2, 6], [8, 10], [15, 18] ]
//	Input 2:
//	
//	[ [2, 10], [4, 9], [6, 7] ]
//	
//	
//	Example Output
//	Output 1:
//	
//	[ [1, 6], [8, 10], [15, 18] ]
//	Output 2:
//	
//	[ [2, 10] ]
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	Merge intervals [1,3] and [2,6] -> [1,6].
//	so, the required answer after merging is [1,6],[8,10],[15,18].
//	No more overlapping intervals present.
//	Explanation 2:
//	
//	Merge intervals [2, 10], [4, 9], [6, 7] as [2,10].
//	Since [4, 9] and [6, 7] is overlapping inside the interval [2, 10].
//	
//	so, the required answer after merging is [2, 10].


public class MergeSortedOverLappingIntervals2 {
	
	public int[][] solve(int[][] A) {
        int[][] ans = new int[A.length][2];
        int start = A[0][0];
        int end = A[0][1];
        int k=0;
        for(int i=1; i<A.length; i++){
            if(end<A[i][0]){
                ans[k][0] = start;
                ans[k][1] = end;
                k++;
                start = A[i][0];
                end = A[i][1];
            }else{
                end = Math.max(end, A[i][1]); 
            }
        }
        ans[k][0] = start;
        ans[k][1] = end;
        k++;
        return trimArray(ans, k);

    }

    public int[][] trimArray(int[][] A, int k){
	        int[][] ans = new int[k][2];
	        for(int i=0; i<ans.length; i++){
	            ans[i][0] = A[i][0];
	            ans[i][1] = A[i][1];
	        }
	        return ans;
	    }

}
