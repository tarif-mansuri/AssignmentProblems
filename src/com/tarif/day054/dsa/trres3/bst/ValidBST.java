package com.tarif.day054.dsa.trres3.bst;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class ValidBST {
	boolean isValid = true;
	public int isValidBST(TreeNode A) {
		isValid = true;
		checkValid(A);
		if(isValid) {
			return 1;
		}else {
			return 0;
		}
    }
	public Pair checkValid(TreeNode A) {
		if(A==null) {
			return new Pair(Long.MAX_VALUE, Long.MIN_VALUE);
		}
		Pair l = checkValid(A.left);
		Pair r = checkValid(A.right);
		if(A.val<=l.maxValue || A.val >=r.minValue) {
			isValid = false;
		}
		Pair ans = new Pair(Math.min(A.val, Math.min(r.minValue, l.minValue)), Math.max(A.val, Math.max(l.maxValue, r.maxValue)));
		return ans;
	}
	public static void main(String[] args) {
		TreeNode head = new TreeNode(3);
		head.left = new TreeNode(2);
		head.right = new TreeNode(4);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(3);
//		head.right.left = new TreeNode(8);
//		head.right.left.right = new TreeNode(3);
//		head.left.right = new TreeNode(3);
		ValidBST validBST = new ValidBST();
		System.out.println(validBST.isValidBST(head));
	}
}
class Pair{
	long minValue;
	long maxValue;
	Pair(long min, long max){
		this.minValue = min;
		this.maxValue = max;
	}
}
