package com.tarif.day048.dsa.stack1.implementationandbasicproblems;

import java.util.Stack;

public class InfixToPostfix {
	public String solve(String A) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			//System.out.print(c);
			if (c >= 'a' && c <= 'z') {
				sb.append(c);
			} else if (c == ')') {
				char k = stack.pop();
				while(k!='(') {
					sb.append(k);
					k = stack.pop();
				}
			} else if (stack.isEmpty() || c == '(' || stack.peek() == '(' || pref(c) > pref(stack.peek())) {
				stack.push(c);
			}else {
				while(!stack.isEmpty() && pref(stack.peek())>=pref(c)) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}

		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public int pref(char c) {
		switch (c) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		case '^':
			return 2;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		InfixToPostfix iTop = new InfixToPostfix();
		String exp = "q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)";
		System.out.println(iTop.solve(exp));
	}

}
