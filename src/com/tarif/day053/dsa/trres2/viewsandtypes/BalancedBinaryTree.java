package com.tarif.day053.dsa.trres2.viewsandtypes;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class BalancedBinaryTree {
	
	boolean isHB = true;
    public int isBalanced(TreeNode A) {
        isHB = true;
        getHeight(A);
        if(isHB) {
        	return 1;
        }else {
        	return 0;
        }
    }
    public int getHeight(TreeNode root) {
    	if(root==null) {
    		return -1;
    	}
    	int l = getHeight(root.left);
    	int r = getHeight(root.right);
    	if(Math.abs(l-r)>1) {
    		isHB = false;
    	}
    	return Math.max(l, r)+1;
    }
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.left.left = new TreeNode(4);
		//head.left.right = new TreeNode(5);
		//head.right.left = new TreeNode(6);
		//head.right.right = new TreeNode(7);
		BalancedBinaryTree leverOrder = new BalancedBinaryTree();
		int ans = leverOrder.isBalanced(head);
		System.out.println(ans);
	}
}
