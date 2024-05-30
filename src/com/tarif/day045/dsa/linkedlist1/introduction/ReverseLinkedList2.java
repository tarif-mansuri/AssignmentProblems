package com.tarif.day045.dsa.linkedlist1.introduction;

public class ReverseLinkedList2 {
	    public ListNode reverseBetween(ListNode A, int B, int C) {
	        if(B==1 && C==1){
	            return A;
	        }
	        ListNode head = A;
	        if(B==1) {
	        	return reverseList(head, C);
	        }
	        while(head!=null){
	            if(head.next.val == B){
	            	head.next = reverseList(head.next, C);
	                break;
	            }
	            head = head.next;
	        }
	        return A;
	        
	    }
	    public ListNode reverseList(ListNode head, int c) {
	         ListNode prev = null;
	        ListNode curr = head;
	        ListNode remainingList = null;
	        while(curr!=null){
	          if( curr.val==c){
	              remainingList = curr.next;
	              curr.next = prev;
	              prev = curr;
	              break;
	          }  
	          ListNode next = curr.next;
	          curr.next = prev;
	          prev = curr;
	          curr = next;
	        }
	        head.next = remainingList;
	        return prev;
	    }
	    
	    public static void main(String[] args) {
	    	ListNode head = new ListNode(1);
	    	head.next = new ListNode(2);
	    	head.next.next = new ListNode(3);
	    	ReverseLinkedList2 ll = new ReverseLinkedList2();
	    	ListNode ans = ll.reverseBetween(head,1,2);
	    	while(ans !=null) {
	    		System.out.print(ans.val+" ");
	    		ans = ans.next;
	    	}
	    }

}
