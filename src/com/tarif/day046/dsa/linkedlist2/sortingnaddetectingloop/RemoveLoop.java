package com.tarif.day046.dsa.linkedlist2.sortingnaddetectingloop;

import com.tarif.day045.dsa.linkedlist1.introduction.ListNode;

public class RemoveLoop {
	public ListNode solve(ListNode A) {
        if(A==null){
            return A;
        }
        if(A.next == A){
            A.next = null;
            return A;
        }
        ListNode sp = A;
        ListNode fp = A;
        sp = sp.next;
        fp = fp.next.next;
        while(sp!=fp){
            sp = sp.next;
            fp = fp.next.next;
        }
        ListNode start = A;
        if(start == sp){
            while(sp.next!=start){
                sp = sp.next;
            }
            sp.next = null;
            return start;
        }
        while(start.next != sp.next){
            start = start.next;
            sp = sp.next;
        }
        sp.next = null;
        return A;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next;
		RemoveLoop rl = new RemoveLoop();
		rl.solve(head);
		ListNode h = head;
		while(h!=null) {
			System.out.print(h.val+" ");
			h=h.next;
		}
	}

}
