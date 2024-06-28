package com.tarif.day041.dsa.searching2.binarysearchproblems;


//	Problem Description
//	You are given three positive integers, A, B, and C.
//	
//	Any positive integer is magical if divisible by either B or C.
//	
//	Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
//	
//	Note: Ensure to prevent integer overflow while calculating.
//	
//	
//	
//	Problem Constraints
//	1 <= A <= 109
//	
//	2 <= B, C <= 40000
//	
//	
//	
//	Input Format
//	The first argument given is an integer A.
//	
//	The second argument given is an integer B.
//	
//	The third argument given is an integer C.
//	
//	
//	
//	Output Format
//	Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = 1
//	 B = 2
//	 C = 3
//	Input 2:
//	
//	 A = 4
//	 B = 2
//	 C = 3
//	
//	
//	Example Output
//	Output 1:
//	
//	 2
//	Output 2:
//	
//	 6
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 1st magical number is 2.
//	Explanation 2:
//	
//	 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.


public class AthMagicalNumber {
	public int solve(int a, int b, int c) {
		long A = a;
		long B = b;
		long C = c;
        int MOD = 1000000007;
        long l = Math.min(B,C);
        long r = A*Math.min(B,C);
        long gcdNumber = gcd(B,C);
        long lcm = (B*C)/gcdNumber;
        while(l<=r){
            long mid = l + (r-l)/2;
            long cnt = (mid/B + mid/C) - mid/lcm;
            if (cnt == A && (mid%B==0 || mid%C ==0)){
                return (int)(mid%MOD);
            }
            if(cnt<A){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }

    public long gcd(long a, long b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    }
    
    public static void main(String[] args) {
    	AthMagicalNumber amn = new AthMagicalNumber();
    	System.out.println(amn.solve(807414236, 3788, 38141));
    }
}
