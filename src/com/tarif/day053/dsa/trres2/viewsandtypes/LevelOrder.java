package com.tarif.day053.dsa.trres2.viewsandtypes;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class LevelOrder {
	public int[][] solve(TreeNode A) {
		if(A==null) {
			return new int[0][];
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.add(A);
		TreeNode last = A;
		ArrayList<Integer> row = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			TreeNode popped = q.poll();
			row.add(popped.val);
			if(last == popped) {
				ans.add(row);
				row = new ArrayList<Integer>();
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
		int[][] res = new int[ans.size()][];
		for(int i=0; i<ans.size(); i++) {
			row = ans.get(i);
			int[] line = new int[row.size()];
			for(int j=0; j<row.size(); j++) {
				line[j] = row.get(j);
			}
			res[i]= line;
					
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
		LevelOrder leverOrder = new LevelOrder();
		int[][] ans = leverOrder.solve(head);
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}
