package com.tarif.day029.dsa.math2.combinatoricsbasics;

//	Problem Description
//	Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
//	
//	For example:
//	
//	    1 -> A
//	    2 -> B
//	    3 -> C
//	    ...
//	    26 -> Z
//	    27 -> AA
//	    28 -> AB 
//	
//	
//	Problem Constraints
//	1 <= A <= 109
//	
//	
//	
//	Input Format
//	First and only argument of input contains single integer A
//	
//	
//	
//	Output Format
//	Return a string denoting the corresponding title.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	A = 3
//	Input 2:
//	
//	 
//	A = 27
//	
//	
//	Example Output
//	Output 1:
//	
//	"C"
//	Output 2:
//	
//	"AA"
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 
//	3 corrseponds to C.
//	Explanation 2:
//	
//	    1 -> A,
//	    2 -> B,
//	    3 -> C,
//	    ...
//	    26 -> Z,
//	    27 -> AA,
//	    28 -> AB 


public class ExcelColumnTitle {
	
	public String convertToTitle(int A) {
		StringBuilder sb = new StringBuilder();
		while(A>0) {
			int rem = (A-1)%26 +'A';
			char c = (char)rem;
			sb.append(c);
			A = (A-1)/26;
		}
		return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		ExcelColumnTitle exColTitle = new ExcelColumnTitle();
		System.out.print(exColTitle.convertToTitle(27));	
	}

}
