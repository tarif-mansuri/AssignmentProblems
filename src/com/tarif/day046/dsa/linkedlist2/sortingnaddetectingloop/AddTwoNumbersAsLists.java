package com.tarif.day046.dsa.linkedlist2.sortingnaddetectingloop;

import com.tarif.day045.dsa.linkedlist1.introduction.ListNode;

public class AddTwoNumbersAsLists {
	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		if(A==null) {
			return B;
		}
		if(B==null) {
			return A;
		}
		int rem = (A.val+B.val)%10;
		int carry = (A.val+B.val)/10;
		A=A.next;
		B=B.next;
		ListNode head = new ListNode(rem);
		ListNode curr = head;
		while(A!=null && B!=null) {
			rem = (A.val+B.val+carry)%10;
			carry = (A.val+B.val+carry)/10;
			curr.next = new ListNode(rem);
			curr = curr.next;
			A = A.next;
			B = B.next;
		}
		while(A!=null) {
			rem = (A.val+carry)%10;
			carry = (A.val+carry)/10;
			curr.next = new ListNode(rem);
			curr = curr.next;
			A = A.next;
		}
		while(B!=null) {
			rem = (B.val+carry)%10;
			carry = (B.val+carry)/10;
			curr.next = new ListNode(rem);
			curr = curr.next;
			B = B.next;
		}
		if(carry>0) {
			curr.next = new ListNode(carry);
			curr = curr.next;
		}
		return head;
    }
	public static void main(String[] args) {
    	ListNode head1 = new ListNode(9);
		head1.next = new ListNode(7);
		head1.next.next = new ListNode(9);
		head1.next.next.next = new ListNode(8);
		head1.next.next.next.next = new ListNode(8);
		
		ListNode head12 = new ListNode(9);
		head12.next = new ListNode(7);
		head12.next.next = new ListNode(9);
		head12.next.next.next = new ListNode(8);
		//head12.next.next.next.next = new ListNode(8);
		AddTwoNumbersAsLists addTwoNumbersAsList= new AddTwoNumbersAsLists();
		
		ListNode h = addTwoNumbersAsList.addTwoNumbers(head1, head12);
		while(h!=null) {
			System.out.print(h.val+" ");
			h = h.next;
		}
    }

}
