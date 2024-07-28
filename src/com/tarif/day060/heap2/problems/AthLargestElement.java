package com.tarif.day060.heap2.problems;

import java.util.PriorityQueue;

public class AthLargestElement {
	public int[] solve(int A, int[] B) {
		int[] ans = new int[B.length];
		if(A>B.length) {
			return new int[0];
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
		for(int i = 0; i<B.length; i++) {
			if(minHeap.size()<A-1) {
				ans[i] = -1;
				minHeap.add(B[i]);
			}else if(minHeap.size()==A-1){
				minHeap.add(B[i]);
				ans[i] = minHeap.peek();
			}else{
				if(B[i]>minHeap.peek()) {
					minHeap.poll();
					minHeap.add(B[i]);
				}
				ans[i] = minHeap.peek();
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		AthLargestElement obj = new AthLargestElement();
		int[] A = {1,2,3,4,5,6};
		int[] ans = obj.solve(4, A);
		for(int i=0; i<A.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}
