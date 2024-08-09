package com.tarif.day069.dsa.graph2.bfsmatrixquestionsandtopologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSort {
	 public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
		 //initiate graph
		 ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		 for(int i=0; i<=A; i++) {
			 graph.add(new ArrayList<Integer>());
		 }
		 for(int i=0; i<B.size(); i++) {
			 int u = B.get(i).get(0);
			 int v = B.get(i).get(1);
			 graph.get(u).add(v);
		 }
		 int[] inDegree = new int[A+1];
		 for(int i=1; i<=A; i++) {
			 ArrayList<Integer> row = graph.get(i);
			 Collections.sort(row);
			 for(Integer I : row) {
				 inDegree[I]++;
			 }
		 }
		 Queue<Integer> listOfZeroInDegreeNode = new PriorityQueue<Integer>();
		 for(int i=1; i<=A; i++) {
			 if(inDegree[i]==0) {
				 listOfZeroInDegreeNode.add(i);
			 }
		 }
		 ArrayList<Integer> ans = new ArrayList<Integer>();
		 while(listOfZeroInDegreeNode.size()>0) {
			 int ele = listOfZeroInDegreeNode.poll();
			 ans.add(ele);
			 ArrayList<Integer> row = graph.get(ele);
			 for(Integer I : row) {
				 inDegree[I]--;
				 if(inDegree[I]==0) {
					 listOfZeroInDegreeNode.add(I);
				 }
			 }
		 }
		 return ans;
	    }
	 
	 public static void main(String[] args) {
		 ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> row = new ArrayList<Integer>();
		 row.add(1);
		 row.add(4);
		 B.add(row);
		 
		 row = new ArrayList<Integer>();
		 row.add(1);
		 row.add(2);
		 B.add(row);
		 
		 row = new ArrayList<Integer>();
		 row.add(4);
		 row.add(2);
		 B.add(row);
		 
		 row = new ArrayList<Integer>();
		 row.add(4);
		 row.add(3);
		 B.add(row);
		 
		 row = new ArrayList<Integer>();
		 row.add(3);
		 row.add(2);
		 B.add(row);
		 
		 row = new ArrayList<Integer>();
		 row.add(5);
		 row.add(2);
		 B.add(row);
		 
		 row = new ArrayList<Integer>();
		 row.add(3);
		 row.add(5);
		 B.add(row);
		 
		 row = new ArrayList<Integer>();
		 row.add(8);
		 row.add(2);
		 B.add(row);
		 
		 row = new ArrayList<Integer>();
		 row.add(8);
		 row.add(6);
		 B.add(row);
		 
		 TopologicalSort obj = new TopologicalSort();
		 
		 ArrayList<Integer> ans = obj.solve(8, B);
		 
		 for(Integer I : ans) {
			 System.out.print(I+" ");
		 }
	 }

}
