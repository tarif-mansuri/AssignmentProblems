package com.tarif.day013.intermediate.dsa.bitmanipulationsbasics;


//	Problem Description
//	Given two binary strings A and B. Return their sum (also a binary string).
//	
//	
//	Problem Constraints
//	1 <= length of A <= 105
//	
//	1 <= length of B <= 105
//	
//	A and B are binary strings
//	
//	
//	
//	Input Format
//	The two argument A and B are binary strings.
//	
//	
//	
//	Output Format
//	Return a binary string denoting the sum of A and B
//	
//	
//	
//	Example Input
//	Input 1:
//	A = "100"
//	B = "11"
//	Input 2:
//	A = "110"
//	B = "10"
//	
//	
//	Example Output
//	Output 1:
//	"111"
//	Output 2:
//	"1000"
//	
//	
//	Example Explanation
//	For Input 1:
//	The sum of 100 and 11 is 111.
//	For Input 2:
//	 
//	The sum of 110 and 10 is 1000.


public class AddBinaryStrings {
	
	public String addBinary(String A, String B) {
        if(A.length()==0){
            return B;
        }
        if(B.length()==0){
            return A;
        }
        String res = "";
        int ans;
        int carry=0;
        int ai=A.length()-1;
        int bi=B.length()-1;
        while(ai>=0 && bi>=0){
            int a = A.charAt(ai) - '0';
            int b = B.charAt(bi) - '0';
            ans = (carry+a+b)%2;
            carry = (carry+a+b)/2;
            res = ans+res;
            ai--;
            bi--;
        }
        while(ai>=0){
            ans = (A.charAt(ai) - '0' + carry) %2;
            carry = (A.charAt(ai) - '0' + carry) /2;
            res = ans+res;
            ai--;
        }
        while(bi>=0){
            ans = (B.charAt(bi) - '0' + carry) %2;
            carry = (B.charAt(bi) - '0' + carry) /2;
            res = ans+res;
            bi--;
        }
        if(carry>0){
            res = carry+res;
        }
        return res;
    }

}
