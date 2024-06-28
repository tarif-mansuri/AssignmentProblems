package com.tarif.day050.dsa.queues.implementationsandproblems;

import java.util.Deque;
import java.util.LinkedList;

public class PerfactNumbers {
	public String solve(int A) {
        Deque<String> deQueue = new LinkedList<String>();
        if(A==1){
            return "11";
        }else if(A==2){
            return "22";
        }else{
            deQueue.add("1");
            deQueue.add("2");
            for(int i=3; i<=A; i=i+2) {
            	String s = deQueue.pollFirst();
            	StringBuilder a = new StringBuilder(s+"1");
            	deQueue.add(a.toString());
            	if(A==i) {
            		StringBuilder x =new StringBuilder(a);
            		return x.append(a.reverse()).toString();
            	}
            	StringBuilder b = new StringBuilder(s+"2");
            	deQueue.add(b.toString());
            	if(A==i+1) {
            		StringBuilder x = new StringBuilder(b);
            		return x.append(b.reverse()).toString();
            	}
            	
            }
        }
        return null;
    }
	public static void main(String[] args) {
		PerfactNumbers pn = new PerfactNumbers();
		System.out.println(pn.solve(4));
	}
}
