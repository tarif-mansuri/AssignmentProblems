package com.tarif.day053.dsa.trres2.viewsandtypes;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class RightViewOfTree {
	public int[] solve(TreeNode A) {
		if(A==null) {
			return new int[0];
		}
		ArrayList<Integer> ans = new ArrayList<>();
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.add(A);
		TreeNode last = A;
		while(!q.isEmpty()) {
			TreeNode popped = q.poll();
			if(last == popped) {
				ans.add(popped.val);
				
				if(popped.left!=null) {
					q.add(popped.left);
				}
				if(popped.right!=null) {
					q.add(popped.right);
				}
				last = q.peekLast();
			}else {
				if(popped.left!=null) {
					q.add(popped.left);
				}
				if(popped.right!=null) {
					q.add(popped.right);
				}
			}
		}
		int[] res = new int[ans.size()];
		for(int i=0; i<ans.size(); i++) {
			res[i] = ans.get(i);
		}
		return res;
    }
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);
		RightViewOfTree rightView = new RightViewOfTree();
		int[] ans = rightView.solve(head);
		for(int i=0; i<ans.length; i++) {
				System.out.print(ans[i]+" ");
		}
	}
}

