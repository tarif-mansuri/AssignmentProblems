package com.tarif.day014.intermediate.dsa.strings;


//	Problem Description
//	Given a string A of size N, find and return the longest palindromic substring in A.
//	
//	Substring of string A is A[i...j] where 0 <= i <= j < len(A)
//	
//	Palindrome string:
//	A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
//	
//	Incase of conflict, return the substring which occurs first ( with the least starting index).
//	
//	
//	
//	Problem Constraints
//	1 <= N <= 6000
//	
//	
//	
//	Input Format
//	First and only argument is a string A.
//	
//	
//	
//	Output Format
//	Return a string denoting the longest palindromic substring of string A.
//	
//	
//	
//	Example Input
//	Input 1:
//	A = "aaaabaaa"
//	Input 2:
//	A = "abba
//	
//	
//	Example Output
//	Output 1:
//	"aaabaaa"
//	Output 2:
//	"abba"
//	
//	
//	Example Explanation
//	Explanation 1:
//	We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
//	Explanation 2:
//	We can see that longest palindromic substring is of length 4 and the string is "abba".

public class LongestPalendromicSubstring {
	
	public String longestPalindrome(String A) {
        int n = A.length();
        if(n==1){
            return A;
        }
        int resi = 0;
        int resj = 0;
        int maxL = 1;
        for(int i=1; i<n; i++){
            int l=i-1;
            int r = i+1;
            while(l>=0 && r<n){
                if(A.charAt(l) == A.charAt(r)){
                    int temp = r-l+1;
                    if(temp>maxL){
                        maxL = temp;
                        resi = l;
                        resj = r;
                    }
                    l--;
                    r++;
                }else{
                    break;
                }
                
            }

            l = i-1;
            r = i;
            while(l>=0 && r<n){
                if(A.charAt(l) != A.charAt(r)){
                    break;
                }
                int temp = r-l+1;
                if(temp>maxL){
                    maxL = temp;
                    resi = l;
                    resj = r;
                }
                l--;
                r++;
            }
        }

        return A.substring(resi, resj+1);
        
    }

}
