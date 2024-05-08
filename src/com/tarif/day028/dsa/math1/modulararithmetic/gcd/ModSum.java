package com.tarif.day028.dsa.math1.modulararithmetic.gcd;

import java.util.ArrayList;


//	Problem Description
//	Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.
//	
//	
//	
//	Problem Constraints
//	1 <= length of the array A <= 105
//	
//	1 <= A[i] <= 103
//	
//	
//	
//	Input Format
//	The only argument given is the integer array A.
//	
//	
//	
//	Output Format
//	Return a single integer denoting sum % (109 + 7).
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = [1, 2, 3]
//	Input 2:
//	
//	 A = [17, 100, 11]
//	
//	
//	Example Output
//	Output 1:
//	
//	 5
//	Output 2:
//	
//	 61
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
//	



public class ModSum {
	
	public static void main(String[] args) {
		int[] A = {1,2,2,3,3,3,4,5,5};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<A.length; i++) {
			list.add(A[i]);
		}
		ModSum ms = new ModSum();
		int ans = ms.solve(list);
		System.out.println(ans);
	}
	
	public int solve(ArrayList<Integer> A) {
        long MOD = 1000000007;
        int[] freq = new int[1001];
        for(int i=0; i<A.size(); i++){
            freq[A.get(i)]++;
        }
        long ans = 0;
        for(int i=1; i<freq.length; i++) {
        	if(freq[i] == 0) {
        		continue;
        	}
        	for(int j=1; j<freq.length; j++) {
        		if(freq[j] == 0) {
        			continue;
        		}
        		ans = (ans + ((freq[i]%MOD)*((i%j)%MOD)*((freq[j]%MOD)))%MOD)%MOD;
        		//ans = ans + freq[i]*(i%j)*freq[j];
        	}
        }
        return (int)ans;
    }

}
