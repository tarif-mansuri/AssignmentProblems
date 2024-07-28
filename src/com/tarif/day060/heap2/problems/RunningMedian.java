package com.tarif.day060.heap2.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
	public int[] solve(int[] A) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
				new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							return o2-o1;
						}
					}
				);
		
		
		int[] ans = new int[A.length];
		maxHeap.add(A[0]);
		ans[0] = maxHeap.peek();
		for(int i=1; i<A.length; i++) {
			if(A[i]<maxHeap.peek()) {
				maxHeap.add(A[i]);
				if(maxHeap.size()-minHeap.size()>1) {
					minHeap.add(maxHeap.poll());
				}
			}else {
				minHeap.add(A[i]);
				if(minHeap.size()-maxHeap.size()>0) {
					maxHeap.add(minHeap.poll());
				}
			}
			ans[i] = maxHeap.peek();
		}
		return ans;
    }
	
	public static void main(String[] args) {
		RunningMedian obj = new RunningMedian();
		int[] A = {5, 17, 100, 11};
		A = obj.solve(A);
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}
}
