package com.tarif.day068.dsa.graph1.introductiondfscycledetection;

import java.util.ArrayList;

public class PathInDirectedGraph {
	static boolean[] visited;
	//static boolean[] path;
	
	 public int solve(int A, int[][] B) {
		 visited = new boolean[A+1];
		 ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=A; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for(int i=0; i<B.length; i++) {
				int start = B[i][0];
				int end = B[i][1];
				ArrayList<Integer> row = graph.get(start);
				row.add(end);
			}
			if(dfs(graph, 1, A)) {
				return 1;
			}else {
				return 0;
			}
	    }
	 
	 public boolean dfs(ArrayList<ArrayList<Integer>> graph, int u, int B) {
		 	if(u == B) {
		 		return true;
		 	}
			visited[u] = true;
			for(Integer v : graph.get(u)) {
				if(!visited[v] && dfs(graph, v, B)) {
					return true;
				}
			}
			
			return false;
		}
	 
	public static void main(String[] args) {
		int[][] B = {{1,2},{2,3},{3,4},{4,3}};
		PathInDirectedGraph obj = new PathInDirectedGraph();
		int ans = obj.solve(5, B);
		System.out.println(ans);
	}
}
