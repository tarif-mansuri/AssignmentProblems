package com.tarif.day070.dsa.graph3.mstprimsandkruskalanddijkestra;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CommutableIsland {
	 public int solve(int A, int[][] B) {
		 //A --> number of Islands
		 //B[][] --> B[i][0] to B[i][1] with B[i][2] cost
		 
		 //Initialize graph
		 ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		 for(int i=0; i<=A; i++) {
			 graph.add(new ArrayList<Edge>());
		 }
		 for(int i=0; i<B.length; i++) {
			 int u = B[i][0];
			 int v = B[i][1];
			 int w = B[i][2];
			 graph.get(u).add(new Edge(u, v, w));
			 graph.get(v).add(new Edge(v, u, w));
		 }
		 
		 Queue<Edge> pq = new PriorityQueue<Edge>((a,b)-> a.w-b.w);
		 boolean[] visited = new boolean[A+1];
		 visited[1] = true;
		 int cost = 0;
		 ArrayList<Edge> connectedNodes = graph.get(1);
		 for(Edge edge : connectedNodes) {
			 pq.add(edge);
		 }
		 
		 while(!pq.isEmpty()) {
			 Edge minEdge = pq.poll();
			 if(visited[minEdge.v]) {
				 continue;
			 }
			 visited[minEdge.v] = true;
			 cost += minEdge.w;
			 for(Edge edge : graph.get(minEdge.v)) {
				 if(!visited[edge.v]) {
					 pq.add(edge);
				 }
			 }
		 }
		 return cost;
	    }
	 
	 public static void main(String[] args) {
		 CommutableIsland obj = new CommutableIsland();
		 int[][] B = {
				 		{1, 2, 1},
					    {2, 3, 2},
					    {3, 4, 4},
					    {1, 4, 3} 
		 };
		 int A = 4;
		 System.out.println(obj.solve(A, B));
	 }

}
class Edge{
	int u;
	int v;
	int w;
	public Edge(int u, int v, int w) {
		super();
		this.u = u;
		this.v = v;
		this.w = w;
	}
}
