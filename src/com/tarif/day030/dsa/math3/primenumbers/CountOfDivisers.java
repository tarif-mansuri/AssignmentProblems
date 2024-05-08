package com.tarif.day030.dsa.math3.primenumbers;

//	Problem Description
//	Given an array of integers A, find and return the count of divisors of each element of the array.
//	
//	NOTE: The order of the resultant array should be the same as the input array.
//	
//	
//	
//	Problem Constraints
//	1 <= length of the array <= 100000
//	1 <= A[i] <= 106
//	
//	
//	
//	Input Format
//	The only argument given is the integer array A.
//	
//	
//	
//	Output Format
//	Return the count of divisors of each element of the array in the form of an array.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = [2, 3, 4, 5]
//	Input 2:
//	
//	 A = [8, 9, 10]
//	
//	
//	Example Output
//	Output 1:
//	
//	 [2, 2, 3, 2]
//	Output 1:
//	
//	 [4, 3, 4]
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
//	 So the count will be [2, 2, 3, 2].
//	Explanation 2:
//	
//	 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
//	 So the count will be [4, 3, 4].


public class CountOfDivisers {
	public int[] solve(int[] A) {
		int[] spf= new int[1000001];
		populateSPF(spf);
		for(int i=0; i<A.length; i++) {
			int n = A[i];
			int ans = 1;
			int c=0;
			int currSPF = spf[n];
			
			while(n>1) {
				while(n%currSPF == 0) {
					c++;
					n = n/currSPF;
				}
				ans *=(c+1);
				c=0;
				currSPF = spf[n];
			}
			A[i] = ans;
		}
		return A;
    }
	
	public void populateSPF(int[] spf) {
		spf[0] = -1;
		spf[1] = -1;
		
		for(int i = 2; i<spf.length; i++) {
			spf[i] = i;
		}
		for(int i=2; i*i<spf.length; i++) {
			
			for(int j = i*i; j<spf.length; j=j+i) {
				if(j==spf[j] && spf[j]%i == 0) {
					spf[j] = i;
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		CountOfDivisers cod = new CountOfDivisers();
		int[] A = {2,3,4,5,8,9,10};
		int[] ans = cod.solve(A);
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
