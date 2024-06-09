package com.tarif.day047.dsa.linkedlist3.problemsanddoublylinkedlist;

import java.util.HashMap;
import java.util.Scanner;

public class LRUCache {
	private Node head;
	private Node tail;
	private HashMap<Integer, Node> map;
	private Integer capacity;
	private int size;

	public LRUCache(int capacity) {
		this.head = null;
		this.tail = null;
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.size = 0;
	}

	public int get(int key) {
		if (this.map.containsKey(key)) {
			Node recentlyUsedNode = map.get(key);
			if (recentlyUsedNode.prev == null && recentlyUsedNode.next == null) {
				return map.get(key).data;
			} else if (recentlyUsedNode == this.head) {
				head = head.next;
				head.prev = null;
				recentlyUsedNode.next = null;
				recentlyUsedNode.prev = tail;
				tail.next = recentlyUsedNode;
				tail = tail.next;
			} else if (recentlyUsedNode.next != null) {
				// remove node
				recentlyUsedNode.prev.next = recentlyUsedNode.next;
				recentlyUsedNode.next.prev = recentlyUsedNode.prev;

				// append at last
				recentlyUsedNode.prev = tail;
				tail.next = recentlyUsedNode;
				tail = tail.next;
				tail.next = null;
			}
			return recentlyUsedNode.data;
		} else {
			return -1;
		}

	}

	public void set(int key, int value) {
		// create a new node
		Node newNode = new Node(key, value);
		if (this.map.containsKey(key)) {
			// Add new node as recent
			newNode.prev = tail;
			tail.next = newNode;
			tail = tail.next;

			// delete already existing node
			Node temp = this.map.get(key);
			if (temp.prev == null && temp.next == null) {
				this.head = null;
				this.tail = null;
			}
			if (temp.prev != null) {
				temp.prev.next = temp.next;
			} else {
				head = temp.next;
			}
			if (temp.next != null) {
				temp.next.prev = temp.prev;
			} else {
				tail = temp.prev;
			}

			// update hashmap
			this.map.replace(key, newNode);
		} else {
			this.map.put(key, newNode);
			if (this.size == 0) {
				head = newNode;
				tail = newNode;
				this.size++;
			} else if (this.size < this.capacity) {
				newNode.prev = tail;
				tail.next = newNode;
				tail = tail.next;
				this.size++;
			} else {
				newNode.prev = tail;
				tail.next = newNode;
				tail = tail.next;
				Node tempHead = head;
				head = head.next;
				head.prev = null;
				this.map.remove(tempHead.key);
			}
		}
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(3);
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 20; i++) {
			int dec = sc.nextInt();
			if (dec == 1) {
				int key = sc.nextInt();
				int value = sc.nextInt();
				lruCache.set(key, value);
			} else if (dec == 9) {
				Node temp = lruCache.head;
				while(temp !=null) {
					int key = temp.key;
					int value = temp.data;
					System.out.println(key+" "+value);
					temp = temp.next;
				}
			} else {
				int key = sc.nextInt();
				System.out.println(lruCache.get(key));
			}
		}
		sc.close();
	}

}

class Node {
	int key;
	int data;
	Node prev;
	Node next;

	public Node(int key, int data) {
		this.key = key;
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}
