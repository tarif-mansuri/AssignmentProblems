package com.tarif.day045.dsa.linkedlist1.introduction;

public class LinkedList {
	public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        ListNode node = new ListNode(value);
        if(position==1){
            node.next = head;
            head = node;
            return;
        }
        ListNode h = head;
        while(position-1 != 1 && h!=null){
            h=h.next;
            position--;
        }
        if(h!=null){
            node.next = h.next;
            h.next = node;
        }

    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position==1 && head !=null){
            head = head.next;
            return;
        }
        ListNode h = head;
        while(position-1 != 1 && h!=null){
            h=h.next;
            position--;
        }
        if(h!=null && h.next!=null){
            //node.next = h.next;
            h.next = h.next.next;
        }

    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode h = head;
        while(h!=null){
            System.out.print(h.val+" ");
            h=h.next;
        }
        System.out.println();
    }
    private static ListNode head = null;

    static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) 
		{ 
			val = x; next = null; 
	    }
    }
    
    public static void main(String[] args) {
    	for(int i=1; i<=20;i++) {
    		insert_node(i,i);
    	}
    	print_ll();
    	delete_node(21);
    	print_ll();
    	delete_node(10);
    	print_ll();
    	delete_node(6);
    	delete_node(12);
    	print_ll();
    	print_ll();
    	print_ll();
    	print_ll();
    	delete_node(6);
    	delete_node(12);
    	print_ll();
    	print_ll();
    	
    }

}
