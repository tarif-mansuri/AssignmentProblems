package com.tarif.day056.dsa.trres4.lcaandmorrisinorder;

import java.util.ArrayList;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class RecoverABinarySearchTree {
	int first, second, prev;
	public ArrayList<Integer> recoverTree(TreeNode A) {
		prev = Integer.MIN_VALUE;
		boolean flag = true;
		TreeNode curr = A;
		while(curr!=null) {
			if(curr.left==null) {
				if(prev>curr.val) {
					if(flag) {
						first = prev;
						second = curr.val;
						flag = false;
					}else {
						second = curr.val;
						break;
					}
				}
				prev = curr.val;
				curr = curr.right;
			}else {
				TreeNode temp = curr.left;
				while(temp.right !=null && temp.right !=curr) {
					temp = temp.right;
				}
				if(temp.right == null) {
					temp.right = curr;
					curr = curr.left;
				}else {
					if(prev>curr.val) {
						if(flag) {
							first = prev;
							second = curr.val;
							flag = false;
						}else {
							second = curr.val;
							break;
						}
					}
					curr = curr.right;
					temp.right = null;
				}
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(first);
		arr.add(second);
		return arr;
    }
	
	public static void main(String[] args) {
		RecoverABinarySearchTree morris = new RecoverABinarySearchTree();
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(5);
		head.right = new TreeNode(15);
		head.left.left = new TreeNode(3);
		head.left.right = new TreeNode(13);
		head.right.left = new TreeNode(8);
		head.right.right = new TreeNode(13);
//		head.left.right = new TreeNode(3);
		ArrayList<Integer> list = morris.recoverTree(head);
    	for(Integer i : list) {
    		System.out.print(i+" ");
    	}
	}

}
