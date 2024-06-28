package com.tarif.day051.dsa.trees1.structureandtraversal;

import java.util.HashMap;

public class BinaryTreeFromPreOrderAndPostOrder {
	HashMap<Integer, Integer> map;
	public TreeNode buildTree(int[] in, int[] pre) {
		this.map = new HashMap<>();
		for(int i=0; i<in.length; i++) {
			this.map.put(in[i], i);
		}
		return tree(in, pre, 0, in.length-1, 0);
    }
	
	public TreeNode tree(int[] in, int[] pre, int inL, int inR, int preL) {
		if(inL>inR) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preL]);
		
		int ind = map.get(pre[preL]);
		int d = ind-inL;
		root.left = tree(in, pre, inL, ind-1, preL+1);
		root.right = tree(in, pre, ind+1, inR, preL+d+1);
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeFromPreOrderAndPostOrder ab = new BinaryTreeFromPreOrderAndPostOrder();
		int[] in = {2,1,3};
		int[] pre = {1,2,3};
		TreeNode ans = ab.buildTree(in, pre);
		ab.printIn(ans);
	}
	
	public void printIn(TreeNode root) {
		if(root==null) {
			return;
		}
		printIn(root.left);
		System.out.print(root.val+" ");
		printIn(root.right);
	}
}
