package com.tarif.day068.dsa.graph1.introductiondfscycledetection;

import java.util.ArrayList;

public class CycleInDirectedGraph {
	static boolean[] visited;
	static boolean[] path;
	public int solve(int A, int[][] B) {
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
		visited = new boolean[A+1];
		path = new boolean[A+1];
		for(int i=1; i<=A; i++) {
			if(!visited[i] && dfs(graph, i)) {
				return 1;
			}
		}
		return 0;
    }
	
	public boolean dfs(ArrayList<ArrayList<Integer>> graph, int u) {
		visited[u] = true;
		path[u] = true;
		for(Integer v : graph.get(u)) {
			if(path[v]) {
				return true;
			}
			if(!visited[v] && dfs(graph, v)) {
				return true;
			}
		}
		path[u] = false;
		return false;
	}
	
	public static void main(String[] args) {
		int[][] B = {{1,2},{2,3},{3,4},{4,5}};
		CycleInDirectedGraph obj = new CycleInDirectedGraph();
		int ans = obj.solve(5, B);
		System.out.println(ans);
	}
}
