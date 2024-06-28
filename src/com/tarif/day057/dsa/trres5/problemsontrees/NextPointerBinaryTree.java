package com.tarif.day057.dsa.trres5.problemsontrees;

import java.util.Deque;
import java.util.LinkedList;

public class NextPointerBinaryTree {
	public void connect(TreeLinkNode root) {
        if(root==null) {
        	return;
        }
        Deque<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        TreeLinkNode last = root;
        while(!q.isEmpty()) {
        	TreeLinkNode node = q.poll();
        	if(node.left != null) {
        		q.add(node.left);
        	}
        	if(node.right != null) {
        		q.add(node.right);
        	}
        	if(node == last && !q.isEmpty()) {
        		last = q.getLast();
        	}else if(!q.isEmpty()){
        		node.next = q.getFirst();
        	}
        }
    }
	
	public static void main(String[] args) {
		TreeLinkNode head = new TreeLinkNode(1);
		head.left = new TreeLinkNode(2);
		head.right = new TreeLinkNode(3);
		head.left.left = new TreeLinkNode(1);
		head.left.right = new TreeLinkNode(3);
		head.right.left = new TreeLinkNode(1);
		head.right.right = new TreeLinkNode(3);
		NextPointerBinaryTree obj = new NextPointerBinaryTree();
		obj.connect(head);
	}
}
