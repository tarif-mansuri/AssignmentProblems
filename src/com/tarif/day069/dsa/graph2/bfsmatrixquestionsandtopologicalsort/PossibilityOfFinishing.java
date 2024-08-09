package com.tarif.day069.dsa.graph2.bfsmatrixquestionsandtopologicalsort;

import java.util.ArrayList;

public class PossibilityOfFinishing {
	public int solve(int A, int[] B, int[] C) {
		//B[i] --> C[i]
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(A);
		for(int i=0; i<=A; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0; i<B.length; i++) {
			graph.get(B[i]).add(C[i]);
		}

		boolean[] visited = new boolean[A+1];
		boolean[] path = new boolean[A+1];
		for(int i=1; i<=A; i++) {
			if(!visited[i] && dfs(graph, i, visited, path)) {
				return 0;
			}
		}
		return 1;
    }
	
	public boolean dfs(ArrayList<ArrayList<Integer>> graph, int u, boolean[] visited, boolean[] path) {
		visited[u] = true;
		path[u] = true;
		for(Integer v: graph.get(u)) {
			if(path[v]) {
				return true;
			}
			if(!visited[v] && dfs(graph, v, visited, path)) {
				return true;
			}
		}
		path[u] = false;
		return false;
	}
	
	public static void main(String[] args) {
		PossibilityOfFinishing obj = new PossibilityOfFinishing();
		int[] B = {1, 2, 3};
		int[] C = {2, 3, 1};
		int ans = obj.solve(3, B, C);
		System.out.println(ans);
	}
}
