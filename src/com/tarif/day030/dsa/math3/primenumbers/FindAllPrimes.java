package com.tarif.day030.dsa.math3.primenumbers;


//	Problem Description
//	Given an integer A. Find the list of all prime numbers in the range [1, A].
//	
//	
//	Problem Constraints
//	1 <= A <= 106
//	
//	
//	
//	Input Format
//	Only argument A is an integer.
//	
//	
//	
//	Output Format
//	Return a sorted array of prime number in the range [1, A].
//	
//	
//	
//	Example Input
//	Input 1:
//	A = 7
//	Input 2:
//	A = 12
//	
//	
//	Example Output
//	Output 1:
//	[2, 3, 5, 7]
//	Output 2:
//	[2, 3, 5, 7, 11]
//	
//	
//	Example Explanation
//	For Input 1:
//	The prime numbers from 1 to 7 are 2, 3, 5 and 7.
//	For Input 2:
//	The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.


public class FindAllPrimes {
	public int[] solve(int A) {
		boolean[] isPrime = new boolean[A+1];
		for(int i=2; i<A+1; i++) {
			isPrime[i] = true;
		}
		
		for(int i=2; i*i<A+1; i++) {
			for(int j=i*i; j<A+1; j=j+i) {
				if(j%i == 0) {
					isPrime[j] = false;
				}
			}
		}
		int size=0;
		for(int i=0; i<A+1; i++) {
			if(isPrime[i]) {
				size++;
			}
		}
		int[] ans = new int[size];
		int ind = 0;
		for(int i=0; i<A+1; i++) {
			if(isPrime[i]) {
				ans[ind++] = i;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		FindAllPrimes allPrimes = new FindAllPrimes();
		int[] ans = allPrimes.solve(10);
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]+" ");
		}
	}

}
