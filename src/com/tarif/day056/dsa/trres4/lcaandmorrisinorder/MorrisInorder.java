package com.tarif.day056.dsa.trres4.lcaandmorrisinorder;

import java.util.ArrayList;

import com.tarif.day051.dsa.trees1.structureandtraversal.TreeNode;

public class MorrisInorder {
	
    public ArrayList<Integer> solve(TreeNode A) {
    	ArrayList<Integer> ans = new ArrayList<>();
    	if(A==null){
            return ans;
        }
    	TreeNode curr = A;
    	while(curr!=null) {
    		if(curr.left==null) {
    			ans.add(curr.val);
    			curr = curr.right;
    		}else {
    			TreeNode temp = curr.left;
    			while(temp.right != null && temp.right != curr) {
    				temp = temp.right;
    			}
    			if(temp.right==null) {
    				temp.right = curr;
    				curr = curr.left;
    			}else {
    				ans.add(curr.val);
    				curr = curr.right;
    				temp.right = null;
    			}
    		}
    		
    	}
        
        return ans;
    }
    
    public static void main(String[] arg) {
    	MorrisInorder morris = new MorrisInorder();
    	TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(3);
//		head.right.left = new TreeNode(8);
//		head.right.left.right = new TreeNode(3);
//		head.left.right = new TreeNode(3);
		ArrayList<Integer> list = morris.solve(head);
    	for(Integer i : list) {
    		System.out.print(i+" ");
    	}
    }
}
