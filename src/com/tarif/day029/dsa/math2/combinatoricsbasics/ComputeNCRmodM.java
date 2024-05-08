package com.tarif.day029.dsa.math2.combinatoricsbasics;


//	Problem Description
//	Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
//	
//	x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
//	
//	
//	
//	Problem Constraints
//	1 <= A * B <= 106
//	
//	1 <= B <= A
//	
//	1 <= C <= 106
//	
//	
//	
//	Input Format
//	The first argument given is integer A ( = n).
//	The second argument given is integer B ( = r).
//	The third argument given is integer C ( = m).
//	
//	
//	Output Format
//	Return the value of nCr % m.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = 5
//	 B = 2
//	 C = 13
//	Input 2:
//	
//	 A = 6
//	 B = 2
//	 C = 13
//	
//	
//	Example Output
//	Output 1:
//	
//	 10
//	Output 2:
//	
//	 2
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 The value of 5C2 % 11 is 10.
//	Explanation 2:
//	
//	 The value of 6C2 % 13 is 2.

public class ComputeNCRmodM {
	
	public int solve(int A, int B, int C) {
        int[] arr = new int [A+2];
        arr[0] = 1;

        for(int i=1; i<=A; i++){
        	int j;
            for( j = i+1; j>0; j--) {
            	arr[j] = (arr[j]%C + arr[j-1]%C)%C;
            	if(i==A && j==B) {
            		return arr[j];
            	}
            }
        }
        return 0;
        
    }
	
	public static void main(String[] args) {
		ComputeNCRmodM ncr = new ComputeNCRmodM();
		System.out.println(ncr.solve(6,2,13));
	}

}
