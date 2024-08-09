package com.tarif.day070.dsa.graph3.mstprimsandkruskalanddijkestra;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
	public int[] solve(int A, int[][] B, int C) {
		//A --> A node numbered from 0 to A-1
		//B --> undirected graph u-->B[i][0], v-->B[i][1], w-->B[i][2]
		//C --> source
		
		//initialize graph
		ArrayList<ArrayList<CostToNode>> graph = new ArrayList<ArrayList<CostToNode>>();
		for(int i=0; i<A; i++) {
			graph.add(new ArrayList<CostToNode>());
		}
		int[] ans = new int[A];
		for(int i=0; i<A; i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		//ans[C] = 0;
		for(int i=0; i<B.length; i++) {
			int u = B[i][0];
			int v = B[i][1];
			int w = B[i][2];
			
			graph.get(u).add(new CostToNode(v, w));
			graph.get(v).add(new CostToNode(u,w));
		}
		Queue<CostToNode> pq = new PriorityQueue<CostToNode>((a,b)->a.w-b.w);
		pq.add(new CostToNode(C, 0));
		while(!pq.isEmpty()) {
			CostToNode ctn = pq.poll();
			if(ans[ctn.n]!=Integer.MAX_VALUE) {
				continue;
			}
			ans[ctn.n] = ctn.w;
			for(CostToNode edg : graph.get(ctn.n)) {
				pq.add(new CostToNode(edg.n, edg.w+ctn.w));
			}
		}
		for(int i=0; i<ans.length; i++) {
			if(ans[i]==Integer.MAX_VALUE) {
				ans[i] = -1;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		
	}

}

class CostToNode{
	int n;
	int w;
	public CostToNode(int n, int w) {
		super();
		this.n = n;
		this.w = w;
	}
}
