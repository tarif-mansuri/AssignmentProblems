package com.tarif.day054.dsa.trres3.bst;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class DeleteANodeInBST {
	public TreeNode solve(TreeNode root, int B) {
		if(root==null) {
			return root;
		}
		if(B< root.val) {
			root.left = solve(root.left, B);
		}else if(B > root.val) {
			root.right = solve(root.right, B);
		}else {
			if(root.left==null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}else {
				TreeNode temp = root.left;
				while(temp.right!=null) {
					temp = temp.right;
				}
				root.left = solve(root.left, temp.val);
				temp.left = root.left;
				temp.right = root.right;
				return temp;
			}
		}
		return root;
    }
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(5);
		head.right = new TreeNode(15);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(6);
		head.right.left = new TreeNode(12);
		//head.right.right = new TreeNode(7);
		DeleteANodeInBST searchInBST = new DeleteANodeInBST();
		TreeNode temp = searchInBST.solve(head, 5);
		searchInBST.print(temp);
		
	}
	
	public void print(TreeNode temp) {
		if(temp == null) {
			return;
		}
		System.out.print(temp.val+" ");
		print(temp.left);
		print(temp.right);
	}
}
