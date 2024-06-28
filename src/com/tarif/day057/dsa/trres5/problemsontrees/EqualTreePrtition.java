package com.tarif.day057.dsa.trres5.problemsontrees;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class EqualTreePrtition {
	private boolean ans = false;
	public int solve(TreeNode A) {
		ans = false;
		int sum = getSum(A);
		checkSum(A, sum);
		if(ans) {
			return 1;
		}else {
			return 0;
		}
    }
	public int getSum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		else return root.val + getSum(root.left) + getSum(root.right);
	}
	
	public int checkSum(TreeNode root, int sum) {
		if(root==null) {
			return 0;
		}
		int total = root.val + checkSum(root.left, sum) + checkSum(root.right, sum);
		if(2*total == sum) {
			ans = true;
			return 0;
		}
		return total;
	}
	
	public static void main(String[] args) {
		EqualTreePrtition equalTreePartition = new EqualTreePrtition();
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		//head.left.left = new TreeNode(1);
		//head.left.right = new TreeNode(3);
		int ans = equalTreePartition.solve(head);
		System.out.println(ans);
	}

}
