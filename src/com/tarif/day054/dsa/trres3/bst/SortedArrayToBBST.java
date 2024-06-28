package com.tarif.day054.dsa.trres3.bst;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class SortedArrayToBBST {
	public TreeNode sortedArrayToBST(final int[] A) {
		return convert(A, 0, A.length-1);
    }
	
	public TreeNode convert(final int[] arr, int l, int r) {
		if(l>r) {
			return null;
		}
		int mid = (l+r)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = convert(arr, l, mid-1);
		root.right = convert(arr, mid+1, r);
		return root;
	}

}
