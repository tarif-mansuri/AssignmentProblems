package com.tarif.day048.dsa.stack1.implementationandbasicproblems;

import java.util.Stack;

public class BalencedParenthesis {
	public int solve(String A) {
		if(A.length()%2!=0){
            return 0;
        }
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if ((c == ')' || c == '}' || c == ']') && stack.isEmpty()) {
				return 0;
			} else if (c == ')' || c == '}' || c == ']') {
				char c2 = stack.pop();
				if (!isPair(c, c2)) {
					return 0;
				}
			} else {
				stack.push(c);
			}

		}
		if(stack.isEmpty()) {
			return 1;
		}else {
			return 0;
		}
	}
	public boolean isPair(char b, char a) {
		if((a=='(' && b==')')  ||  (a=='{' && b=='}')  ||(a=='[' && b==']')) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		BalencedParenthesis bp = new BalencedParenthesis();
		System.out.println(bp.solve("(((((((("));
	}

}
