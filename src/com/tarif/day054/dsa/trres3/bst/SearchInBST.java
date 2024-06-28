package com.tarif.day054.dsa.trres3.bst;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class SearchInBST {
	public int solve(TreeNode A, int B) {
        while(A!=null) {
        	if(A.val == B) {
        		return 1;
        	}else if(B< A.val) {
        		A = A.left;
        	}else {
        		A = A.right;
        	}
        }
        return 0;
    }
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);
		SearchInBST searchInBST = new SearchInBST();
		System.out.println(searchInBST.solve(head, 9));
	}
}
