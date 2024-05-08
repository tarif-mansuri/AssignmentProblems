package com.tarif.day020.dsa.array3interviewproblems;


//	Problem Description
//	You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
//	
//	You may assume that the intervals were initially sorted according to their start times.
//	
//	
//	
//	Problem Constraints
//	0 <= |intervals| <= 105
//	
//	
//	
//	Input Format
//	First argument is the vector of intervals
//	
//	second argument is the new interval to be merged
//	
//	
//	
//	Output Format
//	Return the vector of intervals after merging
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
//	Input 2:
//	
//	Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
//	
//	
//	Example Output
//	Output 1:
//	
//	 [ [1, 5], [6, 9] ]
//	Output 2:
//	
//	 [ [1, 9] ]
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	(2,5) does not completely merge the given intervals
//	Explanation 2:
//	
//	(2,6) completely merges the given intervals

public class MergeIntervals2 {
	
	public int[][] insert(int[][] A, int[] B) {
        int[][] ans = new int[A.length+1][2];
        int k=0;
        int L = B[0];
        int R = B[1];
        //Case 1 [L, R]
        if(A.length == 0){
            ans[k][0] = L;
            ans[k][1] = R;
            k++;
            return trimArray(ans, k);
        }
        //Case 1 [L, R] [s1, e1] [s2, e2]......[sn-1, en-1]
        if(R<A[0][0]){
            ans[k][0] = L;
            ans[k][1] = R;
            k++;
            while(k<A.length){
                ans[k][0] = A[k-1][0];
                ans[k][1] = A[k-1][1];
                k++;
            }
            return trimArray(ans, k);
        }

        //Case 2 [s1, e1] [s2, e2]......[sn-1, en-1] [L, R]
        if(L>A[A.length-1][1]){
            while(k<A.length){
                ans[k][0] = A[k][0];
                ans[k][1] = A[k][1];
                k++;
            }
            ans[k][0] = L;
            ans[k][1] = R;
            k++;
            return trimArray(ans, k);
        }

        //Case 3 printing cases 
        int i=0;
        while(i<A.length){
            if(A[i][1]<L){
                ans[k][0] = A[i][0];
                ans[k][1] = A[i][1];
                k++;
                i++;
            }else{
                int start = L;
                int end = R;
                i = k;
                while(i<A.length){
                    if(!(end<A[i][0] || A[i][1]<start)){
                        start = Math.min(start, A[i][0]);
                        end = Math.max(end, A[i][1]);
                    }else{
                        break;
                    }
                    i++;
                }
                ans[k][0] = start;
                ans[k][1] = end;
                k++;
                while(i<A.length){
                    ans[k][0] = A[i][0];
                    ans[k][1] = A[i][1];
                    i++;
                    k++;
                }

            }
        }
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
