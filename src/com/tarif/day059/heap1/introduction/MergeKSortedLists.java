package com.tarif.day059.heap1.introduction;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> a) {
		ListNode h = null;
		ListNode t = null;
//		PriorityQueue<Element> pq = new PriorityQueue<Element>(
//				
//				new Comparator<Element>() {
//						@Override
//						public int compare(Element a, Element b) {
//							return a.head.val - b.head.val;
//						}
//		});
		
		PriorityQueue<Element> pq = new PriorityQueue<Element>((e1, e2)-> e1.head.val - e2.head.val);

		for(int i=0; i<a.size(); i++) {
			if(a.get(i)!=null) {
				ListNode head = a.get(i);
				Element e = new Element(i, head);
				pq.add(e);
				a.set(i, head.next);
			}
		}
		while(pq.size()>0) {
			Element e1 = pq.poll();
			ListNode temp = e1.head;
			if(t == null) {
				h = temp;
				t = temp;
			}else {
				t.next = temp;
				t = t.next;
			}
			if(a.get(e1.listIndex)!=null) {
				pq.add(new Element(e1.listIndex, a.get(e1.listIndex)));
				a.set(e1.listIndex, a.get(e1.listIndex).next);
			}
		}
		
		return h;
	}
	
	public static void main(String[] args) {
		MergeKSortedLists obj = new MergeKSortedLists();
		ArrayList<ListNode> a = new ArrayList<ListNode> ();
		
		ListNode h = new ListNode(1);
		h.next = new ListNode(10);
		h.next.next = new ListNode(20);
		a.add(h);
		
		h = new ListNode(4);
		h.next = new ListNode(11);
		h.next.next = new ListNode(13);
		a.add(h);
		
		h = new ListNode(3);
		h.next = new ListNode(8);
		h.next.next = new ListNode(9);
		a.add(h);
		
		h = obj.mergeKLists(a);
		while(h!=null) {
			System.out.print(h.val+" ");
			h = h.next;
		}
	}
	
	
}

class Element {
	int listIndex;
	ListNode head;

	Element(int listIndex, ListNode head) {
		this.listIndex = listIndex;
		this.head = head;
	}
}
