package com.tarif.day050.dsa.queues.implementationsandproblems;

import java.util.Deque;
import java.util.LinkedList;

public class ParkingIcecreamTruck {
	public int[] slidingMaximum(final int[] A, int B) {
		int[] ans = new int[A.length-B+1];
		Deque<Integer> deQueue = new LinkedList<Integer>();
		for(int i=0; i<B; i++) {
			while(!deQueue.isEmpty() && A[deQueue.getLast()]<A[i]) {
				deQueue.removeLast();
			}
			deQueue.addLast(i);
		}
		int ind = 0;
		ans[ind++] = deQueue.getFirst();
		for(int i=B; i<A.length; i++) {
			if(deQueue.getFirst() == i-B) {
				deQueue.removeFirst();
			}
			while(!deQueue.isEmpty() && A[deQueue.getLast()]<A[i]) {
				deQueue.removeLast();
			}
			deQueue.addLast(i);
			ans[ind++] = deQueue.getFirst();
		}
		for(int i=0; i<ans.length; i++) {
			ans[i] = A[ans[i]];
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 2, 7, 1, 3, 6};
		ParkingIcecreamTruck piceTruck = new ParkingIcecreamTruck();
		int[] ans = piceTruck.slidingMaximum(A, 6);
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
