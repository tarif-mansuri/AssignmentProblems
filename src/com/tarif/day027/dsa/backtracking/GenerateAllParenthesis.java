package com.tarif.day027.dsa.backtracking;

import java.util.ArrayList;

//Problem Description
//Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
//
//
//
//Problem Constraints
//1 <= A <= 10
//
//
//
//Input Format
//First and only argument is integer A.
//
//
//
//Output Format
//Return a sorted list of all possible parenthesis.
//
//Example Input
//Input 1:
//
//A = 3
//Input 2:
//
//A = 1
//
//Example Output
//Output 1:
//
//[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
//Output 2:
//
//[ "()" ]
//
//
//		Example Explanation
//		Explanation 1:
//
//		 All paranthesis are given in the output list.
//		Explanation 2:
//
//		 All paranthesis are given in the output list.

public class GenerateAllParenthesis {

	public String[] generateParenthesis(int A) {
		ArrayList<String> ans = new ArrayList<>();
		allParenthesis(ans, A, "", 0, 0);
		String[] res = new String[ans.size()];
		int i = 0;
		for (String str : ans) {
			res[i++] = str;
		}
		return res;
	}

	public void allParenthesis(ArrayList<String> ans, int A, String sb, int open, int close) {
		if (sb.length() == 2 * A) {
			String sb2 = new String(sb);
			ans.add(sb2);
			return;
		}
		if (open < A) {
			allParenthesis(ans, A, sb + "(", open + 1, close);
		}

		if (close < open) {
			allParenthesis(ans, A, sb + ")", open, close + 1);
		}

	}

	public static void main(String[] args) {
		GenerateAllParenthesis gap = new GenerateAllParenthesis();
		gap.generateParenthesis(3);

	}

}
