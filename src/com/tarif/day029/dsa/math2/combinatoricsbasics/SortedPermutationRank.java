package com.tarif.day029.dsa.math2.combinatoricsbasics;


//	Problem Description
//	Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
//	Assume that no characters are repeated.
//	
//	Note: The answer might not fit in an integer, so return your answer % 1000003
//	
//	
//	
//	Problem Constraints
//	1 <= |A| <= 1000
//	
//	
//	
//	Input Format
//	First argument is a string A.
//	
//	
//	
//	Output Format
//	Return an integer denoting the rank of the given string.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	A = "acb"
//	Input 2:
//	
//	A = "a"
//	
//	
//	Example Output
//	Output 1:
//	
//	2
//	Output 2:
//	
//	1
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	Given A = "acb".
//	The order permutations with letters 'a', 'c', and 'b' : 
//	abc
//	acb
//	bac
//	bca
//	cab
//	cba
//	So, the rank of A is 2.
//	Explanation 2:
//	
//	Given A = "a".
//	Rank is clearly 1.
//	


public class SortedPermutationRank {
	public int findRank(String A) {
		int rank=0;
		for(int i=0; i<A.length()-1; i++) {
			int count = 0;
			for(int j=i+1; j<A.length(); j++) {
				if(A.charAt(i)>A.charAt(j)) {
					count++;
				}
			}
			//rank += count*fact(A.length()-i-1);
			rank += ((count%1000003) * (fact(A.length()-i-1)%1000003))%1000003;	
		}
		return rank+1;
		
    }
	
	public static void main(String[] args) {
		SortedPermutationRank spr = new SortedPermutationRank();
		System.out.println(spr.findRank("acb"));
	}
	
	public int fact(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		return (n*fact(n-1))%1000003;
	}

}
