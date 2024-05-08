package com.tarif.day027.dsa.backtracking;

//	Problem Description
//	Given an integer array A of size N denoting collection of numbers , return all possible permutations.
//	
//	NOTE:
//	
//	No two entries in the permutation sequence should be the same.
//	For the purpose of this problem, assume that all the numbers in the collection are unique.
//	Return the answer in any order
//	
//	
//	
//	Problem Constraints
//	1 <= N <= 9
//	
//	
//	
//	Input Format
//	Only argument is an integer array A of size N.
//	
//	
//	
//	Output Format
//	Return a 2-D array denoting all possible permutation of the array.
//	
//	
//	
//	Example Input
//	A = [1, 2, 3]
//	
//	
//	Example Output
//	[ [1, 2, 3]
//	  [1, 3, 2]
//	  [2, 1, 3] 
//	  [2, 3, 1] 
//	  [3, 1, 2] 
//	  [3, 2, 1] ]
//	
//	
//	Example Explanation
//	All the possible permutation of array [1, 2, 3].
//	
//	
//	
//	Expected Output
//	Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

public class AllPermutationsUniqueNumbers {
	
	private static int index = 0;
    public int[][] permute(int[] A) {
        index = 0;
        int n = 1;
        for(int i=1; i<=A.length; i++){
            n *=i;
        }
        boolean[] visited = new boolean[A.length];
        int[][] ans = new int[n][A.length];
        permutations(ans, A, visited, 0, new int[A.length]);
        return ans;
    }

    public void permutations(int[][] ans, int[] A, boolean[] visited, int ind, int[] per){
        if(ind == A.length){
            for(int i=0; i<per.length; i++) {
                ans[index][i] = per[i];
            }
            index++;
            return;
        }

        for(int i=0; i<A.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                per[ind] = A[i];
                permutations(ans, A, visited, ind+1, per);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
    	int[] A = {1,2,3};
    	AllPermutationsUniqueNumbers permutations = new AllPermutationsUniqueNumbers();
    	permutations.permute(A);
    	
    }

}
