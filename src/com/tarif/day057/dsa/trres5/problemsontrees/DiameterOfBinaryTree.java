package com.tarif.day057.dsa.trres5.problemsontrees;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class DiameterOfBinaryTree {
	int dia;
	public int solve(TreeNode A) {
		dia = 0;
		height(A);
		return dia;
    }
	public int height(TreeNode root) {
		if(root==null) {
			return -1;
		}
//		if(root.left==null && root.right == null) {
//			return 0;
//		}
		int l = height(root.left);
		int r = height(root.right);
		dia = Math.max(dia, l+r+2);
		return Math.max(l, r) +1;
	}
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(3);
		
		DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
		int dia = obj.solve(head);
		System.out.println(dia);
	}
}
