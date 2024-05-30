package com.tarif.day041.dsa.searching2.binarysearchproblems;

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
