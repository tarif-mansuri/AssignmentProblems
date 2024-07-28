package com.tarif.day060.heap2.problems;

import java.util.PriorityQueue;

public class KPlacesApart {
	public int[] solve(int[] A, int B) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<=B; i++) {
			pq.add(A[i]);
		}
		int j=0;
		for(int i=B+1; i<A.length; i++) {
			A[j++] = pq.poll();
			pq.add(A[i]);
		}
		while(!pq.isEmpty()) {
			A[j++] = pq.poll();
		}
		return A;
    }
	public static void main(String[] args) {
		KPlacesApart obj = new KPlacesApart();
		int[] A = {2, 1, 17, 10, 21, 95};
		obj.solve(A, 2);
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}
}
