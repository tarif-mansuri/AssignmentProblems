package com.tarif.day050.dsa.queues.implementationsandproblems;

import java.util.Stack;

public class QueueUsingStacks {
	/** Initialize your data structure here. */
    private static Stack<Integer> s1; 
    private static Stack<Integer> s2;
    QueueUsingStacks() {
        s1 = new Stack<Integer>();
        s2  = new Stack<Integer>();
    }
    
    /** Push element X to the back of queue. */
    static void push(int X) {
        s1.push(X);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        if(s2.isEmpty()) {
        	while(!s1.isEmpty()) {
        		s2.push(s1.pop());
        	}
        }
        return s2.pop();
    }
    
    /** Get the front element of the queue. */
    static int peek() {
    	if(s2.isEmpty()) {
        	while(!s1.isEmpty()) {
        		s2.push(s1.pop());
        	}
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    static boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()) {
        	return true;
        }else {
        	return false;
        }
    }

}
