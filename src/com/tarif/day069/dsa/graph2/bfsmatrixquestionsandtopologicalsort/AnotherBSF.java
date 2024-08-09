package com.tarif.day069.dsa.graph2.bfsmatrixquestionsandtopologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AnotherBSF {
	public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<A; i++) {
			graph.add(new ArrayList<Integer>());
		}
		int dummyNode = A;
		for(int i=0; i<B.size(); i++) {
				int u = B.get(i).get(0);
				int v = B.get(i).get(1);
				int w = B.get(i).get(2);
				if(w==1) {
					graph.get(u).add(v);
					graph.get(v).add(u);
				}else {
					graph.add(new ArrayList<Integer>());
					graph.get(u).add(dummyNode);
					graph.get(dummyNode).add(u);
					
					graph.get(dummyNode).add(v);
					graph.get(v).add(dummyNode);
					dummyNode = dummyNode+1;
				}
		}
		boolean[] visited = new boolean[A+dummyNode];
		Queue<Pair> q = new LinkedList<Pair>();
		visited[C] = true;
		q.add(new Pair(C, 0));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.node == D) {
				return p.distance;
			}
			ArrayList<Integer> nearestList = graph.get(p.node);
			for(Integer I: nearestList) {
				if(!visited[I]) {
					q.add(new Pair(I, p.distance+1));
					visited[I] = true;
				}
				
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		AnotherBSF obj = new AnotherBSF();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(3);
		row.add(11);
		row.add(2);
		B.add(row);
		
		row = new ArrayList<Integer>();
		row.add(5);
		row.add(12);
		row.add(1);
		B.add(row);
		
		row = new ArrayList<Integer>();
		row.add(0);
		row.add(7);
		row.add(2);
		B.add(row);
		
		row = new ArrayList<Integer>();
		row.add(5);
		row.add(6);
		row.add(2);
		B.add(row);
		
		row = new ArrayList<Integer>();
		row.add(6);
		row.add(10);
		row.add(1);
		B.add(row);
		
		row = new ArrayList<Integer>();
		row.add(5);
		row.add(9);
		row.add(1);
		B.add(row);
		System.out.println(obj.solve(13, B, 9, 4));
	}

}
class Pair{
	int node;
	int distance;
	public Pair(int node, int distance) {
		super();
		this.node = node;
		this.distance = distance;
	}
}
