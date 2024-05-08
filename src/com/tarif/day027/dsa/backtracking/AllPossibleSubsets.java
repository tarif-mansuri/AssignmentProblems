package com.tarif.day027.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Problem Description
//Given a set of distinct integers A, return all possible subsets.
//
//NOTE:
//
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//Also, the subsets should be sorted in ascending ( lexicographic ) order.
//The initial list is not necessarily sorted.
//
//
//Problem Constraints
//1 <= |A| <= 16
//INTMIN <= A[i] <= INTMAX
//
//
//Input Format
//First and only argument of input contains a single integer array A.
//
//
//
//Output Format
//Return a vector of vectors denoting the answer.
//
//
//
//Example Input
//Input 1:
//
//A = [1]
//Input 2:
//
//A = [1, 2, 3]
//
//
//Example Output
//Output 1:
//
//[
//    []
//    [1]
//]
//Output 2:
//
//[
// []
// [1]
// [1, 2]
// [1, 2, 3]
// [1, 3]
// [2]
// [2, 3]
// [3]
//]
//
//
//Example Explanation
//Explanation 1:
//
// You can see that these are all possible subsets.
//Explanation 2:
//
//You can see that these are all possible subsets.
//
//
//
//Expected Output
//Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

public class AllPossibleSubsets {
	
	public int[][] subsets(int[] A) {
        Arrays.sort(A);
        int size = (int)Math.pow(2, A.length);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(size);
        getAllSubsets(A, 0, new ArrayList<>(), ans);
        int[][] res = new int[size][];
        for(int i=0; i<ans.size(); i++) {
            ArrayList<Integer> rowList = ans.get(i);
            int[] rowArr = new int[rowList.size()];
            for(int k=0; k<rowArr.length; k++) {
                rowArr[k] = rowList.get(k);
            }
            res[i] = rowArr;
        }
        return res;
    }

    public void getAllSubsets(int[] A, int ind, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> ans){
        if(ind==A.length){            
            ArrayList<Integer> arr = new ArrayList<>(subset.size());
            for(int i=0; i<subset.size(); i++){
                arr.add(subset.get(i));
            }
            Collections.sort(arr);
            addSorted(ans, arr);
            return;
        }
        getAllSubsets(A, ind+1, subset, ans);
        subset.add(A[ind]);
        getAllSubsets(A, ind+1, subset, ans);
        subset.remove(subset.size()-1);
    }

    private void addSorted(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr) {
        if(ans.size()==0) {
            ans.add(arr);
            return;
        }
        for(int i=0; i<ans.size(); i++) {
            boolean isSmall = false;
            ArrayList<Integer> list = ans.get(i);
            int x = 0;
            while(x<list.size() && x< arr.size()) {
                if(arr.get(x)<list.get(x)) {
                    isSmall = true;
                    break;
                }
                x++;
            }
            if(isSmall || x<list.size()) {
                ans.add(i,arr);
                return;
            }
            
        }
        ans.add(arr);
        
    }
    
    public static void main(String[] args) {
    	AllPossibleSubsets aps = new AllPossibleSubsets();
    	int[] A = {1,2,3,4};
    	aps.subsets(A);
    }

}
