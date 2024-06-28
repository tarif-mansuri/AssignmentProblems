package com.tarif.day053.dsa.trres2.viewsandtypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class VerticalOrderTraversal {
	//peek() Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	//poll() Retrieves and removes the head of this queue, or returns null if this queue is empty.
	
	int minKey = Integer.MAX_VALUE;
	int maxKey = Integer.MIN_VALUE;
	public int[][] verticalOrderTraversal(TreeNode A) {
        minKey = Integer.MAX_VALUE;
	    maxKey = Integer.MIN_VALUE;
		if(A==null) {
			return new int[0][];
		}
		//finding left most key
		updateMinMax(A,0);
		
		HashMap<Integer, ArrayList<Integer>> ansMap = new HashMap<>();
		HashMap<TreeNode, Integer> map = new HashMap<>();
		Queue<TreeNode> s = new LinkedList<TreeNode>();
		s.add(A);
		map.put(A, 0);
		while(!s.isEmpty()) {
			TreeNode node = s.poll();
			if(ansMap.containsKey(map.get(node))) {
				ansMap.get(map.get(node)).add(node.val);
			}else {
				ArrayList<Integer> row = new ArrayList<>();
				row.add(node.val);
				ansMap.put(map.get(node), row);
			}
			if(node.left!=null) {
				s.add(node.left);
				map.put(node.left, map.get(node)-1);
			}
			if(node.right!=null) {
				s.add(node.right);
				map.put(node.right, map.get(node)+1);
			}
		}
		int[][] ans = new int[ansMap.keySet().size()][];
		int line =0;
		while(minKey<=maxKey) {
			ArrayList<Integer> row = ansMap.get(minKey++);
			int[] arr = new int[row.size()];
			for(int i=0; i<arr.length; i++) {
				arr[i] = row.get(i);
			}
			ans[line++] = arr;
		}
		return ans;
    }
	public void updateMinMax(TreeNode node, int ind) {
		if(node==null) {
			return;
		}
		if(minKey>ind) {
			minKey = ind;
		}
		if(ind>maxKey) {
			maxKey = ind;
		}
		updateMinMax(node.left,ind-1);
		updateMinMax(node.right,ind+1);
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(2119);
		head.left = new TreeNode(650);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(1559);
		head.left.right.left = new TreeNode(1325);
		head.left.right.right = new TreeNode(4938);
		//head.right.left = new TreeNode(6);
		//head.right.right = new TreeNode(7);
		VerticalOrderTraversal leverOrder = new VerticalOrderTraversal();
		int[][] ans = leverOrder.verticalOrderTraversal(head);
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}
