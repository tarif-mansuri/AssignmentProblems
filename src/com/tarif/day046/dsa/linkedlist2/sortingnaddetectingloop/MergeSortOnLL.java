package com.tarif.day046.dsa.linkedlist2.sortingnaddetectingloop;

import com.tarif.day045.dsa.linkedlist1.introduction.ListNode;

public class MergeSortOnLL {
	public ListNode sortList(ListNode A) {
        if(A== null || A.next==null){
            return A;
        }
        ListNode mid = getMiddle(A);
        
        ListNode h1 = A;
        ListNode h2 = mid.next;
        mid.next = null;
        h1 = sortList(h1);
        h2 = sortList(h2);
        ListNode head = mergeTwoLists(h1, h2);
        return head;

    }
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A==null){
            return B;
        }
        if(B==null){
            return A;
        }
        ListNode head;
        if(A.val<B.val){
            head = A;
            A = A.next;
        }else{
            head = B;
            B= B.next;
        }
        ListNode curr = head;
        while(A!=null && B!=null){
            if(A.val<B.val){
                curr.next = A;
                A = A.next;
                curr = curr.next;
            }else{
                curr.next = B;
                B = B.next;
                curr = curr.next;
            }
        }
        if(A!=null){
            curr.next = A;
        }else{
            curr.next = B;
        }
        return head;
    }
    public ListNode getMiddle(ListNode A) {
        if(A==null){
            return A;
        }
        ListNode sp = A;
        ListNode fp = A;
        while(fp.next!=null &&fp.next.next!=null){
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(19);
		head.next = new ListNode(2);
		head.next.next = new ListNode(9);
		head.next.next.next = new ListNode(22);
		head.next.next.next.next = new ListNode(5);
		MergeSortOnLL ms = new MergeSortOnLL();
		ListNode ans = ms.sortList(head);
		ListNode h = ans;
		while(h!=null) {
			System.out.print(h.val+" ");
			h = h.next;
		}
    }

}
