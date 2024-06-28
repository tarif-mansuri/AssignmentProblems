package com.tarif.day051.dsa.trees1.structureandtraversal;

import java.util.HashMap;

public class BinaryTreeFromInOrderAndPostOrder {
	HashMap<Integer, Integer> map;
	public TreeNode buildTree(int[] in, int[] post) {
		this.map = new HashMap<>();
		for(int i=0; i<in.length; i++) {
			this.map.put(in[i], i);
		}
		return tree(in, post, 0, in.length-1, post.length-1);
    }
	
	public TreeNode tree(int[] in, int[] post, int inL, int inR, int postR) {
		if(inL>inR) {
			return null;
		}
		
		TreeNode root = new TreeNode(post[postR]);
		int ind = map.get(post[postR]);
		root.left = tree(in, post, inL, ind-1, postR-(inR-ind)-1);
		root.right = tree(in, post, ind+1, inR, postR-1);
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeFromInOrderAndPostOrder ab = new BinaryTreeFromInOrderAndPostOrder();
		int[] in = {4,2,5,1,6,3,7};
		int[] post = {4,5,2,6,7,3,1};
		TreeNode ans = ab.buildTree(in, post);
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
