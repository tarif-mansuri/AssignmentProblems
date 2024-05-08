package com.tarif.day030.dsa.math3.primenumbers;

import java.util.ArrayList;
import java.util.List;

//	Problem Description
//	Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
//	
//	If there is more than one solution possible, return the lexicographically smaller solution.
//	
//	If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
//	[a, b] < [c, d], If a < c OR a==c AND b < d. 
//	NOTE: A solution will always exist. Read Goldbach's conjecture.
//	
//	
//	
//	Problem Constraints
//	4 <= A <= 2*107
//	
//	
//	
//	Input Format
//	First and only argument of input is an even number A.
//	
//	
//	
//	Output Format
//	Return a integer array of size 2 containing primes whose sum will be equal to given number.
//	
//	
//	
//	Example Input
//	 4
//	
//	
//	Example Output
//	 [2, 2]
//	
//	
//	Example Explanation
//	 There is only 1 solution for A = 4.


public class PrimeSum {
	public int[] primesum(int A) {
		int[] ans = new int[2];
		for(int i=2; i<A; i++) {
			if(!isPrime(i)) {
				continue;
			}
			if(isPrime(A-i)) {
				ans[0] = i;
				ans[1] = A-i;
				break;
			}
		}
		return ans;
    }
	
	public int getSPF(int n) {
		for(int i=2; i<n; i++) {
			if(n%i == 0) {
				return i;
			}
		}
		return n;
	}
	
	public boolean isPrime(int n) {
		for(int i = 2; i<n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		PrimeSum ps = new PrimeSum();
		int[] ans = ps.primesum(10);
		System.out.println(ans[0]+" "+ans[1]);
	}
	
	public List<List<Integer>> get(){
		ArrayList<List<Integer>>  ans= new ArrayList<>();
		return ans;
	}

}
