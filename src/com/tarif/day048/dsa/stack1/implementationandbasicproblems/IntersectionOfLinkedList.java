package com.tarif.day048.dsa.stack1.implementationandbasicproblems;

import com.tarif.day045.dsa.linkedlist1.introduction.ListNode;

public class IntersectionOfLinkedList {
	public ListNode getIntersectionNode(ListNode A, ListNode B) {
		int lA = 0;
		ListNode head = A;
		while (head != null) {
			lA++;
			head = head.next;
		}

		int lB = 0;
		head = B;
		while (head != null) {
			lB++;
			head = head.next;
		}
		if (lA > lB) {
			int k = lA - lB;
			while (k-- > 0) {
				A = A.next;
			}
		}
		if (lA < lB) {
			int k = lB - lA;
			while (k-- > 0) {
				B = B.next;
			}
		}
		while (A != null && B != null && A != B) {
			A = A.next;
			B = B.next;
		}
		if (A == B) {
			return A;
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		IntersectionOfLinkedList intersectionOfLL = new IntersectionOfLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode head2 = new ListNode(7);
		head2.next = new ListNode(20);
		head2.next.next = head.next.next;
		
		ListNode ans = intersectionOfLL.getIntersectionNode(head, head2);
		while(ans!=null) {
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
	}
}
