package com.tarif.day059.heap1.introduction;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HeapQueries {
	ArrayList<Integer> ans;
	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
		ans = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<A.size(); i++) {
			int op = A.get(i).get(0);
			int val = A.get(i).get(1);
			if(op==1) {
				if(pq.size()>0) {
					ans.add(pq.poll());
				}else {
					ans.add(-1);
				}
				
			}else {
				pq.add(val);
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		HeapQueries obj = new HeapQueries();
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a = new ArrayList<>();
		a.add(2);
		a.add(3);
		A.add(a);
		
		a = new ArrayList<>();
		a.add(1);
		a.add(-1);
		A.add(a);
		
		a = new ArrayList<>();
		a.add(1);
		a.add(-1);
		A.add(a);
		
		a = new ArrayList<>();
		a.add(1);
		a.add(-1);
		A.add(a);
		
		a = new ArrayList<>();
		a.add(1);
		a.add(-1);
		A.add(a);
		
		a = new ArrayList<>();
		a.add(2);
		a.add(9);
		A.add(a);
		
		a = new ArrayList<>();
		a.add(2);
		a.add(17);
		A.add(a);
		
		a = new ArrayList<>();
		a.add(1);
		a.add(-1);
		A.add(a);
		
		a = new ArrayList<>();
		a.add(2);
		a.add(13);
		A.add(a);
		
		a = obj.solve(A);
		
		for(int i=0; i<a.size(); i++) {
			System.out.print(a.get(i)+" ");
		}
		
	}

}
