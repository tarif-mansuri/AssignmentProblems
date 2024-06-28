package com.tarif.day056.dsa.trres4.lcaandmorrisinorder;

import java.util.ArrayList;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class KthSmallestElement {
	public int kthsmallest(TreeNode curr, int k) {
		
		while(curr!=null) {
			if(curr.left == null) {
				if(--k==0) {
					return curr.val;
				}
				curr = curr.right;
			}else {
				TreeNode temp = curr.left;
				while(temp.right != null && temp.right !=curr) {
					temp = temp.right;
				}
				if(temp.right == null) {
					temp.right = curr;
					curr = curr.left;
				}else {
					if(--k==0) {
						return curr.val;
					}
					temp.right = null;
					curr = curr.right;
				}
			}
		}
		
		return 0;
    }
	
	public static void main(String[] args) {
		KthSmallestElement morris = new KthSmallestElement();
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(5);
		head.right = new TreeNode(15);
		head.left.left = new TreeNode(3);
		//head.left.right = new TreeNode(13);
		//head.right.left = new TreeNode(8);
		//head.right.right = new TreeNode(13);
//		head.left.right = new TreeNode(3);
		int list = morris.kthsmallest(head, 4);
    	
    		System.out.print(list);
    	
	}

}
