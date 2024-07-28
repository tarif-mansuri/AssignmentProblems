package com.tarif.day062.dsa.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FlipkartEffectiveInventoryManagement {
	public int solve(int[] A, int[] B) {
		ArrayList<Item> itemList = new ArrayList<>();
		for(int i=0; i<A.length; i++) {
			Item item = new Item(A[i], B[i]);
			itemList.add(item);
		}
		Collections.sort(itemList);
//		for(Item x : itemList){
//			System.out.println(x.expiry+" "+x.profit);
//		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int profit = 0;
		int time = 0;
		for(Item item : itemList) {
			if(item.expiry>time) {
				pq.add(item.profit);
				profit +=item.profit;
				time++;
			}else {
				if(item.profit>pq.peek()) {
					profit = profit - pq.poll();
					pq.add(item.profit);
					profit +=item.profit;
				}
			}
		}
		return profit;
    }
	
	public static void main(String[] args) {
		int[] A = {3, 8, 7, 5};
		int[] B = {3, 1, 7, 19};
		FlipkartEffectiveInventoryManagement obj = new FlipkartEffectiveInventoryManagement();
		int ans = obj.solve(A, B);
		System.out.println(ans);
	}

}
class Item implements Comparable<Item>{
	int expiry;
	int profit;
	Item(int ex, int pro){
		this.expiry = ex;
		this.profit = pro;
	}
	
	public int compareTo(Item i) {
		return this.expiry - i.expiry;
	}
}
