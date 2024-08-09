package com.tarif.day070.dsa.graph3.mstprimsandkruskalanddijkestra;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConstructionCost {
	public int solve(int A, int[][] B) {
		// A --> Nodes from 1 to A
		// B --> Weighted graph u--> B[i][0] v--> B[i][1] w--> B[i][2]

		// Initializing graph
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i <= A; i++) {
			graph.add(new ArrayList<Edge>());
		}
		for(int i=0; i<B.length; i++) {
			int u = B[i][0];
			int v = B[i][1];
			int w = B[i][2];
			graph.get(u).add(new Edge(u,v,w));
			graph.get(v).add(new Edge(v,u,w));
		}
		
		Queue<Edge> pq = new PriorityQueue<Edge>((a,b)->a.w-b.w);
		int cost = 0;
		boolean[] visited = new boolean[A+1];
		visited[1] = true;
		for(Edge e : graph.get(1)) {
				pq.add(e);
		}
		int MOD = 1000000007;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.v]) {
				continue;
			}
			visited[e.v] = true;
			cost =(cost%MOD + e.w%MOD)%MOD;
			for(Edge e1 : graph.get(e.v)) {
				if(!visited[e1.v]) {
					pq.add(e1);
				}
			}
		}
		return cost;
	}
	
	public static void main(String[] args) {
		ConstructionCost obj = new ConstructionCost();
		int[][] B = { {1, 2, 20},
		        		{2, 3, 17}
		        		};
		System.out.println(obj.solve(3, B));
	}
}
