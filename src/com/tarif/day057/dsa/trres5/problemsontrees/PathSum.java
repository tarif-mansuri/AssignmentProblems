package com.tarif.day057.dsa.trres5.problemsontrees;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class PathSum {
	public int hasPathSum(TreeNode root, int B) {
		boolean ans = exists(root, B);
		if(ans) {
			return 1;
		}else {
			return 0;
		}
    }
	
	public boolean exists(TreeNode root, int B) {
		if(root==null) {
			return false;
		}
		if(root.left == null && root.right == null && B==root.val) {
			return true;
		}
		return exists(root.left, B-root.val) || exists(root.right, B-root.val);
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		//head.left.left = new TreeNode(1);
		//head.left.right = new TreeNode(3);
		PathSum pathSum = new PathSum();
		int ans = pathSum.hasPathSum(head, 3);
		System.out.println(ans);
	}

}
